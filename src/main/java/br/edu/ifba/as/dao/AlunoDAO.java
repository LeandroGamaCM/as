package br.edu.ifba.as.dao;

import br.edu.ifba.as.entidades.formulario.Aluno;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

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
        c.setString("nome", nome.toString());
        return c.list();        
    }
    
    public Aluno buscarPorCPF(Integer cpf){
        String hql = "select u from Aluno u where u.cpf = :cpf";
        Query c = this.sessao.createQuery(hql);
        c.setString("cpf", cpf.toString());
        return (Aluno) c.uniqueResult();
    }    
    
}
