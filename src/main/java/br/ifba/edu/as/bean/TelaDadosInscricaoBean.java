package br.ifba.edu.as.bean;

import br.edu.ifba.as.logica.telaDadosInscricao.AlunoInscricao;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name = "telaDadosInscricaoBean")
@ViewScoped
public class TelaDadosInscricaoBean {
    private AlunoInscricao alunoInscricao;

    @PostConstruct    
    public void init(){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        String loginUsuario = externalContext.getRemoteUser();
        System.out.println("Login do Usuario: " + loginUsuario);
                
    }
    
    
    public AlunoInscricao getAlunoInscricao() {
        return alunoInscricao;
    }

    public void setAlunoInscricao(AlunoInscricao alunoInscricao) {
        this.alunoInscricao = alunoInscricao;
    }
    
    
}
