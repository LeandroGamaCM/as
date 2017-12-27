package br.edu.ifba.as.rn;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.EnderecoDAO;
import br.edu.ifba.as.entidades.formulario.Endereco;
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
