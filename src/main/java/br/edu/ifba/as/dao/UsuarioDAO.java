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

    public Usuario buscarPorAluno(Integer codAluno){
        String hql = "select u from Usuario u, Aluno a where u.usuario = a.usuario AND a.aluno = :codAluno";
        Query c = this.sessao.createQuery(hql);
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
        sessao.save(usuario);
    }
    public void atualizar(Usuario usuario){
        if(usuario.getPermissao() == null || usuario.getPermissao().size() == 0){
            Usuario usuarioPermissao = this.carregar(usuario.getUsuario());
            usuario.setPermissao(usuarioPermissao.getPermissao());
            this.sessao.evict(usuarioPermissao);
        }
        this.sessao.update(usuario);
    }
    public void excluir(Usuario usuario){
        sessao.delete(usuario);
    }    
}
