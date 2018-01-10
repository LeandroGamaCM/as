package br.edu.ifba.as.rn.analise;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.analise.ComposicaoFamiliarDAO;
import br.edu.ifba.as.entidades.analise.ComposicaoFamiliar;
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

        gestante.setTipo("gestantes");
        idoso.setTipo("idosos");
        doente.setTipo("PDC/Doença incapacitante");
        criancaAdolescente.setTipo("Crianças/Adolescentes");
        
        this.composicaoFamiliarDAO.salvar(gestante);
        this.composicaoFamiliarDAO.salvar(idoso);
        this.composicaoFamiliarDAO.salvar(doente);
        this.composicaoFamiliarDAO.salvar(criancaAdolescente);
    }
    
}
