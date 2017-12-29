package br.edu.ifba.as.rn;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.UsuarioDAO;
import br.edu.ifba.as.entidades.formulario.Aluno;
import br.edu.ifba.as.entidades.usuario.Usuario;
import java.util.List;

public class UsuarioRN {
    private UsuarioDAO usuarioDAO;

    public UsuarioRN() {
        this.usuarioDAO = DAOFactory.criarUsuarioDAO();
    }
    public void salvar(Usuario usuario){
        this.usuarioDAO.salvar(usuario);
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
    
}
