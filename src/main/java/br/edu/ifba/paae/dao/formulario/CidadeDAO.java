package br.edu.ifba.paae.dao.formulario;

import br.edu.ifba.paae.entidades.formulario.Cidade;
import java.util.List;
import org.hibernate.Session;

public class CidadeDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    public Cidade carregar(Integer codigo){
        return (Cidade) this.sessao.get(Cidade.class, codigo);
    }
    public List<Cidade> listar(){
        return this.sessao.createCriteria(Cidade.class).list();
    }
    public void salvar(Cidade cidade){
        sessao.saveOrUpdate(cidade);
    }
    public void definirPadroes(){

    }
    
}
