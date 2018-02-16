package br.edu.ifba.paae.logica;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Mensagem {
    public void addMensagem(String mensagem, FacesMessage.Severity tipo){
        FacesMessage facesMensage = new FacesMessage(tipo, mensagem, null);
        FacesContext.getCurrentInstance().addMessage(null, facesMensage);
    }    
}
