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
        
        ruralMunicipioDiferente.setTipo("Na zona rural de município diferente do campus");
        municipioDiferente.setTipo("Em município diferente do campus");
        ruralMesmoMunicipio.setTipo("Na zona rural do município do campus");
        mesmoMunicipio.setTipo("No município do campus");
        
        this.localResidenciaFamiliaDAO.salvar(ruralMunicipioDiferente);
        this.localResidenciaFamiliaDAO.salvar(municipioDiferente);
        this.localResidenciaFamiliaDAO.salvar(ruralMesmoMunicipio);
        this.localResidenciaFamiliaDAO.salvar(mesmoMunicipio);
    }
    public Float getPeso(){
        int i = 0;
        Float peso = 0.0F;
        List<LocalResidenciaFamilia> list = listar();
        for(i=0; i<list.size(); i++){
            if(list.get(i).getPontuacao() != null)
            peso = peso + list.get(i).getPontuacao();
        }
        return peso;
    }   
    public LocalResidenciaFamilia buscarPorAspectoEmAvaliacao(String tipo){
        return this.localResidenciaFamiliaDAO.buscarPorAspectoEmAvaliacao(tipo);
    }     
}
