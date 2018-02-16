package br.edu.ifba.paae.rn.formulario;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.formulario.AlunoDAO;
import br.edu.ifba.paae.entidades.formulario.Aluno;
import br.edu.ifba.paae.entidades.inscricao.PeriodoInscricao;
import br.edu.ifba.paae.rn.inscricao.PeriodoInscricaoRN;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        return this.alunoDAO.buscarCPFNomeRG(valor);
    }    
    public List<Aluno> alunosAtuais(List<Aluno> lista){
        List<Aluno> alunos = new ArrayList<>();
        PeriodoInscricaoRN periodoInscricaoRN = new PeriodoInscricaoRN();
        PeriodoInscricao periodoInscricaoAluno;
        PeriodoInscricao periodoInscricao;
        
        int i = 0;
        LocalDateTime now = LocalDateTime.now();
        Integer ano;
        
        periodoInscricao = periodoInscricaoRN.buscarPorAno(now.getYear());
        
        if(periodoInscricao == null){
            periodoInscricao = periodoInscricaoRN.buscarPorAno(now.getYear()-1);
        }
        if(periodoInscricao != null){
            ano = periodoInscricao.getAno();

            if(lista != null){
                while (i < lista.size()){
                    periodoInscricaoAluno = periodoInscricaoRN.buscarPorAluno(lista.get(i).getAluno());
                    if(periodoInscricaoAluno != null && Objects.equals(ano, periodoInscricaoAluno.getAno())){
                        alunos.add(lista.get(i));
                    }
                    i++;
                }
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
    public List<Aluno> alunosEntrevistados(){
        return this.alunoDAO.alunosEntrevistados();
    }
    public List<Aluno> alunosNAOEntrevistados(){
        return this.alunoDAO.alunosNAOEntrevistados();
    }
}
