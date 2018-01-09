package br.edu.ifba.as.dao.analise;

import br.edu.ifba.as.entidades.analise.ProgramaSocial;
import java.util.List;
import org.hibernate.Session;

public class ProgramaSocialDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    public ProgramaSocial carregar(Integer codigo){
        return (ProgramaSocial) this.sessao.get(ProgramaSocial.class, codigo);
    }
    public List<ProgramaSocial> listar(){
        return this.sessao.createCriteria(ProgramaSocial.class).list();
    }
    public void salvar(ProgramaSocial programaSocial){
        sessao.saveOrUpdate(programaSocial);
    }
    public void excluir(ProgramaSocial programaSocial){
        sessao.delete(programaSocial);
    }    
    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos       
    }
    
}
