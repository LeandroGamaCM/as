package br.edu.ifba.paae.dao.formulario;

import br.edu.ifba.paae.entidades.formulario.Endereco;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class EnderecoDAO{
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public Endereco buscarPorAluno(Integer codAluno){
        String hql = "select u from Endereco u where u.endereco = :codAluno";
        Query c = this.sessao.createQuery(hql);
        c.setString("codAluno", codAluno.toString());
        return (Endereco) c.uniqueResult();
    }
    public Endereco carregar(Integer codigo){
        return (Endereco) this.sessao.get(Endereco.class, codigo);
    }
    public List<Endereco> listar(){
        return this.sessao.createCriteria(Endereco.class).list();
    }
    public void salvar(Endereco endereco){
        sessao.saveOrUpdate(endereco);
    }
    public void excluir(Endereco endereco){
        sessao.delete(endereco);
    }

}
