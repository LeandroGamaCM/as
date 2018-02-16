package br.edu.ifba.paae.bean;

import br.edu.ifba.paae.emailService.EmailUtils;
import br.edu.ifba.paae.entidades.formulario.Aluno;
import br.edu.ifba.paae.entidades.usuario.Usuario;
import br.edu.ifba.paae.logica.FormularioAluno;
import br.edu.ifba.paae.rn.formulario.AlunoRN;
import br.edu.ifba.paae.rn.formulario.EnderecoRN;
import br.edu.ifba.paae.rn.usuario.UsuarioRN;
import java.io.Serializable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;

@ManagedBean(name = "usuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable{
    private Usuario usuario;
    private Aluno aluno = new Aluno();
    private FormularioAluno formularioAluno;
    
    private String confirmacaoSenha;
    private String novaSenha;
    
    private String telaPerfil = "mostrarDados";
    
    private String cpfRedefinirSenha;
    
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
        System.out.println("\t(Criptografada)Usuario.getSenha: " +usuario.getSenha());
        String senha = usuarioRN.md5(confirmacaoSenha);
        System.out.println("\t(Criptografada)Senha: " + senha);
        
        if(usuario.getSenha().equals(senha)){
            if(!usuario.getPermissao().contains("ROLE_ADMINISTRADOR")){
                AlunoRN alunoRN = new AlunoRN();
                EnderecoRN enderecoRN = new EnderecoRN();

                alunoRN.salvar(formularioAluno.getAluno());
//                enderecoRN.salvar(formularioAluno.getEndereco());
            }
            usuario.setSenha(novaSenha);
            usuarioRN.atualizar(usuario);
        }
        else{
            System.out.println("\tSenha antiga incorreta!");
        }
// Mensagem
        changeToMostrarDados();
    }
    
    public void redefinirSenha(){
        UsuarioRN usuarioRN = new UsuarioRN();
        if(cpfRedefinirSenha != null){
            Usuario user = usuarioRN.buscarPorLogin(cpfRedefinirSenha);
            if(user != null){
                System.out.println("/tAchou o usuário");
                Aluno a = usuarioRN.buscarAluno(user.getUsuario());
                if(a != null && a.getEmail() != null){
                    Random random = new Random();
                    Integer x = random.nextInt(1000000);
                    String newSenha = x.toString();
                    
                    user.setSenha(newSenha);
                    usuarioRN.atualizar(user);
                    System.out.println("A nova senha é: " + newSenha);
                    
                    try {
                        EmailUtils.redefinirSenha(user.getLogin(), a.getEmail(), newSenha);
                    } catch (MessagingException ex) {
                        System.out.println("\tErro!");
                        Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
                    }                    
                }else{
                    System.out.println("/tNão tem nenhum aluno com esse email!");
                }
            }else{
                System.out.println("/tNum tem usuario com esse login não");
            }
        }else{
            System.out.println("/tO cpf tá nulo!");
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

    public String getCpfRedefinirSenha() {
        return cpfRedefinirSenha;
    }

    public void setCpfRedefinirSenha(String cpfRedefinirSenha) {
        this.cpfRedefinirSenha = cpfRedefinirSenha;
    }
    
}
