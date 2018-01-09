package br.edu.ifba.as.dao.analise;

import br.edu.ifba.as.entidades.analise.Saude;
import java.util.List;
import org.hibernate.Session;

public class SaudeDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    public Saude carregar(Integer codigo){
        return (Saude) this.sessao.get(Saude.class, codigo);
    }
    public List<Saude> listar(){
        return this.sessao.createCriteria(Saude.class).list();
    }
    public void salvar(Saude saude){
        sessao.saveOrUpdate(saude);
    }
    public void excluir(Saude saude){
        sessao.delete(saude);
    }    
    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos       
    }
    
}
