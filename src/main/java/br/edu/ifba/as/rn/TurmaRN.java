package br.edu.ifba.as.rn;

import br.edu.ifba.as.dao.TurmaDAO;
import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.entidades.formulario.Turma;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public Turma buscarPorNome(String turma){
        return this.turmaDAO.buscarPorNome(turma);
    }
    public Turma carregar(Integer codigo){
        return this.turmaDAO.carregar(codigo);
    }
    public List<Turma> listar(){
        return this.turmaDAO.listar();
    }
    public Set<String> listarTurmas(String curso){
        List<Turma> turmas = this.turmaDAO.buscarPorCurso(curso);
        int i;
        Set<String> nomes = new HashSet<>();
        
        if(turmas == null || turmas.isEmpty()){
            return null;
        }else{
            for(i=0;i<turmas.size();i++){
                nomes.add(turmas.get(i).getNome());
            }            
        }    
        return nomes;
    }
    public Set<String> listarCursos(String modalidade){
        List<Turma> turmas = this.turmaDAO.buscarPorModalidade(modalidade);
        int i;
        Set<String> cursos = new HashSet<>();
        
        if(turmas == null || turmas.isEmpty()){
            return null;
        }else{
            for(i=0;i<turmas.size();i++){
                cursos.add(turmas.get(i).getCurso());
            }            
        }    
        return cursos;

    }
    public Set<String> listarModalidades(){
        List<Turma> turmas = listar();
        int i;
        Set<String> modalidades = new HashSet<>();
        
        if(turmas == null || turmas.isEmpty()){
            return null;
        }else{
            for(i=0;i<turmas.size();i++){
                modalidades.add(turmas.get(i).getModalidade());
            }            
        }    
        return modalidades;
    }
}
