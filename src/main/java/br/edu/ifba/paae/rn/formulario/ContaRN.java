package br.edu.ifba.paae.rn.formulario;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.formulario.ContaDAO;
import br.edu.ifba.paae.entidades.formulario.Conta;
import java.util.List;

public class ContaRN {
    private ContaDAO contaDAO;

    public ContaRN() {
        this.contaDAO = DAOFactory.criarContaDAO();
    }
    
    public void salvar(Conta conta){
        this.contaDAO.salvar(conta);
    }
    public void excluir(Conta conta){
        this.contaDAO.excluir(conta);
    }
    public Conta buscarPorAluno(Integer codAluno){
        return this.contaDAO.buscarPorAluno(codAluno);
    }
    public Conta carregar(Integer codigo){
        return this.contaDAO.carregar(codigo);
    }
    public List<Conta> listar(){
        return this.contaDAO.listar();
    }
            
}
