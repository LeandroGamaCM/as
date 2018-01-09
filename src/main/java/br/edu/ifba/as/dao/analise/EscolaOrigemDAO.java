package br.edu.ifba.as.dao.analise;

import br.edu.ifba.as.entidades.analise.EscolaOrigem;
import java.util.List;
import org.hibernate.Session;

public class EscolaOrigemDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    public EscolaOrigem carregar(Integer codigo){
        return (EscolaOrigem) this.sessao.get(EscolaOrigem.class, codigo);
    }
    public List<EscolaOrigem> listar(){
        return this.sessao.createCriteria(EscolaOrigem.class).list();
    }
    public void salvar(EscolaOrigem escolaOrigem){
        sessao.saveOrUpdate(escolaOrigem);
    }
    public void excluir(EscolaOrigem escolaOrigem){
        sessao.delete(escolaOrigem);
    }    
    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos       
    }    
}
