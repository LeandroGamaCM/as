package br.ifba.edu.as.bean;

import br.edu.ifba.as.entidades.formulario.Aluno;
import br.edu.ifba.as.entidades.usuario.Usuario;
import br.edu.ifba.as.rn.AlunoRN;
import br.edu.ifba.as.rn.UsuarioRN;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "loginBean")
@ViewScoped
public class LoginBean implements Serializable{
    private Usuario usuario = new Usuario();
    
    private String cpfPagina;
    private String nomePagina;
    private String senhaPagina;
//    private String emailPagina;

    
    public boolean verificaExistencia(){
        UsuarioRN usuarioRN = new UsuarioRN();
        usuario = usuarioRN.buscarPorLogin(cpfPagina);

        if(usuario == null){
// Exibir mensagem
            System.out.println("Usuario Nulo");
            return false;
        }else{
            if(usuario.getAtivo()){
                System.out.println("\n\tEste usuario já está cadastrado!\n");
                return false;
            }else{
                return true;
            }
        }
    }
    
    public void salvar(){
// Exibir mensagem e voltar pra tela de Login
        if(verificaExistencia()){
            atribuirProperties();
            UsuarioRN usuarioRN = new UsuarioRN();
            
            usuarioRN.salvar(usuario);
            System.out.println("\n\tSalvo com Sucesso!\n");
        }    
    }
    
    public void atribuirProperties(){
        AlunoRN alunoRN = new AlunoRN();
        Aluno aluno = alunoRN.buscarPorCPF(cpfPagina);
        if(aluno != null){
            aluno.setNome(nomePagina);
            alunoRN.salvar(aluno);
        }
        UsuarioRN usuarioRN = new UsuarioRN();
        this.usuario.setAtivo(Boolean.TRUE);
        this.usuario.setSenha(senhaPagina);
        
// Esse email deve ser uma variavel diferente do formulario? Porque ele é pra recuperação e lá pra contato
//        usuario.setEmail(emailPagina);
    }

// Getters e Setters

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCpfPagina() {
        return cpfPagina;
    }

    public void setCpfPagina(String cpfPagina) {
        this.cpfPagina = cpfPagina;
    }

    public String getNomePagina() {
        return nomePagina;
    }

    public void setNomePagina(String nomePagina) {
        this.nomePagina = nomePagina;
    }

    public String getSenhaPagina() {
        return senhaPagina;
    }

    public void setSenhaPagina(String senhaPagina) {
        this.senhaPagina = senhaPagina;
    }

}
