package br.edu.ifba.paae.dao.analise;

import br.edu.ifba.paae.entidades.analise.ProgramaSocial;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class ProgramaSocialDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    public ProgramaSocial carregar(Integer codigo){
        return (ProgramaSocial) this.sessao.get(ProgramaSocial.class, codigo);
    }
    public List<ProgramaSocial> listar(){
        return this.sessao.createCriteria(ProgramaSocial.class).list();
    }
    public void salvar(ProgramaSocial programaSocial){
        sessao.saveOrUpdate(programaSocial);
    }
    public void excluir(ProgramaSocial programaSocial){
        sessao.delete(programaSocial);
    }    
    public ProgramaSocial buscarPorAspectoEmAvaliacao(String tipo){
        return (ProgramaSocial) this.sessao.createCriteria(ProgramaSocial.class).add(Restrictions.eq("tipo", tipo)).uniqueResult();
    } 
}
