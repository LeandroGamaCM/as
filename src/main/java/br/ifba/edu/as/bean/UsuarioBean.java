package br.ifba.edu.as.bean;

import br.edu.ifba.as.entidades.usuario.Usuario;
import br.edu.ifba.as.rn.UsuarioRN;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.*;

@ManagedBean(name = "usuarioBean")
@ViewScoped // Ver diferenÃ§a do RequestScoped ----------------------------------
public class UsuarioBean implements  Serializable{
    private Usuario usuario = new Usuario();
    private List<Usuario> usuarios;
    private Integer cpf;
    private String senha;
    
    public void salvar(){
        UsuarioRN usuarioRN = new UsuarioRN();
        usuarioRN.salvar(this.usuario);
        System.out.println("Salvou!\n");
        listar();
    }
    
    public void entrar(){
        UsuarioRN usuarioRN = new UsuarioRN();
        Usuario u = usuarioRN.buscarPorCPF(this.cpf);
        if(u == null){
            System.out.println("\nAcesso negado!\n");
        }else{
            System.out.println("\nAcesso Permitido!\n");
        System.out.println("u.cpf: " + u.getLogin() + "\ncpf: " + this.cpf);
        System.out.println("u.senha: " + u.getSenha() + "\nsenha: " + this.senha);
        }
    }
    public void listar(){
        UsuarioRN usuarioRN = new UsuarioRN();
        this.usuarios = usuarioRN.listar();
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
