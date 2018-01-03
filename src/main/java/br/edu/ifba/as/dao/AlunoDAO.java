package br.edu.ifba.as.dao;

import br.edu.ifba.as.entidades.formulario.Aluno;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class AlunoDAO{
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    public void salvar(Aluno a){
        sessao.saveOrUpdate(a);
    }
    public void excluir(Aluno a){
        sessao.delete(a);
    }
    public Aluno carregar(Integer codigo){
        return (Aluno) this.sessao.get(Aluno.class, codigo);
    }
    
    public List<Aluno> listar(){
        return this.sessao.createCriteria(Aluno.class).list();
    }

    public List<Aluno> buscarPorNome(String nome){
        String hql = "select u from Aluno u where u.nome = :nome";
        Query c = this.sessao.createQuery(hql);
        c.setString("nome", nome);
        return c.list();        
    }
    
    public Aluno buscarPorCPF(Integer cpf){
        String hql = "select u from Aluno u where u.cpf = :cpf";
        Query c = this.sessao.createQuery(hql);
        c.setString("cpf", cpf.toString());
        return (Aluno) c.uniqueResult();
    }    

// cod_turma ou codTurma?
    public List<Aluno> buscarPorTurma(Integer codTurma){
        String hql = "select a from Aluno a, Turma t where t.turma = a.turma AND t.turma = :codTurma";
        Query c = this.sessao.createQuery(hql);
        c.setString("codTurma", codTurma.toString());
        return c.list();
    }
    public List<Aluno> listarPorModalidade(String modalidade){
        String hql = "select a from Aluno a, Turma t where t.turma = a.turma AND t.modalidade = :modalidade";
        Query c = this.sessao.createQuery(hql);
        c.setString("modalidade", modalidade);
        return c.list();
        
    }
    public List<Aluno> listarPorCurso(String curso){
        String hql = "select a from Aluno a, Turma t where t.turma = a.turma AND t.curso = :curso";
        Query c = this.sessao.createQuery(hql);
        c.setString("curso", curso);
        return c.list();        
    }
    public List<Aluno> listarPorModalidadeCurso(String modalidade, String curso){
        String hql = "select a from Aluno a, Turma t where t.turma = a.turma AND t.modalidade = :modalidade AND t.curso = :curso";
        Query c = this.sessao.createQuery(hql);
        c.setString("modalidade", modalidade);
        c.setString("curso", curso);
        return c.list();        
    }
}
