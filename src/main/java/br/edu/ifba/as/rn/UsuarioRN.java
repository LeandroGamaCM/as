package br.edu.ifba.as.rn;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.UsuarioDAO;
import br.edu.ifba.as.entidades.usuario.Usuario;

public class UsuarioRN {
    private UsuarioDAO usuarioDAO;

    public UsuarioRN() {
        this.usuarioDAO = DAOFactory.criarUsuarioDAO();
    }
    public void salvar(Usuario usuario){
        Integer cod = usuario.getUsuario();
        if(cod == null || cod == 0){
            this.usuarioDAO.salvar(usuario);
        }else{
            this.usuarioDAO.atualizar(usuario);
        }
    }
    public void excluir(Usuario usuario){
        this.usuarioDAO.excluir(usuario);
    }
    
}
