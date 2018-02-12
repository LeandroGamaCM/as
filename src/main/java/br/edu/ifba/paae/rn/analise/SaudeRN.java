package br.edu.ifba.paae.rn.analise;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.analise.SaudeDAO;
import br.edu.ifba.paae.entidades.analise.Saude;
import java.util.List;

public class SaudeRN {
    private SaudeDAO saudeDAO;

    public SaudeRN() {
        this.saudeDAO = DAOFactory.criarSaudeDAO();
    }
    
    public void salvar(Saude saude){
        this.saudeDAO.salvar(saude);
    }
    public void excluir(Saude saude){
        this.saudeDAO.excluir(saude);
    }
    public Saude carregar(Integer codigo){
        return this.saudeDAO.carregar(codigo);
    }
    public List<Saude> listar(){
        return this.saudeDAO.listar();
    }    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos  
        Saude doencaGrave = new Saude();
        Saude tratamentoMunicipio = new Saude();
        Saude tratamentoOutroMunicipio = new Saude();
        Saude conflitoViolencia = new Saude();

        doencaGrave.setTipo("Diagnóstico de doença grave");
        doencaGrave.setPontuacao(2F);
        
        tratamentoMunicipio.setTipo("Tratamento realizado no mesmo município do domicílio");
        tratamentoMunicipio.setPontuacao(1F);
        
        tratamentoOutroMunicipio.setTipo("Tratamento realizado em município diferente do domicílio");
        tratamentoOutroMunicipio.setPontuacao(1.5F);
        
        conflitoViolencia.setTipo("Situação de conflito e/ou violência");
        conflitoViolencia.setPontuacao(1F);
        
        this.saudeDAO.salvar(doencaGrave);
        this.saudeDAO.salvar(tratamentoMunicipio);
        this.saudeDAO.salvar(tratamentoOutroMunicipio);
        this.saudeDAO.salvar(conflitoViolencia);
    }
    public Float getPeso(){
        int i = 0;
        Float peso = 0.0F;
        List<Saude> list = listar();
        for(i=0; i<list.size(); i++){
            if(list.get(i).getPontuacao() != null)
            peso = peso + list.get(i).getPontuacao();
        }
        return peso;
    }    
    public Saude buscarPorAspectoEmAvaliacao(String tipo){
        return this.saudeDAO.buscarPorAspectoEmAvaliacao(tipo);
    } 
}
