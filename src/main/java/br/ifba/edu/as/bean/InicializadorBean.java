package br.ifba.edu.as.bean;

import br.edu.ifba.as.rn.UsuarioRN;
import br.edu.ifba.as.rn.analise.BolsaRN;
import br.edu.ifba.as.rn.analise.ComposicaoFamiliarRN;
import br.edu.ifba.as.rn.analise.CondicaoEconomicaEstudanteRN;
import br.edu.ifba.as.rn.analise.DespesaAnaliseRN;
import br.edu.ifba.as.rn.analise.EscolaOrigemRN;
import br.edu.ifba.as.rn.analise.EtniaRN;
import br.edu.ifba.as.rn.analise.GeneroRN;
import br.edu.ifba.as.rn.analise.LocalResidenciaFamiliaRN;
import br.edu.ifba.as.rn.analise.MoradiaEstudanteRN;
import br.edu.ifba.as.rn.analise.MoradiaFamiliaRN;
import br.edu.ifba.as.rn.analise.ProgramaSocialRN;
import br.edu.ifba.as.rn.analise.RendaPerCapitaRN;
import br.edu.ifba.as.rn.analise.RendaPrincipalOrigemRN;
import br.edu.ifba.as.rn.analise.SaudeRN;
import br.edu.ifba.as.rn.analise.SituacaoOcupacionalRN;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class InicializadorBean {
    
    @PostConstruct
    public void init(){
        inicializar();
    }

    public void inicializar(){
        BolsaRN bolsaRN = new BolsaRN();
        ComposicaoFamiliarRN composicaoFamiliarRN = new ComposicaoFamiliarRN();
        CondicaoEconomicaEstudanteRN condicaoEconomicaEstudanteRN = new CondicaoEconomicaEstudanteRN();
        DespesaAnaliseRN despesaAnaliseRN = new DespesaAnaliseRN();
        EscolaOrigemRN escolaOrigemRN = new EscolaOrigemRN();
        EtniaRN etniaRN = new EtniaRN();
        GeneroRN generoRN = new GeneroRN();
        LocalResidenciaFamiliaRN localResidenciaFamiliaRN = new LocalResidenciaFamiliaRN();
        MoradiaEstudanteRN moradiaEstudanteRN = new MoradiaEstudanteRN();
        MoradiaFamiliaRN moradiaFamiliaRN = new MoradiaFamiliaRN();
        ProgramaSocialRN programaSocialRN = new ProgramaSocialRN();
        RendaPerCapitaRN rendaPerCapitaRN = new RendaPerCapitaRN();
        RendaPrincipalOrigemRN rendaPrincipalOrigemRN = new RendaPrincipalOrigemRN();
        SaudeRN saudeRN = new SaudeRN();
        SituacaoOcupacionalRN situacaoOcupacionalRN = new SituacaoOcupacionalRN();
        UsuarioRN usuarioRN = new UsuarioRN();

        if(usuarioRN.listar() == null || usuarioRN.listar().isEmpty()){
            System.out.println("Cadastrou usuario");
            usuarioRN.criarADM();
        }
        if(bolsaRN.listar() == null || bolsaRN.listar().isEmpty()){
            System.out.println("\n\tEntrou no if de bolsa\n");
            bolsaRN.definirPadroes();
        }
        if(composicaoFamiliarRN.listar() == null || composicaoFamiliarRN.listar().isEmpty()){
            composicaoFamiliarRN.definirPadroes();
        }
        if(condicaoEconomicaEstudanteRN.listar() == null || condicaoEconomicaEstudanteRN.listar().isEmpty()){
            condicaoEconomicaEstudanteRN.definirPadroes();
        }
        if(despesaAnaliseRN.listar() == null || despesaAnaliseRN.listar().isEmpty()){
            despesaAnaliseRN.definirPadroes();
        }
        if(escolaOrigemRN.listar() == null || escolaOrigemRN.listar().isEmpty()){
            escolaOrigemRN.definirPadroes();
        }
        if(etniaRN.listar() == null || etniaRN.listar().isEmpty()){
            etniaRN.definirPadroes();
        }
        if(generoRN.listar() == null || generoRN.listar().isEmpty()){
            generoRN.definirPadroes();
        }
        if(localResidenciaFamiliaRN.listar() == null || localResidenciaFamiliaRN.listar().isEmpty()){
            localResidenciaFamiliaRN.definirPadroes();
        }
        if(moradiaEstudanteRN.listar() == null || moradiaEstudanteRN.listar().isEmpty()){
            moradiaEstudanteRN.definirPadroes();
        }
        if(moradiaFamiliaRN.listar() == null || moradiaFamiliaRN.listar().isEmpty()){
            moradiaFamiliaRN.definirPadroes();
        }
        if(programaSocialRN.listar() == null || programaSocialRN.listar().isEmpty()){
            programaSocialRN.definirPadroes();
        }
        if(rendaPerCapitaRN.listar() == null || rendaPerCapitaRN.listar().isEmpty()){
            rendaPerCapitaRN.definirPadroes();
        }
        if(rendaPrincipalOrigemRN.listar() == null || rendaPrincipalOrigemRN.listar().isEmpty()){
            rendaPrincipalOrigemRN.definirPadroes();
        }
        if(saudeRN.listar() == null || saudeRN.listar().isEmpty()){
            saudeRN.definirPadroes();
        }
        if(situacaoOcupacionalRN.listar() == null || situacaoOcupacionalRN.listar().isEmpty()){
            situacaoOcupacionalRN.definirPadroes();
        }
    }


}
