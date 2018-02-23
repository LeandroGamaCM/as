package br.edu.ifba.paae.dao.formulario;

import br.edu.ifba.paae.entidades.formulario.InformacoesCurriculares;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class InformacoesCurricularesDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public InformacoesCurriculares buscarPorAluno(Integer codAluno){
        String hql = "select u from InformacoesCurriculares u where u.informacoesCurriculares = :codAluno";
        Query c = this.sessao.createQuery(hql);
        c.setString("codAluno", codAluno.toString());
        return (InformacoesCurriculares) c.uniqueResult();
    }
    public InformacoesCurriculares carregar(Integer codigo){
        return (InformacoesCurriculares) this.sessao.get(InformacoesCurriculares.class, codigo);
    }
    public List<InformacoesCurriculares> listar(){
        return this.sessao.createCriteria(InformacoesCurriculares.class).list();
    }
    public void salvar(InformacoesCurriculares informacoesCurriculares){
        sessao.saveOrUpdate(informacoesCurriculares);
    }
    public void excluir(InformacoesCurriculares informacoesCurriculares){
        sessao.delete(informacoesCurriculares);
    }

    
}
