package br.edu.ifba.paae.rn.analise;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.analise.ComposicaoFamiliarDAO;
import br.edu.ifba.paae.entidades.analise.ComposicaoFamiliar;
import java.util.List;

public class ComposicaoFamiliarRN {
    private ComposicaoFamiliarDAO composicaoFamiliarDAO;

    public ComposicaoFamiliarRN() {
        this.composicaoFamiliarDAO = DAOFactory.criarComposicaoFamiliarDAO();
    }
    
    public void salvar(ComposicaoFamiliar composicaoFamiliar){
        this.composicaoFamiliarDAO.salvar(composicaoFamiliar);
    }
    public void excluir(ComposicaoFamiliar composicaoFamiliar){
        this.composicaoFamiliarDAO.excluir(composicaoFamiliar);
    }
    public ComposicaoFamiliar carregar(Integer codigo){
        return this.composicaoFamiliarDAO.carregar(codigo);
    }
    public List<ComposicaoFamiliar> listar(){
        return this.composicaoFamiliarDAO.listar();
    }    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos
        ComposicaoFamiliar gestante = new ComposicaoFamiliar();
        ComposicaoFamiliar idoso = new ComposicaoFamiliar();
        ComposicaoFamiliar doente = new ComposicaoFamiliar();
        ComposicaoFamiliar criancaAdolescente = new ComposicaoFamiliar();
        ComposicaoFamiliar adulto = new ComposicaoFamiliar();

        gestante.setTipo("Gestantes");
        gestante.setPontuacao(1.5F);
        
        idoso.setTipo("Idosos");
        idoso.setPontuacao(1.5F);
        
        doente.setTipo("PDC/Doença incapacitante");
        doente.setPontuacao(2F);
        
        criancaAdolescente.setTipo("Crianças/Adolescentes");
        criancaAdolescente.setPontuacao(1F);
        
        adulto.setTipo("Adulto");
        adulto.setPontuacao(0.5F);
        
        this.composicaoFamiliarDAO.salvar(gestante);
        this.composicaoFamiliarDAO.salvar(idoso);
        this.composicaoFamiliarDAO.salvar(doente);
        this.composicaoFamiliarDAO.salvar(criancaAdolescente);
        this.composicaoFamiliarDAO.salvar(adulto);
    }
    public Float getPeso(){
        int i = 0;
        Float peso = 0.0F;
        List<ComposicaoFamiliar> list = listar();
        for(i=0; i<list.size(); i++){
            if(list.get(i).getPontuacao() != null)
            peso = peso + list.get(i).getPontuacao();
        }
        return peso;
    }
    public ComposicaoFamiliar buscarPorAspectoEmAvaliacao(String tipo){
        return this.composicaoFamiliarDAO.buscarPorAspectoEmAvaliacao(tipo);
    }   
}
