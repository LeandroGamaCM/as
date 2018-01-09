package br.edu.ifba.as.dao.analise;

import br.edu.ifba.as.entidades.analise.RendaPrincipalOrigem;
import java.util.List;
import org.hibernate.Session;

public class RendaPrincipalOrigemDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    public RendaPrincipalOrigem carregar(Integer codigo){
        return (RendaPrincipalOrigem) this.sessao.get(RendaPrincipalOrigem.class, codigo);
    }
    public List<RendaPrincipalOrigem> listar(){
        return this.sessao.createCriteria(RendaPrincipalOrigem.class).list();
    }
    public void salvar(RendaPrincipalOrigem rendaPrincipalOrigem){
        sessao.saveOrUpdate(rendaPrincipalOrigem);
    }
    public void excluir(RendaPrincipalOrigem rendaPrincipalOrigem){
        sessao.delete(rendaPrincipalOrigem);
    }    
    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos       
    }
    
}
