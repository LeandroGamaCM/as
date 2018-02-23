package br.edu.ifba.paae.bean.publico;

import br.edu.ifba.paae.emailService.EmailValidator;
import br.edu.ifba.paae.emailService.TesteConexao;
import br.edu.ifba.paae.entidades.formulario.Aluno;
import br.edu.ifba.paae.entidades.usuario.Usuario;
import br.edu.ifba.paae.rn.formulario.AlunoRN;
import br.edu.ifba.paae.rn.usuario.UsuarioRN;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "cadastroBean")
@ViewScoped
public class CadastroBean implements Serializable{
    private static final long serialVersionUID = -7154048181682250752L;

    private Usuario usuario = new Usuario();
    private Usuario usuarioPagina = new Usuario();
    
    public boolean mensagemUsuarioNulo = false;
    public boolean mensagemUsuarioCadastrado = false;
    public boolean mensagemEmailInvalido = false;
    public boolean mensagemSemInternet = false;
    
    public boolean validarUsuario(){
        UsuarioRN usuarioRN = new UsuarioRN();
        usuario = usuarioRN.buscarPorLogin(usuarioPagina.getLogin());
        mensagemUsuarioNulo = false;
        mensagemUsuarioCadastrado = false;
        mensagemEmailInvalido = false;
        mensagemSemInternet = false;
        
        if(usuario == null){
            mensagemUsuarioNulo = true;
            return false;
        }else{
            if(usuario.getAtivo()){
                mensagemUsuarioCadastrado = true;
                return false;
            }else{
                if(!TesteConexao.testar()){
                    mensagemSemInternet = true;
                    return false;
                }else{
                    if(!EmailValidator.validar(usuarioPagina.getEmail())){
                        mensagemEmailInvalido = true;
                        return false;
                    }
                    return true;                    
                }
            }
        }
    }
    
    public String salvar(){
            if(validarUsuario()){
                atribuirProperties();
                UsuarioRN usuarioRN = new UsuarioRN();

                usuarioRN.salvar(usuario);
                usuarioPagina = new Usuario();
                return "login.jsf";
            }
// Descomente a linha abaixo pra limpar os campos na tela! ----------------------------------------------------------            
//            usuarioPagina = new Usuario();
            return null;
    }
    
    public void atribuirProperties(){
        AlunoRN alunoRN = new AlunoRN();
        Aluno aluno = alunoRN.buscarPorCPF(usuarioPagina.getLogin());
        if(aluno != null){
            aluno.setNome(usuarioPagina.getNome());
            aluno.setStatus("Inscrição pendente");
            alunoRN.salvar(aluno);
        }
        this.usuario.setAtivo(Boolean.TRUE);
        this.usuario.setSenha(usuarioPagina.getSenha());
        this.usuario.setNome(usuarioPagina.getNome());
        this.usuario.setEmail(usuarioPagina.getEmail());
    }
    
//    public void enviarCodConfirmacao(){
//        if(usuarioPagina.getEmail() != null){
//            Random random = new Random();
//            Integer x = random.nextInt(1000000);
//            codConfirmacao = x.toString();
//            
//            String assunto = "Confirmação de email do Sistema PAAE";
//            String msg = "Seu código de confirmação de email é: "+codConfirmacao;
//            
//            EmailService emailService = new EmailService();
//            
//            try {
//                emailService.enviarEmail(usuarioPagina.getEmail(), assunto, msg);
//                System.out.println("Enviando...");
//            } catch (EmailException ex) {
//                Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
//                System.out.println("Não enviou o email!");
//                mensagem.addMensagem("Não foi possivel enviar um email para o endereço "+usuarioPagina.getEmail(), FacesMessage.SEVERITY_ERROR);
//            }
//            changeToConfirmacao();
//        }else{
//            System.out.println("Usuario nulo!!");
//            mensagem.addMensagem("ERRO: Não é possivel realizar essa operação!", FacesMessage.SEVERITY_ERROR);            
//        }
//    }    


// Getters e Setters
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Usuario getUsuarioPagina() {
        return usuarioPagina;
    }

    public void setUsuarioPagina(Usuario usuarioPagina) {
        this.usuarioPagina = usuarioPagina;
    }

    public boolean isMensagemUsuarioNulo() {
        return mensagemUsuarioNulo;
    }

    public void setMensagemUsuarioNulo(boolean mensagemUsuarioNulo) {
        this.mensagemUsuarioNulo = mensagemUsuarioNulo;
    }

    public boolean isMensagemUsuarioCadastrado() {
        return mensagemUsuarioCadastrado;
    }

    public void setMensagemUsuarioCadastrado(boolean mensagemUsuarioCadastrado) {
        this.mensagemUsuarioCadastrado = mensagemUsuarioCadastrado;
    }

    public boolean isMensagemEmailInvalido() {
        return mensagemEmailInvalido;
    }

    public void setMensagemEmailInvalido(boolean mensagemEmailInvalido) {
        this.mensagemEmailInvalido = mensagemEmailInvalido;
    }

    public boolean isMensagemSemInternet() {
        return mensagemSemInternet;
    }

    public void setMensagemSemInternet(boolean mensagemSemInternet) {
        this.mensagemSemInternet = mensagemSemInternet;
    }
    
    
    
    
}
