package br.ifba.edu.as.bean;

import br.edu.ifba.as.logica.telaBolsas.Barema;
import br.edu.ifba.as.logica.telaBolsas.Parametro;
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
    
    @PostConstruct
    public void init() {
        parametros = barema.criarLista();
    }

    public void editarBarema(Parametro parametro) {
        if(parametro != null) {
            barema.salvar(parametro);
        }
    }    
    
    
    
    
// Controle de Tela
    
    
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
}
