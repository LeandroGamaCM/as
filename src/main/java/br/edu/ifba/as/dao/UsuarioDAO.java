package br.edu.ifba.as.dao;

import br.edu.ifba.as.entidades.usuario.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class UsuarioDAO{
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    public Usuario buscarPorCPF(Integer cpf){
        String hql = "select u from Usuario u where u.cpf = :cpf";
        Query c = this.sessao.createQuery(hql);
        c.setString("cpf", cpf.toString());
        return (Usuario) c.uniqueResult();
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
