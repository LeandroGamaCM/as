package br.edu.ifba.as.rn.analise;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.analise.RendaPrincipalOrigemDAO;
import br.edu.ifba.as.entidades.analise.RendaPrincipalOrigem;
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
        beneficios.setTipo("Apenas ajuda da família e outros");
        trabalhoInformalProvedor.setTipo("Trabalho informal do(s) provedor(es)");
        trabalhoRural.setTipo("Trabalhador rural/agricultura familiar");
        avisoPrevioSeguroDesemprego.setTipo("Aviso Prévio/Seguro desemprego/Estágio remunerado");
        beneficiosPrevidenciarios.setTipo("Benefício(s) previdenciário(s)");
        trabalhoAutonomo.setTipo("Trabalho autônomo do(s) provedor(es)");
        rendaLocacaoImoveis.setTipo("Trabalho autônomo do(s) provedor(es)");
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
    
}
