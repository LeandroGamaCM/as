package br.edu.ifba.paae.bean;

import br.edu.ifba.paae.entidades.formulario.Aluno;
import br.edu.ifba.paae.entidades.usuario.Usuario;
import br.edu.ifba.paae.logica.FormularioAluno;
import br.edu.ifba.paae.rn.formulario.AlunoRN;
import br.edu.ifba.paae.rn.formulario.EnderecoRN;
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
    private FormularioAluno formularioAluno;
    
    private String confirmacaoSenha;
    private String novaSenha;
    
    private String telaPerfil = "mostrarDados";
    
    @PostConstruct
    public void init(){
        AlunoRN alunoRN = new AlunoRN();
        UsuarioRN usuarioRN = new UsuarioRN();

        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext external = context.getExternalContext();
        String cpf = external.getRemoteUser();
        
        usuario = usuarioRN.buscarPorLogin(cpf);
        
        if(usuario != null){
            if(!usuario.getPermissao().contains("ROLE_ADMINISTRADOR")){
                aluno = alunoRN.buscarPorCPF(cpf);
                formularioAluno = new FormularioAluno(aluno);
            }else
                System.out.println("\n\tADM!\n");            
        }  
    }

    public void salvar(){
        UsuarioRN usuarioRN = new UsuarioRN();
        
        if(usuario.getSenha().equals(confirmacaoSenha)){
            AlunoRN alunoRN = new AlunoRN();
            EnderecoRN enderecoRN = new EnderecoRN();
            
            alunoRN.salvar(formularioAluno.getAluno());
            enderecoRN.salvar(formularioAluno.getEndereco());
            
            usuario.setSenha(novaSenha);
            usuarioRN.atualizar(usuario);
        }
        else{
            System.out.println("\tSenha antiga incorreta!");
        }
// Mensagem
        changeToMostrarDados();
    }

// Controle de telaPerfil
    public boolean isMostrarDados(){
        return "mostrarDados".equals(this.telaPerfil);
    }
    public void changeToMostrarDados(){
        this.telaPerfil = "mostrarDados";
    }
    public boolean isEditarDados(){
        return "editarDados".equals(this.telaPerfil);
    }
    public void changeToEditarDados(){
        this.telaPerfil = "editarDados";
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

    public FormularioAluno getFormularioAluno() {
        return formularioAluno;
    }

    public void setFormularioAluno(FormularioAluno formularioAluno) {
        this.formularioAluno = formularioAluno;
    }

    public String getTelaPerfil() {
        return telaPerfil;
    }

    public void setTelaPerfil(String telaPerfil) {
        this.telaPerfil = telaPerfil;
    }


    
    
    
}
