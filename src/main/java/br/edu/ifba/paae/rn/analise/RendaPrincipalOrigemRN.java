package br.edu.ifba.paae.rn.analise;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.analise.RendaPrincipalOrigemDAO;
import br.edu.ifba.paae.entidades.analise.RendaPrincipalOrigem;
import java.util.List;

public class RendaPrincipalOrigemRN {
    private RendaPrincipalOrigemDAO rendaPrincipalOrigemDAO;

    public RendaPrincipalOrigemRN() {
        this.rendaPrincipalOrigemDAO = DAOFactory.criarRendaPrincipalOrigemDAO();
    }
    
    public void salvar(RendaPrincipalOrigem rendaPrincipalOrigem){
        this.rendaPrincipalOrigemDAO.salvar(rendaPrincipalOrigem);
    }
    public void excluir(RendaPrincipalOrigem rendaPrincipalOrigem){
        this.rendaPrincipalOrigemDAO.excluir(rendaPrincipalOrigem);
    }
    public RendaPrincipalOrigem carregar(Integer codigo){
        return this.rendaPrincipalOrigemDAO.carregar(codigo);
    }
    public List<RendaPrincipalOrigem> listar(){
        return this.rendaPrincipalOrigemDAO.listar();
    }    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos  
        RendaPrincipalOrigem ajuda = new RendaPrincipalOrigem();
        RendaPrincipalOrigem beneficios = new RendaPrincipalOrigem();
        RendaPrincipalOrigem trabalhoInformalProvedor = new RendaPrincipalOrigem();
        RendaPrincipalOrigem trabalhoRural = new RendaPrincipalOrigem();
        RendaPrincipalOrigem avisoPrevioSeguroDesemprego = new RendaPrincipalOrigem();
        RendaPrincipalOrigem beneficiosPrevidenciarios = new RendaPrincipalOrigem();
        RendaPrincipalOrigem trabalhoAutonomo = new RendaPrincipalOrigem();
        RendaPrincipalOrigem rendaLocacaoImoveis = new RendaPrincipalOrigem();
        RendaPrincipalOrigem trabalhoFormalProvedor = new RendaPrincipalOrigem();

        ajuda.setTipo("Apenas ajuda da família e outros");
        beneficios.setTipo("Apenas benefícios assistenciais PBF");
        trabalhoInformalProvedor.setTipo("Trabalho informal do(s) provedor(es)");
        trabalhoRural.setTipo("Trabalhador rural/agricultura familiar");
        avisoPrevioSeguroDesemprego.setTipo("Aviso Prévio/Seguro desemprego/Estágio remunerado");
        beneficiosPrevidenciarios.setTipo("Benefício(s) previdenciário(s)");
        trabalhoAutonomo.setTipo("Trabalho autônomo do(s) provedor(es)");
        rendaLocacaoImoveis.setTipo("Renda da locação de imóveis (exclusivamente)");
        trabalhoFormalProvedor.setTipo("Trabalho formal do(s) provedore(s)");

        this.rendaPrincipalOrigemDAO.salvar(ajuda);
        this.rendaPrincipalOrigemDAO.salvar(beneficios);
        this.rendaPrincipalOrigemDAO.salvar(trabalhoInformalProvedor);
        this.rendaPrincipalOrigemDAO.salvar(trabalhoRural);
        this.rendaPrincipalOrigemDAO.salvar(avisoPrevioSeguroDesemprego);
        this.rendaPrincipalOrigemDAO.salvar(beneficiosPrevidenciarios);
        this.rendaPrincipalOrigemDAO.salvar(trabalhoAutonomo);
        this.rendaPrincipalOrigemDAO.salvar(rendaLocacaoImoveis);
        this.rendaPrincipalOrigemDAO.salvar(trabalhoFormalProvedor);
    
    }
    public Float getPeso(){
        int i = 0;
        Float peso = 0.0F;
        List<RendaPrincipalOrigem> list = listar();
        for(i=0; i<list.size(); i++){
            if(list.get(i).getPontuacao() != null)            
            peso = peso + list.get(i).getPontuacao();
        }
        return peso;
    }    
    public RendaPrincipalOrigem buscarPorAspectoEmAvaliacao(String tipo){
        return this.rendaPrincipalOrigemDAO.buscarPorAspectoEmAvaliacao(tipo);
    }     
}
