package br.ifba.edu.as.bean;

import br.edu.ifba.as.entidades.analise.Bolsa;
import br.edu.ifba.as.logica.telaBolsas.Barema;
import br.edu.ifba.as.logica.telaBolsas.Parametro;
import br.edu.ifba.as.rn.analise.BolsaRN;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class bolsasBean implements Serializable{
    private Barema barema = new Barema();
    private List<Parametro> parametros;
    private List<Bolsa> bolsas;
    
    private String estadoTela = "telaBolsas";
    
    @PostConstruct
    public void init() {
        BolsaRN bolsaRN = new BolsaRN();
        parametros = barema.criarLista();
        bolsas = bolsaRN.listar();
    }

    public void editarBarema(Parametro parametro) {
        if(parametro != null) {
            barema.salvar(parametro);
        }
    }    
    
    public void editarBolsa(Bolsa bolsa){
        if(bolsa != null){
            BolsaRN bolsaRN = new BolsaRN();
            bolsaRN.salvar(bolsa);
        }
    }
    
    
    
// Controle de Tela
    public boolean isTelaBolsas(){
        return "telaBolsas".equals(this.estadoTela);
    }
    public void changeToTelaBolsas(){
        this.estadoTela = "telaBolsas";
    }
    public boolean isTelaBarema(){
        return "telaBarema".equals(this.estadoTela);
    }
    public void changeToTelaBarema(){
        this.estadoTela = "telaBarema";
    }
    
    
// Getters e Setters    

    public Barema getBarema() {
        return barema;
    }

    public void setBarema(Barema barema) {
        this.barema = barema;
    }

    public List<Parametro> getParametros() {
        return parametros;
    }

    public void setParametros(List<Parametro> parametros) {
        this.parametros = parametros;
    }

    public List<Bolsa> getBolsas() {
        return bolsas;
    }

    public void setBolsas(List<Bolsa> bolsas) {
        this.bolsas = bolsas;
    }

    public String getEstadoTela() {
        return estadoTela;
    }

    public void setEstadoTela(String estadoTela) {
        this.estadoTela = estadoTela;
    }

    
    
}
