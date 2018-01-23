package br.edu.ifba.paae.rn.analise;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.analise.CondicaoEconomicaEstudanteDAO;
import br.edu.ifba.paae.entidades.analise.CondicaoEconomicaEstudante;
import java.util.List;

public class CondicaoEconomicaEstudanteRN {
    private CondicaoEconomicaEstudanteDAO condicaoEconomicaEstudanteDAO;

    public CondicaoEconomicaEstudanteRN() {
        this.condicaoEconomicaEstudanteDAO = DAOFactory.criarCondicaoEconomicaEstudanteDAO();
    }
    
    public void salvar(CondicaoEconomicaEstudante condicaoEconomicaEstudante){
        this.condicaoEconomicaEstudanteDAO.salvar(condicaoEconomicaEstudante);
    }
    public void excluir(CondicaoEconomicaEstudante condicaoEconomicaEstudante){
        this.condicaoEconomicaEstudanteDAO.excluir(condicaoEconomicaEstudante);
    }
    public CondicaoEconomicaEstudante carregar(Integer codigo){
        return this.condicaoEconomicaEstudanteDAO.carregar(codigo);
    }
    public List<CondicaoEconomicaEstudante> listar(){
        return this.condicaoEconomicaEstudanteDAO.listar();
    }    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos
        CondicaoEconomicaEstudante provedor = new CondicaoEconomicaEstudante();
        CondicaoEconomicaEstudante dependente = new CondicaoEconomicaEstudante();
        CondicaoEconomicaEstudante colaborador = new CondicaoEconomicaEstudante();
        
        provedor.setTipo("Provedor(a)");
        dependente.setTipo("Dependente");
        colaborador.setTipo("Colaborador(a)");
        
        this.condicaoEconomicaEstudanteDAO.salvar(provedor);
        this.condicaoEconomicaEstudanteDAO.salvar(dependente);
        this.condicaoEconomicaEstudanteDAO.salvar(colaborador);
    }
    public Float getPeso(){
        int i;
        Float peso = 0.0F;
        List<CondicaoEconomicaEstudante> list = listar();
        for(i=0; i<list.size(); i++){
            if(list.get(i).getPontuacao() != null)
            peso = peso + list.get(i).getPontuacao();
        }
        return peso;
    }    
    public CondicaoEconomicaEstudante buscarPorAspectoEmAvaliacao(String tipo){
        return this.condicaoEconomicaEstudanteDAO.buscarPorAspectoEmAvaliacao(tipo);
    } 
}
