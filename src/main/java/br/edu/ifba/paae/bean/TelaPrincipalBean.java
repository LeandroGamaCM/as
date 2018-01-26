package br.edu.ifba.paae.bean;

import br.edu.ifba.paae.entidades.inscricao.Inscricao;
import br.edu.ifba.paae.rn.inscricao.InscricaoRN;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "telaPrincipalBean")
@ViewScoped
public class TelaPrincipalBean implements Serializable{
    Inscricao inscricao;
    
    @PostConstruct
    public void init(){
        InscricaoRN inscricaoRN = new InscricaoRN();
        inscricao = inscricaoRN.carregar();
    }

    public void ativarDesativar(){
        InscricaoRN inscricaoRN = new InscricaoRN();
        
        if(inscricao != null && inscricao.getPeriodoInscricao()){
            inscricao.setPeriodoInscricao(Boolean.FALSE);
            inscricaoRN.atualizar(Boolean.FALSE);
        }else{
            inscricao.setPeriodoInscricao(Boolean.TRUE);
            inscricaoRN.atualizar(Boolean.TRUE);
        }
    }
    
    public Inscricao getInscricao() {
        return inscricao;
    }

    public void setInscricao(Inscricao inscricao) {
        this.inscricao = inscricao;
    }
    
    
}
