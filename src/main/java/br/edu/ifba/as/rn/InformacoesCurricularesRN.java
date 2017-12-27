package br.edu.ifba.as.rn;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.InformacoesCurricularesDAO;
import br.edu.ifba.as.entidades.formulario.InformacoesCurriculares;
import java.util.List;

public class InformacoesCurricularesRN {
    private InformacoesCurricularesDAO informacoesCurricularesDAO;

    public InformacoesCurricularesRN() {
        this.informacoesCurricularesDAO = DAOFactory.criarInformacoesCurricularesDAO();
    }
    
    public void salvar(InformacoesCurriculares informacoesCurriculares){
        this.informacoesCurricularesDAO.salvar(informacoesCurriculares);
    }
    public void excluir(InformacoesCurriculares informacoesCurriculares){
        this.informacoesCurricularesDAO.excluir(informacoesCurriculares);
    }
    public InformacoesCurriculares buscarPorAluno(Integer codAluno){
        return this.informacoesCurricularesDAO.buscarPorAluno(codAluno);
    }
    public InformacoesCurriculares carregar(Integer codigo){
        return this.informacoesCurricularesDAO.carregar(codigo);
    }
    public List<InformacoesCurriculares> listar(){
        return this.informacoesCurricularesDAO.listar();
    }
         
}
