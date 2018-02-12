package br.edu.ifba.paae.rn.formulario;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.formulario.EnderecoDAO;
import br.edu.ifba.paae.entidades.formulario.Endereco;
import java.util.List;
import java.util.Locale;

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
    public boolean comparaCidadeAIrece(Endereco endereco){
        if(endereco.getCidade() != null){
            String cidade = endereco.getCidade().toLowerCase(Locale.ROOT);
    
            if(cidade.equals("irece") || cidade.equals("irecê")){
                return true;
            }
        }
        
        return false;
    }

}
