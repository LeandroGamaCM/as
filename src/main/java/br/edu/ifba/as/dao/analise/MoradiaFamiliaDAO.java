package br.edu.ifba.as.dao.analise;

import br.edu.ifba.as.entidades.analise.MoradiaFamilia;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class MoradiaFamiliaDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    public MoradiaFamilia carregar(Integer codigo){
        return (MoradiaFamilia) this.sessao.get(MoradiaFamilia.class, codigo);
    }
    public List<MoradiaFamilia> listar(){
        return this.sessao.createCriteria(MoradiaFamilia.class).list();
    }
    public void salvar(MoradiaFamilia moradiaFamilia){
        sessao.saveOrUpdate(moradiaFamilia);
    }
    public void excluir(MoradiaFamilia moradiaFamilia){
        sessao.delete(moradiaFamilia);
    }    
    public MoradiaFamilia buscarPorAspectoEmAvaliacao(String tipo){
        return (MoradiaFamilia) this.sessao.createCriteria(MoradiaFamilia.class).add(Restrictions.eq("tipo", tipo)).uniqueResult();
    } 
}
