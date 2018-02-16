package br.edu.ifba.paae.emailService;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailUtils{
    private static final String SERVIDOR_SMTP = "smtp.gmail.com";
    private static final String PORTA_SERVIDOR_SMTP = "465";
    private static final String EMAIL = "suportepaae@gmail.com";
    private static final String SENHA = "sistemastrong71";
    
    public static void redefinirSenha(String cpfUsuario, String emailUsuario, String senhaUsuario) throws AddressException, MessagingException{
        Autenticacao autenticacao = new Autenticacao(EMAIL, SENHA);
        Session session = Session.getDefaultInstance(getPropriedades(), autenticacao);
        session.setDebug(true);
        MimeMessage email = new MimeMessage(session);        
        
        //Aqui que substitui o meu email por uma variável que recebe o email do aluno
        email.setRecipient(Message.RecipientType.TO, new InternetAddress(emailUsuario));
        email.setFrom(new InternetAddress(EMAIL));
        email.setSubject("Redefinição de senha do PAAE");              
        
        //Aqui que substitui o corpo da mensagem pelas credenciais do aluno (CPF e nova senha do aluno)
        String corpoMensagem = "Sua nova senha para login no Sistema PAAE é ";
        
        email.setContent(corpoMensagem + senhaUsuario, "text/plain");
        email.setSentDate(new Date());
        Transport envio = session.getTransport("smtp");
        envio.connect(SERVIDOR_SMTP, EMAIL, SENHA);
        email.saveChanges();
        envio.sendMessage(email, email.getAllRecipients());
        envio.close();
        System.out.println("Enviado com sucesso!");
    }
    public static Properties getPropriedades(){
        Properties config = new Properties();
        config.setProperty("mail.transport.protocol", "smtp");
        config.setProperty("mail.smtp.starttls.enable", "true");
        config.setProperty("mail.smtp.host", SERVIDOR_SMTP);
        config.setProperty("mail.smtp.auth", "true");
        config.setProperty("mail.smtp.user", EMAIL);
        config.setProperty("mail.debug", "true");
        config.setProperty("mail.smtp.port", PORTA_SERVIDOR_SMTP);
        config.setProperty("mail.smtp.socketFactory.port", PORTA_SERVIDOR_SMTP);
        config.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        config.setProperty("mail.smtp.socketFactory.fallback", "false");
        return config;
    }
}
