package br.edu.ifba.paae.dao.formulario;

import br.edu.ifba.paae.entidades.formulario.Aluno;
import br.edu.ifba.paae.entidades.formulario.Turma;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class TurmaDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    public void salvar(Turma turma){
        sessao.saveOrUpdate(turma);
    }
    public void excluir(Turma turma){
//        AlunoDAO alunoDAO = new AlunoDAO();
//        System.out.println("Turma.id: " + turma.getTurma());
//        List<Aluno> alunos = alunoDAO.buscarPorTurma(turma.getTurma());
//        int i=0;
//        if(alunos != null && !alunos.isEmpty()){
//            while(i<alunos.size()){
//                Aluno aluno = alunos.get(i);
//                aluno.setTurma(null);
//                alunoDAO.salvar(aluno);
//            }
//        }
        sessao.delete(turma);
    }

    public List<Turma> listarCursos(String modalidade){
        return this.sessao.createCriteria(Turma.class).add(Restrictions.eq("modalidade", modalidade)).list();
    }
    public List<Turma> listarTurmas(String modalidade, String curso){
        return this.sessao.createCriteria(Turma.class).add(Restrictions.eq("modalidade", modalidade)).add(Restrictions.like("curso", curso)).list();
    }
    public Turma buscarTurma(String modalidade, String curso, String turma){
        return (Turma) this.sessao.createCriteria(Turma.class).add(Restrictions.eq("modalidade", modalidade)).add(Restrictions.like("curso", curso)).add(Restrictions.like("nome", turma)).uniqueResult();
    }            
    public Turma carregar(Integer codigo){
        return (Turma) this.sessao.get(Turma.class, codigo);
    }
    public List<Turma> listar(){
        return this.sessao.createCriteria(Turma.class).list();
    }
    public Turma buscarPorAluno(Integer codAluno){
        String hql = "select t from Turma t, Aluno a where t.turma = a.turma AND a.aluno = :codAluno";
        Query c = this.sessao.createQuery(hql);
        c.setString("codAluno", codAluno.toString());
        return (Turma) c.uniqueResult();        
    }
}
