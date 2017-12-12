package br.edu.ifba.as.dao.formulario;

import br.edu.ifba.as.entidades.formulario.Aluno;
import java.util.List;
import org.hibernate.Session;

public class AlunoDAO{
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    public void salvar(Aluno a){
        sessao.save(a);
    }
    public void atualizar(Aluno a){
        sessao.update(a);
    }
    public void excluir(Aluno a){
        sessao.delete(a);
    }
    public Aluno carregar(Integer codigo){
        return (Aluno) this.sessao.get(Aluno.class, codigo);
    }
    
    public List<Aluno> listar(){
        return this.sessao.createCriteria(Aluno.class).list();
    }
    public Aluno buscar(Integer valor){
        // VER ESSE 'PARÂMETRO'. O 'codigo' deve ser a chave primária para todas as entidades
        return new Aluno(); // APAGAR
    }    
}
