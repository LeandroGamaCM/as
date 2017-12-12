package conexao;

import br.edu.ifba.as.entidades.formulario.*;
import br.edu.ifba.as.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeletarDados {
    Session sessao = null;

    public DeletarDados(Session sessao) {
        this.sessao = sessao;
    }
    
    public void apagarAluno(){
        Aluno aluno = new Aluno();
        aluno.setAluno(5);
        sessao.delete(aluno);
    }
    public void apagarDespesa(){
        Despesa despesa = new Despesa();
        despesa.setDespesa(5);
        sessao.delete(despesa);
    }
    public void apagarEndereco(){
        Endereco e = new Endereco();
        e.setEndereco(5);
        sessao.delete(e);
    }

    public static void main(String[] args) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        DeletarDados dd = new DeletarDados(sessao);
        Transaction transacao = sessao.beginTransaction();
        
        dd.apagarDespesa();
        dd.apagarAluno();
        dd.apagarEndereco();

        
        transacao.commit();
        System.out.println("Deletou!");

    }
}
