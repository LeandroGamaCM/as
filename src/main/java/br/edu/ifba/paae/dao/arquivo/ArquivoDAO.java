package br.edu.ifba.paae.dao.arquivo;

import br.edu.ifba.paae.entidades.arquivo.Arquivo;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class ArquivoDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    public Arquivo carregar(Integer codigo){
        return (Arquivo) this.sessao.get(Arquivo.class, codigo);
    }
    public List<Arquivo> listar(){
        return this.sessao.createCriteria(Arquivo.class).list();
    }
    public void salvar(Arquivo arquivo){
        sessao.saveOrUpdate(arquivo);
    }
    public void excluir(Arquivo arquivo){
        sessao.delete(arquivo);
    }            
    public Arquivo buscarPorNome(String nome){
        String hql = "select a from Arquivo a where a.nome = :nome";
        Query c = this.sessao.createQuery(hql);
        c.setString("nome", nome);
        return (Arquivo) c.uniqueResult();        
    }}
