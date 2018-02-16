package br.edu.ifba.paae.emailService;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


public class Autenticacao extends Authenticator{
    private String usuario = "suportepaae@gmail.com";
    private String senha = "sistemastrong71";
    public Autenticacao(String usuario, String senha){
        this.usuario = usuario;
        this.senha = senha;
    }
    @Override
    public PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(this.usuario, this.senha);
    }
}
