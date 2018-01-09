package br.edu.ifba.as.dao.analise;

import br.edu.ifba.as.entidades.analise.LocalResidenciaFamilia;
import java.util.List;
import org.hibernate.Session;

public class LocalResidenciaFamiliaDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    public LocalResidenciaFamilia carregar(Integer codigo){
        return (LocalResidenciaFamilia) this.sessao.get(LocalResidenciaFamilia.class, codigo);
    }
    public List<LocalResidenciaFamilia> listar(){
        return this.sessao.createCriteria(LocalResidenciaFamilia.class).list();
    }
    public void salvar(LocalResidenciaFamilia localResidenciaFamiliaa){
        sessao.saveOrUpdate(localResidenciaFamiliaa);
    }
    public void excluir(LocalResidenciaFamilia localResidenciaFamiliaa){
        sessao.delete(localResidenciaFamiliaa);
    }    
    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos       
    }    
}
