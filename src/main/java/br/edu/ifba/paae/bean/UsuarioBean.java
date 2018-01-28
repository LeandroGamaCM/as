package br.edu.ifba.paae.bean;

import br.edu.ifba.paae.entidades.formulario.Aluno;
import br.edu.ifba.paae.entidades.usuario.Usuario;
import br.edu.ifba.paae.rn.formulario.AlunoRN;
import br.edu.ifba.paae.rn.usuario.UsuarioRN;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name = "usuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable{
    private Usuario usuario;
    private Aluno aluno = new Aluno();
    private String confirmacaoSenha;
    private String novaSenha;
    
    @PostConstruct
    public void init(){
        AlunoRN alunoRN = new AlunoRN();
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext external = context.getExternalContext();
        String cpf = external.getRemoteUser();
        UsuarioRN usuarioRN = new UsuarioRN();
        usuario = usuarioRN.buscarPorLogin(cpf);
        
        if(usuario != null){
            if(!usuario.getPermissao().contains("ROLE_ADMINISTRADOR")){
                aluno = alunoRN.buscarPorCPF(cpf);
            }else
                System.out.println("\n\tADM!\n");            
        }  
    }

    public void salvar(){
        UsuarioRN usuarioRN = new UsuarioRN();
        usuario.setSenha(novaSenha);
        
        usuarioRN.atualizar(usuario);
    }


// Getters e Setters    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getConfirmacaoSenha() {
        return confirmacaoSenha;
    }

    public void setConfirmacaoSenha(String confirmacaoSenha) {
        this.confirmacaoSenha = confirmacaoSenha;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }
    
    
    
}
