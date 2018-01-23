package br.edu.ifba.paae.rn.formulario;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.formulario.EnderecoDAO;
import br.edu.ifba.paae.entidades.formulario.Endereco;
import java.util.List;

public class EnderecoRN {
    private EnderecoDAO enderecoDAO;

    public EnderecoRN() {
        this.enderecoDAO = DAOFactory.criarEnderecoDAO();
    }
    
    public void salvar(Endereco endereco){
        this.enderecoDAO.salvar(endereco);
    }
    public void excluir(Endereco endereco){
        this.enderecoDAO.excluir(endereco);
    }
    public Endereco buscarPorAluno(Integer codAluno){
        return this.enderecoDAO.buscarPorAluno(codAluno);
    }
    public Endereco carregar(Integer codigo){
        return this.enderecoDAO.carregar(codigo);
    }
    public List<Endereco> listar(){
        return this.enderecoDAO.listar();
    }
        
}
