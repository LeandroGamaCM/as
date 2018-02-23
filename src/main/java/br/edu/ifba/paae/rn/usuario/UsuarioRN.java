package br.edu.ifba.paae.rn.usuario;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.usuario.UsuarioDAO;
import br.edu.ifba.paae.entidades.formulario.Aluno;
import br.edu.ifba.paae.entidades.usuario.Usuario;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRN {
    private UsuarioDAO usuarioDAO;

    public UsuarioRN() {
        this.usuarioDAO = DAOFactory.criarUsuarioDAO();
    }
    public void salvar(Usuario usuario){
        this.usuarioDAO.salvar(usuario);
    }
    public void atualizar(Usuario usuario){
        this.usuarioDAO.atualizar(usuario);
    }
    public void excluir(Usuario usuario){
        this.usuarioDAO.excluir(usuario);
    }
    public Usuario buscarPorAluno(Integer codAluno){
        return this.usuarioDAO.buscarPorAluno(codAluno);
    }
    public Aluno buscarAluno(Integer codUsuario){
        return this.usuarioDAO.buscarAluno(codUsuario);
    }
    public Usuario carregar(Integer codigo){
        return this.usuarioDAO.carregar(codigo);
    }
    public List<Usuario> listar(){
        return this.usuarioDAO.listar();
    }
    public Usuario buscarPorLogin(String login){
        return this.usuarioDAO.buscarPorLogin(login);
    }
    
    public List<Usuario> listarADMs(){
        List<Usuario> list = new ArrayList<>();
        List<Usuario> todos = listar();
        
        if(todos != null && !todos.isEmpty()){
            for(Usuario u:todos){
                list.add(u);
            }
        }
        return list;
    }
    
    public void criarADM(){
        Usuario usuario = new Usuario();
        usuario.setLogin("000.000.000-00");
        usuario.setSenha("000000");
        usuario.setNome("admin");
        usuario.setAtivo(Boolean.TRUE);
        usuario.getPermissao().add("ROLE_ADMINISTRADOR");
        
        this.usuarioDAO.salvar(usuario);
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
