package br.edu.ifba.paae.web.filter;

import br.edu.ifba.paae.util.HibernateUtil;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@WebFilter(urlPatterns = "*.jsf")
public class ConexaoHibernateFilter implements Filter{
    private SessionFactory sf;
    
    public void init(FilterConfig config) throws ServletException{
        this.sf = HibernateUtil.getSessionFactory();
    }
    
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain chain) throws ServletException{
        Session currentSession = this.sf.getCurrentSession();
        
        Transaction transaction = null;
        
        try{
            transaction = currentSession.beginTransaction();
            chain.doFilter(servletRequest, servletResponse);
            transaction.commit();
            if(currentSession.isOpen()){
                currentSession.close();
            }
        }catch(Throwable ex){
            try{
                if(transaction.isActive()){
                    transaction.rollback();
                }
            }catch(Throwable t){
                t.printStackTrace();
            }
            throw new ServletException(ex);
        }
    }
    public void destroy(){}
    
}
