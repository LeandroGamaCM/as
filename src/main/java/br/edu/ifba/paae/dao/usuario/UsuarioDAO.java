package br.edu.ifba.paae.dao.usuario;

import br.edu.ifba.paae.entidades.formulario.Aluno;
import br.edu.ifba.paae.entidades.usuario.Usuario;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    public Usuario buscarPorLogin(String login){
        String hql = "select u from Usuario u where u.login = :login";
        Query c = this.sessao.createQuery(hql);
        c.setString("login", login);
        return (Usuario) c.uniqueResult();        
    }
    public Usuario carregar(Integer codigo){
        return (Usuario) this.sessao.get(Usuario.class, codigo);
    }
    public List<Usuario> listar(){
        return this.sessao.createCriteria(Usuario.class).list();
    }
    public void salvar(Usuario usuario){
        if(usuario.getSenha() != null)
            usuario.setSenha(md5(usuario.getSenha()));
        sessao.save(usuario);
    }
    public void atualizar(Usuario usuario){
        if(usuario.getPermissao() == null || usuario.getPermissao().isEmpty()){
            Usuario usuarioPermissao = this.carregar(usuario.getUsuario());
            usuario.setPermissao(usuarioPermissao.getPermissao());
            this.sessao.evict(usuarioPermissao);
        }
        if(usuario.getSenha() != null)
            usuario.setSenha(md5(usuario.getSenha()));
        this.sessao.update(usuario);
    }
    public void excluir(Usuario usuario){
        sessao.delete(usuario);
    }    
    
    public static String md5(String senha) {
        String sen = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        sen = hash.toString(16);
        return sen;
    }
}
