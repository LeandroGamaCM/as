package br.edu.ifba.as.dao;

import br.edu.ifba.as.entidades.enums.Modalidade;
import br.edu.ifba.as.entidades.formulario.Turma;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class TurmaDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public Turma buscarPorNome(String nome){
        return (Turma) this.sessao.createCriteria(Turma.class).add(Restrictions.like("nome", nome)).uniqueResult();
    }
    
    public List<Turma> buscarPorModalidade(String modalidade){
        return this.sessao.createCriteria(Turma.class).add(Restrictions.like("modalidade", modalidade)).list();
    }

    public List<Turma> buscarPorCurso(String curso){
        return this.sessao.createCriteria(Turma.class).add(Restrictions.like("curso", curso)).list();
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
