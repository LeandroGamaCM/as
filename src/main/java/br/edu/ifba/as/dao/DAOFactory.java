package br.edu.ifba.as.dao;

import br.edu.ifba.as.util.HibernateUtil;

public class DAOFactory {
    public static AlunoDAO criarAlunoDao(){
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return alunoDAO;
    }
}
