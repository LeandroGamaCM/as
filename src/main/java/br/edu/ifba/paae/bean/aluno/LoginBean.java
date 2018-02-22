package br.edu.ifba.paae.bean.aluno;

import br.edu.ifba.paae.emailService.EmailService;
import br.edu.ifba.paae.entidades.formulario.Aluno;
import br.edu.ifba.paae.entidades.usuario.Usuario;
import br.edu.ifba.paae.logica.Mensagem;
import br.edu.ifba.paae.rn.formulario.AlunoRN;
import br.edu.ifba.paae.rn.usuario.UsuarioRN;
import java.io.Serializable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.commons.mail.EmailException;

@ManagedBean(name = "loginBean")
@ViewScoped
public class LoginBean implements Serializable{
    private String estadoTela = "cadastro";
    private Usuario usuario = new Usuario();
    private Mensagem mensagem = new Mensagem();
    
    private String cpfPagina;
    private String nomePagina;
    private String senhaPagina;
    private String emailPagina;

    private String cpfRedefinirSenha;
    
    private String codConfirmacaoPagina;
    private String codConfirmacao;
    
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
    
    public String salvar(){
// Exibir mensagem e voltar pra tela de Login
        if(codConfirmacaoPagina.equals(codConfirmacao)){
            if(verificaExistencia()){
                atribuirProperties();
                UsuarioRN usuarioRN = new UsuarioRN();

                usuarioRN.salvar(usuario);
                System.out.println("\n\tSalvo com Sucesso!\n");
                return "loginEntrar";
            }    
            return "loginCadastro";
        }else{
            System.out.println("Código incorreto!");
            return "loginCadastro";
        }
    }
    
    public void atribuirProperties(){
        AlunoRN alunoRN = new AlunoRN();
        Aluno aluno = alunoRN.buscarPorCPF(cpfPagina);
        if(aluno != null){
            aluno.setNome(nomePagina);
            aluno.setStatus("Inscrição pendente");
            alunoRN.salvar(aluno);
        }
        this.usuario.setAtivo(Boolean.TRUE);
        this.usuario.setSenha(senhaPagina);
        this.usuario.setNome(nomePagina);
        this.usuario.setEmail(emailPagina);
    }
    
    public void enviarCodConfirmacao(){
        if(emailPagina != null){
            Random random = new Random();
            Integer x = random.nextInt(1000000);
            codConfirmacao = x.toString();
            
            String assunto = "Confirmação de email do Sistema PAAE";
            String msg = "Seu código de confirmação de email é: "+codConfirmacao;
            
            EmailService emailService = new EmailService();
            
            try {
                emailService.enviarEmail(emailPagina, assunto, msg);
                System.out.println("Enviando...");
            } catch (EmailException ex) {
                Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Não enviou o email!");
                mensagem.addMensagem("Não foi possivel enviar um email para o endereço "+emailPagina, FacesMessage.SEVERITY_ERROR);
            }
            changeToConfirmacao();
        }else{
            System.out.println("Usuario nulo!!");
            mensagem.addMensagem("ERRO: Não é possivel realizar essa operação!", FacesMessage.SEVERITY_ERROR);            
        }
    }    

    public void redefinirSenha(){
        UsuarioRN usuarioRN = new UsuarioRN();
        if(cpfRedefinirSenha != null){
            Usuario user = usuarioRN.buscarPorLogin(cpfRedefinirSenha);
            if(user != null){
                System.out.println("/tAchou o usuário");

                Random random = new Random();
                Integer x = random.nextInt(1000000);
                String newSenha = x.toString();

                user.setSenha(newSenha);
                usuarioRN.atualizar(user);
                System.out.println("A nova senha é: " + newSenha);

                String msg = "Sua nova senha de login no Sistema PAAE é: "+newSenha;
                String assunto = "Redefinição de senha do Sistema PAAE";

                EmailService emailService = new EmailService();
                try {
                    emailService.enviarEmail(user.getEmail(), assunto, msg);
                } catch (EmailException ex) {
                    Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
                    mensagem.addMensagem("Não foi possivel enviar um email para o endereço "+emailPagina, FacesMessage.SEVERITY_ERROR);
                }
            }else{
                mensagem.addMensagem("Não existe nenhum usuário cadastrado com o CPF informado!", FacesMessage.SEVERITY_ERROR);
                System.out.println("/tNum tem usuario com esse login não");
            }
        }else{
            mensagem.addMensagem("Insira um CPF válido!", FacesMessage.SEVERITY_ERROR);
            System.out.println("/tO cpf tá nulo!");
        }
    }


// Controle de Tela
    public boolean isCadastro(){
        return "cadastro".equals(this.estadoTela);
    }
    public void changeToCadastro(){
        this.estadoTela = "cadastro";
    }
    public boolean isConfirmacao(){
        return "confirmacao".equals(this.estadoTela);
    }
    public void changeToConfirmacao(){
        this.estadoTela = "confirmacao";
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

    public String getEmailPagina() {
        return emailPagina;
    }

    public void setEmailPagina(String emailPagina) {
        this.emailPagina = emailPagina;
    }

    public String getCpfRedefinirSenha() {
        return cpfRedefinirSenha;
    }

    public void setCpfRedefinirSenha(String cpfRedefinirSenha) {
        this.cpfRedefinirSenha = cpfRedefinirSenha;
    }

    public Mensagem getMensagem() {
        return mensagem;
    }

    public void setMensagem(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

    public String getCodConfirmacaoPagina() {
        return codConfirmacaoPagina;
    }

    public void setCodConfirmacaoPagina(String codConfirmacaoPagina) {
        this.codConfirmacaoPagina = codConfirmacaoPagina;
    }


    
}
