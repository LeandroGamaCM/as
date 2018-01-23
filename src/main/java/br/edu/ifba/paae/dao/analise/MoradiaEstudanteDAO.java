package br.edu.ifba.paae.dao.analise;

import br.edu.ifba.paae.entidades.analise.MoradiaEstudante;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class MoradiaEstudanteDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    public MoradiaEstudante carregar(Integer codigo){
        return (MoradiaEstudante) this.sessao.get(MoradiaEstudante.class, codigo);
    }
    public List<MoradiaEstudante> listar(){
        return this.sessao.createCriteria(MoradiaEstudante.class).list();
    }
    public void salvar(MoradiaEstudante moradiaEstudante){
        sessao.saveOrUpdate(moradiaEstudante);
    }
    public void excluir(MoradiaEstudante moradiaEstudante){
        sessao.delete(moradiaEstudante);
    }    
    public MoradiaEstudante buscarPorAspectoEmAvaliacao(String tipo){
        return (MoradiaEstudante) this.sessao.createCriteria(MoradiaEstudante.class).add(Restrictions.eq("tipo", tipo)).uniqueResult();
    }       
}
