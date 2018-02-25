package br.edu.ifba.paae.bean.publico;

import br.edu.ifba.paae.emailService.EmailService;
import br.edu.ifba.paae.emailService.TesteConexao;
import br.edu.ifba.paae.entidades.formulario.Aluno;
import br.edu.ifba.paae.entidades.usuario.Usuario;
import br.edu.ifba.paae.rn.formulario.AlunoRN;
import br.edu.ifba.paae.rn.usuario.UsuarioRN;
import java.io.Serializable;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "recuperacaoBean")
@ViewScoped
public class RecuperacaoBean implements Serializable{
    private static final long serialVersionUID = -2114519053407431769L;

    private boolean mensagemEmailNaoEnviado = false;
    private boolean mensagemUsuarioNulo = false;
    private boolean mensagemCPFNulo = false;
    private boolean mensagemEmailNulo = false;
    private boolean mensagemSemInternet = false;
    
    private String cpfRedefinirSenha;    
    private String emailDestino;
    
    public String redefinirSenha(){
        UsuarioRN usuarioRN = new UsuarioRN();
        
        mensagemEmailNaoEnviado = false;
        mensagemUsuarioNulo = false;
        mensagemCPFNulo = false;
        mensagemEmailNulo = false;
        mensagemSemInternet = false;        
        
        if(cpfRedefinirSenha != null){
            Usuario user = usuarioRN.buscarPorLogin(cpfRedefinirSenha);
            if(user != null){
                AlunoRN alunoRN = new AlunoRN();
                Aluno aluno = alunoRN.buscarPorCPF(cpfRedefinirSenha);
                if(user.getPermissao().contains("ROLE_ADMINISTRADOR") || (aluno != null && !aluno.getStatus().equals("Pré-cadastrado"))){
                    if(user.getEmail() != null){
                        if(TesteConexao.testar()){
                            Random random = new Random();
                            Integer x = random.nextInt(1000000);
                            String newSenha = x.toString();

                            user.setSenha(newSenha);
                            usuarioRN.atualizar(user);
                            System.out.println("A nova senha é: " + newSenha);

                            String msg = "Sua nova senha de login no Sistema PAAE é: "+newSenha;
                            String assunto = "Redefinição de senha do Sistema PAAE";
                            emailDestino = user.getEmail();

                            EmailService emailService = new EmailService();

                            if(emailService.enviarEmail(emailDestino, assunto, msg)){
                                cpfRedefinirSenha = "";
                                return "login.jsf";
                            }else{
                                mensagemEmailNaoEnviado = true;
                                cpfRedefinirSenha = "";
                                return null;
                            }                    
                        }else{
                            mensagemSemInternet = true;
                            cpfRedefinirSenha = "";
                            return null;
                        }
                    }else{
                        mensagemEmailNulo = true;
                        cpfRedefinirSenha = "";
                        return null;                    }
                }else{
                    mensagemUsuarioNulo = true;
                    cpfRedefinirSenha = "";
                    return null;
                }
            }else{
                mensagemUsuarioNulo = true;
                cpfRedefinirSenha = "";
                return null;
            }
        }else{
            mensagemCPFNulo = true;
            cpfRedefinirSenha = "";
            return null;
        }
    }

    public String getCpfRedefinirSenha() {
        return cpfRedefinirSenha;
    }

    public void setCpfRedefinirSenha(String cpfRedefinirSenha) {
        this.cpfRedefinirSenha = cpfRedefinirSenha;
    }

    public boolean isMensagemEmailNaoEnviado() {
        return mensagemEmailNaoEnviado;
    }

    public void setMensagemEmailNaoEnviado(boolean mensagemEmailNaoEnviado) {
        this.mensagemEmailNaoEnviado = mensagemEmailNaoEnviado;
    }

    public boolean isMensagemUsuarioNulo() {
        return mensagemUsuarioNulo;
    }

    public void setMensagemUsuarioNulo(boolean mensagemUsuarioNulo) {
        this.mensagemUsuarioNulo = mensagemUsuarioNulo;
    }

    public boolean isMensagemCPFNulo() {
        return mensagemCPFNulo;
    }

    public void setMensagemCPFNulo(boolean mensagemCPFNulo) {
        this.mensagemCPFNulo = mensagemCPFNulo;
    }

    public boolean isMensagemSemInternet() {
        return mensagemSemInternet;
    }

    public void setMensagemSemInternet(boolean mensagemSemInternet) {
        this.mensagemSemInternet = mensagemSemInternet;
    }

    public String getEmailDestino() {
        return emailDestino;
    }

    public void setEmailDestino(String emailDestino) {
        this.emailDestino = emailDestino;
    }

    public boolean isMensagemEmailNulo() {
        return mensagemEmailNulo;
    }

    public void setMensagemEmailNulo(boolean mensagemEmailNulo) {
        this.mensagemEmailNulo = mensagemEmailNulo;
    }
    
}
