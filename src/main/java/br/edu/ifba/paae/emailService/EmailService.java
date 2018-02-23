package br.edu.ifba.paae.emailService;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailService {

    public boolean enviarEmail(String destino, String assunto, String mensagem){
        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("suportepaae@gmail.com", "sistemastrong71"));
        email.setSSLOnConnect(true);

        try {
            email.setFrom("suportepaae@gmail.com");
            email.addTo(destino);
            email.setSubject(assunto);
            email.setMsg(mensagem);

            email.setSSL(true);
            email.setTLS(true);
            email.send();      
            return true;
            
        } catch (EmailException ex) {
            return false;
        }

    }
}
