package br.edu.ifba.paae.dao.formulario;

import br.edu.ifba.paae.entidades.formulario.Ocupacao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class OcupacaoDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public Ocupacao buscarPorAluno(Integer codAluno){
        String hql = "select u from Ocupacao u where u.ocupacao = :codAluno";
        Query c = this.sessao.createQuery(hql);
        c.setString("codAluno", codAluno.toString());
        return (Ocupacao) c.uniqueResult();
    }
    public Ocupacao carregar(Integer codigo){
        return (Ocupacao) this.sessao.get(Ocupacao.class, codigo);
    }
    public List<Ocupacao> listar(){
        return this.sessao.createCriteria(Ocupacao.class).list();
    }
    public void salvar(Ocupacao ocupacao){
        sessao.saveOrUpdate(ocupacao);
    }
    public void excluir(Ocupacao ocupacao){
        sessao.delete(ocupacao);
    }

    
}
