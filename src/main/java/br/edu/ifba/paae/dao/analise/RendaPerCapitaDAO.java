package br.edu.ifba.paae.dao.analise;

import br.edu.ifba.paae.entidades.analise.RendaPerCapita;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class RendaPerCapitaDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    public RendaPerCapita carregar(Integer codigo){
        return (RendaPerCapita) this.sessao.get(RendaPerCapita.class, codigo);
    }
    public List<RendaPerCapita> listar(){
        return this.sessao.createCriteria(RendaPerCapita.class).list();
    }
    public void salvar(RendaPerCapita rendaPerCapita){
        sessao.saveOrUpdate(rendaPerCapita);
    }
    public void excluir(RendaPerCapita rendaPerCapita){
        sessao.delete(rendaPerCapita);
    }    
    public RendaPerCapita buscarPorLimite(Double limite){
        return (RendaPerCapita)this.sessao.createCriteria(RendaPerCapita.class).add(Restrictions.eq("limite", limite)).uniqueResult();
    }
    public Double buscarSalario(){
        if(listar() != null){
            System.out.println("\tSalario: " + listar().get(0).getSalario());
            return listar().get(0).getSalario();
        }
        return 0.0;
    }

}
