package br.edu.ifba.paae.rn.analise;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.analise.BolsaDAO;
import br.edu.ifba.paae.entidades.analise.Bolsa;
import java.util.List;

public class BolsaRN {
    private BolsaDAO bolsaDAO;

    public BolsaRN() {
        this.bolsaDAO = DAOFactory.criarBolsaDAO();
    }
    
    public void salvar(Bolsa bolsa){
        this.bolsaDAO.salvar(bolsa);
    }
    public void excluir(Bolsa bolsa){
        this.bolsaDAO.excluir(bolsa);
    }
    public Bolsa carregar(Integer codigo){
        return this.bolsaDAO.carregar(codigo);
    }
    public List<Bolsa> listar(){
        return this.bolsaDAO.listar();
    }    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos
        System.out.println("\n\tDefinindo os padroes\n");
        Bolsa bolsaEstudo = new Bolsa();
        Bolsa auxilioMoradia = new Bolsa();
        Bolsa auxilioTransporte = new Bolsa();
        Bolsa auxilioAlimentacao = new Bolsa();
        Bolsa auxilioCopiaImpressao = new Bolsa();
        Bolsa auxilioAquisicoesViagens = new Bolsa();
        Bolsa bolsaPina = new Bolsa();
        
        bolsaEstudo.setNome("Bolsa de Estudos");
        auxilioMoradia.setNome("Auxílio Moradia");
        auxilioTransporte.setNome("Auxílio Transporte");
        auxilioAlimentacao.setNome("Auxílio Alimentação");
        auxilioCopiaImpressao.setNome("Auxílio Cópia e Impressão");
        auxilioAquisicoesViagens.setNome("Auxílio Aquisições e Viagens");
        bolsaPina.setNome("Bolsa PINA");
                
        this.bolsaDAO.salvar(bolsaEstudo);
        this.bolsaDAO.salvar(auxilioMoradia);
        this.bolsaDAO.salvar(auxilioTransporte);
        this.bolsaDAO.salvar(auxilioAlimentacao);
        this.bolsaDAO.salvar(auxilioCopiaImpressao);
        this.bolsaDAO.salvar(auxilioAquisicoesViagens);
        this.bolsaDAO.salvar(bolsaPina);
        
    }
}
