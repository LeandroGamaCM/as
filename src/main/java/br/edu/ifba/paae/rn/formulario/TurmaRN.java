package br.edu.ifba.paae.rn.formulario;

import br.edu.ifba.paae.dao.formulario.TurmaDAO;
import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.entidades.formulario.Turma;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TurmaRN {
    private TurmaDAO turmaDAO;

    public TurmaRN() {
        this.turmaDAO = DAOFactory.criarTurmaDAO();
    }
    
    public void salvar(Turma turma){
        this.turmaDAO.salvar(turma);
    }
    public void excluir(Turma turma){
        this.turmaDAO.excluir(turma);
    }
    public Turma carregar(Integer codigo){
        return this.turmaDAO.carregar(codigo);
    }
    public List<Turma> listar(){
        return this.turmaDAO.listar();
    }
    public List<String> listarTurmas(String modalidade, String curso){
        List<Turma> turmas = this.turmaDAO.listarTurmas(modalidade, curso);
        int i;
        List<String> nomes = new ArrayList<>();
        
        if(turmas == null || turmas.isEmpty()){
            return null;
        }else{
            for(i=0;i<turmas.size();i++){
                nomes.add(turmas.get(i).getNome());
            }            
        }    
        Collections.sort(nomes, Collator.getInstance());  
        return nomes;
    }
    public List<String> listarCursos(String modalidade){
        List<Turma> turmas = this.turmaDAO.listarCursos(modalidade);
        int i;
        List<String> cursos = new ArrayList<>();
        
        if(turmas == null || turmas.isEmpty()){
            return null;
        }else{
            for(i=0;i<turmas.size();i++){
                cursos.add(turmas.get(i).getCurso());
            }            
        }    
        Collections.sort(cursos, Collator.getInstance());        
        return cursos;

    }
    public List<String> listarCursos(){
        List<Turma> turmas = listar();
        int i;
        List<String> cursos = new ArrayList<>();
        
        if(turmas == null || turmas.isEmpty()){
            return null;
        }else{
            for(i=0;i<turmas.size();i++){
                cursos.add(turmas.get(i).getCurso());
            }            
        }    
        Collections.sort(cursos, Collator.getInstance());
        return cursos;        
    }
    public List<String> listarModalidades(){
        List<Turma> turmas = listar();
        int i;
        List<String> modalidades = new ArrayList<>();
        
        if(turmas == null || turmas.isEmpty()){
            return null;
        }else{
            for(i=0;i<turmas.size();i++){
                modalidades.add(turmas.get(i).getModalidade());
            }            
        }    
        Collections.sort(modalidades, Collator.getInstance());
        return modalidades;
    }
    public Turma buscarTurma(String modalidade, String curso, String turma){
        return this.turmaDAO.buscarTurma(modalidade, curso, turma);
    }
    public Turma buscarPorAluno(Integer codAluno){
        return this.turmaDAO.buscarPorAluno(codAluno);
    }
    
}
