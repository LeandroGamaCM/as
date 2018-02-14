package br.edu.ifba.paae.rn.analise;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.analise.ProgramaSocialDAO;
import br.edu.ifba.paae.entidades.analise.ProgramaSocial;
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
        bcp.setPontuacao(1F);
        
        pbf.setTipo("PBF");
        pbf.setPontuacao(1F);
        
        jovemAprendiz.setTipo("Programa JOVEM APRENDIZ");
        jovemAprendiz.setPontuacao(0.4F);
        
        proJovem.setTipo("Serviço socioeducativo PROJOVEM");
        proJovem.setPontuacao(0.4F);
        
        cras.setTipo("Atendimento no CRAS");
        cras.setPontuacao(0.4F);
        
        caps.setTipo("Atendimento no CAPS");
        caps.setPontuacao(0.4F);
        
        prouniFies.setTipo("PROUNI/FIES");
        prouniFies.setPontuacao(0.4F);
        
        this.programaSocialDAO.salvar(bcp);
        this.programaSocialDAO.salvar(pbf);
        this.programaSocialDAO.salvar(jovemAprendiz);
        this.programaSocialDAO.salvar(proJovem);
        this.programaSocialDAO.salvar(cras);
        this.programaSocialDAO.salvar(caps);
        this.programaSocialDAO.salvar(prouniFies);
    }
    public Float getPeso(){
        int i = 0;
        Float peso = 0.0F;
        List<ProgramaSocial> list = listar();
        for(i=0; i<list.size(); i++){
            if(list.get(i).getPontuacao() != null)
            peso = peso + list.get(i).getPontuacao();
        }
        return peso;
    }    
    public ProgramaSocial buscarPorAspectoEmAvaliacao(String tipo){
        return this.programaSocialDAO.buscarPorAspectoEmAvaliacao(tipo);
    } 
}
