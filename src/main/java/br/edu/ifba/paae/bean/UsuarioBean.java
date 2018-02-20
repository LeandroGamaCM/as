package br.edu.ifba.paae.bean;

import br.edu.ifba.paae.entidades.formulario.Aluno;
import br.edu.ifba.paae.entidades.formulario.Endereco;
import br.edu.ifba.paae.entidades.usuario.Usuario;
import br.edu.ifba.paae.logica.FormularioAluno;
import br.edu.ifba.paae.logica.Mensagem;
import br.edu.ifba.paae.rn.formulario.AlunoRN;
import br.edu.ifba.paae.rn.formulario.EnderecoRN;
import br.edu.ifba.paae.rn.usuario.UsuarioRN;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
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
                if(formularioAluno.getEndereco() == null){
                    Endereco endereco = new Endereco();
                    endereco.setAluno(aluno);
                    formularioAluno.setEndereco(endereco);
                }
            }else
                System.out.println("\n\tADM!\n");            
        }  
    }
    
    public void salvar(){
        Mensagem mensagem = new Mensagem();
        UsuarioRN usuarioRN = new UsuarioRN();
        String senha = usuarioRN.md5(confirmacaoSenha);
        
        if(usuario.getSenha().equals(senha)){
            if(!usuario.getPermissao().contains("ROLE_ADMINISTRADOR")){
                AlunoRN alunoRN = new AlunoRN();
                EnderecoRN enderecoRN = new EnderecoRN();

                alunoRN.salvar(formularioAluno.getAluno());
                enderecoRN.salvar(formularioAluno.getEndereco());
            }
            usuario.setSenha(novaSenha);
            usuarioRN.atualizar(usuario);
            changeToMostrarDados();
            mensagem.addMensagem("Dados atualizados!", FacesMessage.SEVERITY_INFO);
        }
        else{
            mensagem.addMensagem("Senha antiga incorreta!", FacesMessage.SEVERITY_ERROR);
            System.out.println("\tSenha antiga incorreta!");
        }
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
