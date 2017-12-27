package conexao;

import br.edu.ifba.as.entidades.formulario.*;
import br.edu.ifba.as.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class BuscarDados {
    Session s = null;

    public BuscarDados(Session s) {
        this.s = s;
    }

    
    
    public Aluno buscarPorCPF(Integer cpf){
        String hql = "select u from Aluno u where u.cpf = :cpf";
        Query c = this.s.createQuery(hql);
        c.setString("cpf", cpf.toString());
        return (Aluno) c.uniqueResult();
    }
    public Endereco buscarEndereco(Integer cod_aluno){
        String hql = "select u from Endereco u where u.cod_aluno = :cod_aluno";
        Query c = this.s.createQuery(hql);
        c.setString("cod_aluno", cod_aluno.toString());
        return (Endereco) c.uniqueResult();
        
    }

    
    public static void main(String[] args) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        BuscarDados buscarDados = new BuscarDados(sessao);
        Aluno a = buscarDados.buscarPorCPF(111);
        System.out.println("Nome: " + a.getNome());
        System.out.println("Código: " + a.getAluno());
//        Endereco e = buscarDados.buscarEndereco(1);
//        System.out.println("Rua: " + e.getRua());
//        System.out.println("Cod_aluno: " + e.getAluno().getAluno());
    }
    
    
}
