package br.edu.ifba.paae.rn.formulario;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.formulario.AlunoDAO;
import br.edu.ifba.paae.entidades.formulario.Aluno;
import br.edu.ifba.paae.entidades.formulario.Formulario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AlunoRN {
    private AlunoDAO alunoDAO;

    public AlunoRN() {
        this.alunoDAO = DAOFactory.criarAlunoDAO();
    }
    
    public Aluno carregar(Integer codigo){
        return this.alunoDAO.carregar(codigo);
    }
    public Aluno buscarPorCPF(String cpf){
        return this.alunoDAO.buscarPorCPF(cpf);
    }    
    public void salvar(Aluno aluno){
        this.alunoDAO.salvar(aluno);
    } 
    public void excluir(Aluno aluno){
        this.alunoDAO.excluir(aluno);
    }
    public List<Aluno> listar(){
        return this.alunoDAO.listar();
    }
    public List<Aluno> buscarPorNome(String nome){
        return this.alunoDAO.buscarPorNome(nome);
    }
    public List<Aluno> buscarPorTurma(Integer codTurma){
        return this.alunoDAO.buscarPorTurma(codTurma);
    }
    public List<Aluno> listarPorModalidade(String modalidade){
        return this.alunoDAO.listarPorModalidade(modalidade);
    }
    public List<Aluno> listarPorCurso(String curso){
        return this.alunoDAO.listarPorCurso(curso);
    }
    public List<Aluno> listarPorModalidadeCurso(String modalidade, String curso){
        return this.alunoDAO.listarPorModalidadeCurso(modalidade, curso);
    }
    public List<Aluno> buscarCPFNomeRG(String valor){
        return  this.alunoDAO.buscarCPFNomeRG(valor);
    }    
    public List<Aluno> alunosAtuais(){
        List<Aluno> lista = listar();
        FormularioRN formularioRN = new FormularioRN();
        Formulario formulario;
        List<Aluno> alunos = new ArrayList<>();
        
        int i = 0;
        if(lista != null){
            while (i < lista.size()){
                formulario = formularioRN.buscarPorAluno(lista.get(i).getAluno());
                Calendar cal = Calendar.getInstance();
                if(formulario != null && formulario.getDataInscricao() != null){
                    if(cal.getTime().getYear() == formulario.getDataInscricao().getYear()){
                        alunos.add(lista.get(i));
                    }
                }
                i++;
            }
        }
        return alunos;
    }
    public List<Aluno> alunosCadastrados(){
        return this.alunoDAO.alunosCadastrados();
    }
    public List<Aluno> alunosInscritos(){
        return this.alunoDAO.alunosInscritos();
    }    
}
