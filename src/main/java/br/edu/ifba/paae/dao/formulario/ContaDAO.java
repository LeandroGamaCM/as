package br.edu.ifba.paae.dao.formulario;

import br.edu.ifba.paae.entidades.formulario.Conta;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class ContaDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public Conta buscarPorAluno(Integer codAluno){
        String hql = "select u from Conta u where u.conta = :codAluno";
        Query c = this.sessao.createQuery(hql);
        c.setString("codAluno", codAluno.toString());
        return (Conta) c.uniqueResult();
    }
    public Conta carregar(Integer codigo){
        return (Conta) this.sessao.get(Conta.class, codigo);
    }
    public List<Conta> listar(){
        return this.sessao.createCriteria(Conta.class).list();
    }
    public void salvar(Conta conta){
        sessao.saveOrUpdate(conta);
    }
    public void excluir(Conta conta){
        sessao.delete(conta);
    }

    
}
