package br.edu.ifba.paae.bean.aluno;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
@ManagedBean(name = "CommandView")
public class CommandView implements Serializable{
 
    public void execute()  {
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Usuário Cadastrado!", "Aguarde a tela de confirmação."));
    }
}