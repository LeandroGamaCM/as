package br.edu.ifba.as.dao;

import br.edu.ifba.as.entidades.formulario.Aluno;
import br.edu.ifba.as.entidades.usuario.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class UsuarioDAO{
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    // select u from Usuario u, Aluno a where u.usuario = a.usuario AND a.aluno = :codAluno
    // SELECT * FROM Employee e INNER JOIN Team t ON e.Id_team=t.Id_team
    // select e from Employee e inner join e.team
    // SELECT * FROM Employee e, Team t WHERE e.Id_team=t.Id_team
    public Usuario buscarPorAluno(Integer codAluno){
        System.out.println("Executa antes da Query");
        String hql = "select u from Usuario u inner join u.Aluno";
        System.out.println("Executa depois da Query");
        Query c = this.sessao.createQuery(hql);
        System.out.println("Lista size: " + c.list().size());
        c.setString("codAluno", codAluno.toString());
        return (Usuario) c.uniqueResult();
    }
    public Aluno buscarAluno(Integer codUsuario){
        String hql = "select a from Aluno a, Usuario u where u.usuario = a.usuario AND u.usuario = :codUsuario";
        Query c = this.sessao.createQuery(hql);
        c.setString("codUsuario", codUsuario.toString());
        return (Aluno) c.uniqueResult();
    }
    public Usuario carregar(Integer codigo){
        return (Usuario) this.sessao.get(Usuario.class, codigo);
    }
    public List<Usuario> listar(){
        return this.sessao.createCriteria(Usuario.class).list();
    }
    public void salvar(Usuario usuario){
        sessao.saveOrUpdate(usuario);
    }
    public void excluir(Usuario usuario){
        sessao.delete(usuario);
    }
    
}
