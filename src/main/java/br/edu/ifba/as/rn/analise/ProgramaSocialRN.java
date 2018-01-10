package br.edu.ifba.as.rn.analise;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.analise.ProgramaSocialDAO;
import br.edu.ifba.as.entidades.analise.ProgramaSocial;
import java.util.List;

public class ProgramaSocialRN {
    private ProgramaSocialDAO programaSocialDAO;

    public ProgramaSocialRN() {
        this.programaSocialDAO = DAOFactory.criarProgramaSocialDAO();
    }
    
    public void salvar(ProgramaSocial programaSocial){
        this.programaSocialDAO.salvar(programaSocial);
    }
    public void excluir(ProgramaSocial programaSocial){
        this.programaSocialDAO.excluir(programaSocial);
    }
    public ProgramaSocial carregar(Integer codigo){
        return this.programaSocialDAO.carregar(codigo);
    }
    public List<ProgramaSocial> listar(){
        return this.programaSocialDAO.listar();
    }    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos  
        ProgramaSocial bcp = new ProgramaSocial();
        ProgramaSocial pbf = new ProgramaSocial();
        ProgramaSocial jovemAprendiz = new ProgramaSocial();
        ProgramaSocial proJovem = new ProgramaSocial();
        ProgramaSocial cras = new ProgramaSocial();
        ProgramaSocial caps = new ProgramaSocial();
        ProgramaSocial prouniFies = new ProgramaSocial();
        
        bcp.setTipo("BCP");
        pbf.setTipo("PBF");
        jovemAprendiz.setTipo("Programa JOVEM APRENDIZ");
        proJovem.setTipo("Serviço socioeducativo PROJOVEM");
        cras.setTipo("Atendimento no CRAS");
        caps.setTipo("Atendimento no CAPS");
        prouniFies.setTipo("PROUNI/FIES");
        
        this.programaSocialDAO.salvar(bcp);
        this.programaSocialDAO.salvar(pbf);
        this.programaSocialDAO.salvar(jovemAprendiz);
        this.programaSocialDAO.salvar(proJovem);
        this.programaSocialDAO.salvar(cras);
        this.programaSocialDAO.salvar(caps);
        this.programaSocialDAO.salvar(prouniFies);
    }
    
}
