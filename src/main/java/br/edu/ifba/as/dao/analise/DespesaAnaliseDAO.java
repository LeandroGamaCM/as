package br.edu.ifba.as.dao.analise;

import br.edu.ifba.as.entidades.analise.DespesaAnalise;
import java.util.List;
import org.hibernate.Session;

public class DespesaAnaliseDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    public DespesaAnalise carregar(Integer codigo){
        return (DespesaAnalise) this.sessao.get(DespesaAnalise.class, codigo);
    }
    public List<DespesaAnalise> listar(){
        return this.sessao.createCriteria(DespesaAnalise.class).list();
    }
    public void salvar(DespesaAnalise despesaAnalise){
        sessao.saveOrUpdate(despesaAnalise);
    }
    public void excluir(DespesaAnalise despesaAnalise){
        sessao.delete(despesaAnalise);
    }    
    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos       
    }    
}
