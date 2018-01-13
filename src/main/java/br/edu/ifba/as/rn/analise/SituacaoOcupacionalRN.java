package br.edu.ifba.as.rn.analise;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.analise.SituacaoOcupacionalDAO;
import br.edu.ifba.as.entidades.analise.SituacaoOcupacional;
import java.util.List;

public class SituacaoOcupacionalRN {
    private SituacaoOcupacionalDAO situacaoOcupacionalDAO;

    public SituacaoOcupacionalRN() {
        this.situacaoOcupacionalDAO = DAOFactory.criarSituacaoOcupacionalDAO();
    }
    
    public void salvar(SituacaoOcupacional situacaoOcupacional){
        this.situacaoOcupacionalDAO.salvar(situacaoOcupacional);
    }
    public void excluir(SituacaoOcupacional situacaoOcupacional){
        this.situacaoOcupacionalDAO.excluir(situacaoOcupacional);
    }
    public SituacaoOcupacional carregar(Integer codigo){
        return this.situacaoOcupacionalDAO.carregar(codigo);
    }
    public List<SituacaoOcupacional> listar(){
        return this.situacaoOcupacionalDAO.listar();
    }    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos  
        SituacaoOcupacional desempregado = new SituacaoOcupacional();
        SituacaoOcupacional avisoPrevio = new SituacaoOcupacional();
        SituacaoOcupacional trabalhadorInformal = new SituacaoOcupacional();
        SituacaoOcupacional bpc = new SituacaoOcupacional();
        SituacaoOcupacional aposentadoPensionista = new SituacaoOcupacional();
        SituacaoOcupacional autonomo = new SituacaoOcupacional();
        SituacaoOcupacional estagiario = new SituacaoOcupacional();
        SituacaoOcupacional estudante = new SituacaoOcupacional();
        SituacaoOcupacional trabalhadorFormal = new SituacaoOcupacional();
        
        desempregado.setTipo("Desempregado(a)");
        avisoPrevio.setTipo("Aviso Prévio/Seguro desemprego");
        trabalhadorInformal.setTipo("Trabalhador(a) informal");
        bpc.setTipo("Beneficiário do BPC");
        aposentadoPensionista.setTipo("Aposentado(a)/Pensionista");
        autonomo.setTipo("Autônomo(a)");
        estagiario.setTipo("Estagiário remunerado");
        estudante.setTipo("Apenas estudando");
        trabalhadorFormal.setTipo("Trabalhador(a) formal");
        
        this.situacaoOcupacionalDAO.salvar(desempregado);
        this.situacaoOcupacionalDAO.salvar(avisoPrevio);
        this.situacaoOcupacionalDAO.salvar(trabalhadorInformal);
        this.situacaoOcupacionalDAO.salvar(bpc);
        this.situacaoOcupacionalDAO.salvar(aposentadoPensionista);
        this.situacaoOcupacionalDAO.salvar(autonomo);
        this.situacaoOcupacionalDAO.salvar(estagiario);
        this.situacaoOcupacionalDAO.salvar(estudante);
        this.situacaoOcupacionalDAO.salvar(trabalhadorFormal);
    }
    public Float getPeso(){
        int i = 0;
        Float peso = 0.0F;
        List<SituacaoOcupacional> list = listar();
        for(i=0; i<list.size(); i++){
            if(list.get(i).getPontuacao() != null)
            peso = peso + list.get(i).getPontuacao();
        }
        return peso;
    }    
    public SituacaoOcupacional buscarPorAspectoEmAvaliacao(String tipo){
        return this.situacaoOcupacionalDAO.buscarPorAspectoEmAvaliacao(tipo);
    }     
}
