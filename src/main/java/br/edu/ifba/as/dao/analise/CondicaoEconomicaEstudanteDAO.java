package br.edu.ifba.as.dao.analise;

import br.edu.ifba.as.entidades.analise.CondicaoEconomicaEstudante;
import java.util.List;
import org.hibernate.Session;

public class CondicaoEconomicaEstudanteDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    public CondicaoEconomicaEstudante carregar(Integer codigo){
        return (CondicaoEconomicaEstudante) this.sessao.get(CondicaoEconomicaEstudante.class, codigo);
    }
    public List<CondicaoEconomicaEstudante> listar(){
        return this.sessao.createCriteria(CondicaoEconomicaEstudante.class).list();
    }
    public void salvar(CondicaoEconomicaEstudante condicaoEconomicaEstudante){
        sessao.saveOrUpdate(condicaoEconomicaEstudante);
    }
    public void excluir(CondicaoEconomicaEstudante condicaoEconomicaEstudante){
        sessao.delete(condicaoEconomicaEstudante);
    }    
    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos       
    }    
}
