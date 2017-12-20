package br.ifba.edu.as.bean;

import br.edu.ifba.as.entidades.usuario.Usuario;
import br.edu.ifba.as.rn.UsuarioRN;
import java.io.Serializable;
import javax.faces.bean.*;

@ManagedBean(name = "usuarioBean")
@ViewScoped // Ver diferença do RequestScoped ----------------------------------
public class UsuarioBean implements  Serializable{
    Usuario usuario = new Usuario();
    
    public void salvar(){
        UsuarioRN usuarioRN = new UsuarioRN();
        usuarioRN.salvar(usuario);
    }

    
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
