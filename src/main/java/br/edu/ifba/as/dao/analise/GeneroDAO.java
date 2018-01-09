package br.edu.ifba.as.dao.analise;

import br.edu.ifba.as.entidades.analise.Genero;
import java.util.List;
import org.hibernate.Session;

public class GeneroDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    public Genero carregar(Integer codigo){
        return (Genero) this.sessao.get(Genero.class, codigo);
    }
    public List<Genero> listar(){
        return this.sessao.createCriteria(Genero.class).list();
    }
    public void salvar(Genero genero){
        sessao.saveOrUpdate(genero);
    }
    public void excluir(Genero genero){
        sessao.delete(genero);
    }    
    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos       
    }    
}
