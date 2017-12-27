package br.edu.ifba.as.rn;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.ResidenciaFamiliaDAO;
import br.edu.ifba.as.entidades.formulario.ResidenciaFamilia;
import java.util.List;

public class ResidenciaFamiliaRN {
    private ResidenciaFamiliaDAO residenciaFamiliaDAO;

    public ResidenciaFamiliaRN() {
        this.residenciaFamiliaDAO = DAOFactory.criarResidenciaFamiliaDAO();
    }
    
    public void salvar(ResidenciaFamilia residenciaFamilia){
        this.residenciaFamiliaDAO.salvar(residenciaFamilia);
    }
    public void excluir(ResidenciaFamilia residenciaFamilia){
        this.residenciaFamiliaDAO.excluir(residenciaFamilia);
    }
    public ResidenciaFamilia buscarPorFamilia(Integer codFamilia){
        return this.residenciaFamiliaDAO.buscarPorFamilia(codFamilia);
    }
    public ResidenciaFamilia carregar(Integer codigo){
        return this.residenciaFamiliaDAO.carregar(codigo);
    }
    public List<ResidenciaFamilia> listar(){
        return this.residenciaFamiliaDAO.listar();
    }
             
}
