package br.edu.ifba.as.dao;

import br.edu.ifba.as.entidades.formulario.ResidenciaFamilia;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class ResidenciaFamiliaDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public ResidenciaFamilia buscarPorFamilia(Integer codFamilia){
        String hql = "select u from ResidenciaFamilia u where u.familia = :codFamilia";
        Query c = this.sessao.createQuery(hql);
        c.setString("codFamilia", codFamilia.toString());
        return (ResidenciaFamilia) c.uniqueResult();
    }
    public ResidenciaFamilia carregar(Integer codigo){
        return (ResidenciaFamilia) this.sessao.get(ResidenciaFamilia.class, codigo);
    }
    public List<ResidenciaFamilia> listar(){
        return this.sessao.createCriteria(ResidenciaFamilia.class).list();
    }
    public void salvar(ResidenciaFamilia residenciaFamilia){
        sessao.saveOrUpdate(residenciaFamilia);
    }
    public void excluir(ResidenciaFamilia residenciaFamilia){
        sessao.delete(residenciaFamilia);
    }
        
}
