package br.edu.ifba.as.rn.analise;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.analise.LocalResidenciaFamiliaDAO;
import br.edu.ifba.as.entidades.analise.LocalResidenciaFamilia;
import java.util.List;

public class LocalResidenciaFamiliaRN {
    private LocalResidenciaFamiliaDAO localResidenciaFamiliaDAO;

    public LocalResidenciaFamiliaRN() {
        this.localResidenciaFamiliaDAO = DAOFactory.criarLocalResidenciaFamiliaDAO();
    }
    
    public void salvar(LocalResidenciaFamilia localResidenciaFamilia){
        this.localResidenciaFamiliaDAO.salvar(localResidenciaFamilia);
    }
    public void excluir(LocalResidenciaFamilia localResidenciaFamilia){
        this.localResidenciaFamiliaDAO.excluir(localResidenciaFamilia);
    }
    public LocalResidenciaFamilia carregar(Integer codigo){
        return this.localResidenciaFamiliaDAO.carregar(codigo);
    }
    public List<LocalResidenciaFamilia> listar(){
        return this.localResidenciaFamiliaDAO.listar();
    }    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos   
        LocalResidenciaFamilia ruralMunicipioDiferente = new LocalResidenciaFamilia();
        LocalResidenciaFamilia municipioDiferente = new LocalResidenciaFamilia();
        LocalResidenciaFamilia ruralMesmoMunicipio = new LocalResidenciaFamilia();
        LocalResidenciaFamilia mesmoMunicipio = new LocalResidenciaFamilia();
        
        ruralMesmoMunicipio.setTipo("Na zona rural do município do campus");
        ruralMunicipioDiferente.setTipo("Na zona rural de município diferente do campus");
        mesmoMunicipio.setTipo("No município do campus");
        municipioDiferente.setTipo("Em município diferente do campus");
        
        this.localResidenciaFamiliaDAO.salvar(ruralMesmoMunicipio);
        this.localResidenciaFamiliaDAO.salvar(ruralMunicipioDiferente);
        this.localResidenciaFamiliaDAO.salvar(mesmoMunicipio);
        this.localResidenciaFamiliaDAO.salvar(municipioDiferente);
    }
    
}
