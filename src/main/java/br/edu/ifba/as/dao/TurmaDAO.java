package br.edu.ifba.as.dao;

import br.edu.ifba.as.entidades.formulario.Turma;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class TurmaDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    public List<Turma> listarCursos(String modalidade){
        return this.sessao.createCriteria(Turma.class).add(Restrictions.eq("modalidade", modalidade)).list();
    }

    public List<Turma> listarTurmas(String modalidade, String curso){
        return this.sessao.createCriteria(Turma.class).add(Restrictions.eq("modalidade", modalidade)).add(Restrictions.like("curso", curso)).list();
    }
    public Turma buscarTurma(String modalidade, String curso, String turma){
        return (Turma) this.sessao.createCriteria(Turma.class).add(Restrictions.eq("modalidade", modalidade)).add(Restrictions.like("curso", curso)).add(Restrictions.like("nome", turma)).uniqueResult();
    }            
    public Turma carregar(Integer codigo){
        return (Turma) this.sessao.get(Turma.class, codigo);
    }
    public List<Turma> listar(){
        return this.sessao.createCriteria(Turma.class).list();
    }
    public void salvar(Turma turma){
        sessao.saveOrUpdate(turma);
    }
    public void excluir(Turma turma){
        sessao.delete(turma);
    }
    
}
