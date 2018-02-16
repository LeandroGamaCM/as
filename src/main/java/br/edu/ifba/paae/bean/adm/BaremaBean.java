package br.edu.ifba.paae.bean.adm;


import br.edu.ifba.paae.logica.Barema;
import br.edu.ifba.paae.logica.Parametro;
import br.edu.ifba.paae.rn.analise.RendaPerCapitaRN;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "baremaBean")
@ViewScoped
public class BaremaBean implements Serializable{
    private Barema barema = new Barema();
    private List<Parametro> parametros;
    private Double salario;
    
    private String estadoTela = "telaBarema";
    
    @PostConstruct
    public void init() {
        RendaPerCapitaRN rendaPerCapitaRN = new RendaPerCapitaRN();
        parametros = barema.criarLista();
        salario = rendaPerCapitaRN.buscarSalario();
        System.out.println("\tSalário: " + salario);
    }

    public void editarBarema(Parametro parametro) {
        if(parametro != null) {
            barema.salvar(parametro);
        }
    }    
    
    public void editarSalario(){
        RendaPerCapitaRN rendaPerCapitaRN = new RendaPerCapitaRN();
        if(salario != null){
            rendaPerCapitaRN.editarSalario(salario);
        }
    }
    
// Controle de Tela

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

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getEstadoTela() {
        return estadoTela;
    }

    public void setEstadoTela(String estadoTela) {
        this.estadoTela = estadoTela;
    }


    
    
}
