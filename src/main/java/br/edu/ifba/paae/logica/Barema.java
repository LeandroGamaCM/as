package br.edu.ifba.paae.logica;

import br.edu.ifba.paae.entidades.analise.*;
import br.edu.ifba.paae.rn.analise.*;
import java.util.ArrayList;
import java.util.List;

public class Barema {

    private List<Parametro> parametros = criarLista();
    
    public List<Parametro> criarLista() {
        List<Parametro> ListParametros = new ArrayList<>();
        
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

        List<ComposicaoFamiliar> composicaoFamiliars = composicaoFamiliarRN.listar();;
        List<CondicaoEconomicaEstudante> condicaoEconomicaEstudantes = condicaoEconomicaEstudanteRN.listar();
        List<DespesaAnalise> despesaAnalises = despesaAnaliseRN.listar();
        List<EscolaOrigem> escolaOrigems = escolaOrigemRN.listar();
        List<Etnia> etnias = etniaRN.listar();
        List<Genero> generos = generoRN.listar();
        List<LocalResidenciaFamilia> localResidenciaFamilias = localResidenciaFamiliaRN.listar();
        List<MoradiaEstudante> moradiaEstudantes = moradiaEstudanteRN.listar();
        List<MoradiaFamilia> moradiaFamilias = moradiaFamiliaRN.listar();
        List<ProgramaSocial> programaSocials = programaSocialRN.listar();
        List<RendaPrincipalOrigem> rendaPrincipalOrigems= rendaPrincipalOrigemRN.listar(); 
        List<RendaPerCapita> rendaPerCapitas = rendaPerCapitaRN.listar(); 
        List<Saude> saudes = saudeRN.listar();
        List<SituacaoOcupacional> situacaoOcupacionals = situacaoOcupacionalRN.listar();
   
        int i;

        for(i = 0; i < rendaPerCapitas.size(); i++){
            Parametro parametro = new Parametro();
            parametro.setCategoria("Renda per capita");
            parametro.setAspectoAvaliacao(rendaPerCapitas.get(i).getLimite().toString());
            parametro.setPontuacao(rendaPerCapitas.get(i).getPontuacao());
            parametro.setPeso(rendaPerCapitaRN.getPeso());
            ListParametros.add(parametro);
        }
        for(i = 0; i < rendaPrincipalOrigems.size(); i++){
            Parametro parametro = new Parametro();
            parametro.setCategoria("Origem da principal renda do grupo familiar");
            parametro.setAspectoAvaliacao(rendaPrincipalOrigems.get(i).getTipo());
            parametro.setPontuacao(rendaPrincipalOrigems.get(i).getPontuacao());
            parametro.setPeso(rendaPrincipalOrigemRN.getPeso());
            ListParametros.add(parametro);
        }
        for(i = 0; i < despesaAnalises.size(); i++){
            Parametro parametro = new Parametro();
            parametro.setCategoria("Despesas mensais do grupo familiar");
            parametro.setAspectoAvaliacao(despesaAnalises.get(i).getTipo());
            parametro.setPontuacao(despesaAnalises.get(i).getPontuacao());
            parametro.setPeso(despesaAnaliseRN.getPeso());            
            ListParametros.add(parametro);
        }
        for(i = 0; i < condicaoEconomicaEstudantes.size(); i++){
            Parametro parametro = new Parametro();
            parametro.setCategoria("Condição economica do estudante");
            parametro.setAspectoAvaliacao(condicaoEconomicaEstudantes.get(i).getTipo());
            parametro.setPontuacao(condicaoEconomicaEstudantes.get(i).getPontuacao());
            parametro.setPeso(condicaoEconomicaEstudanteRN.getPeso());
            ListParametros.add(parametro);
        }
        for(i = 0; i < generos.size(); i++){
            Parametro parametro = new Parametro();
            parametro.setCategoria("Gênero");
            parametro.setAspectoAvaliacao(generos.get(i).getTipo());
            parametro.setPontuacao(generos.get(i).getPontuacao());
            parametro.setPeso(generoRN.getPeso());
            ListParametros.add(parametro);
        }
        for(i = 0; i < etnias.size(); i++){
            Parametro parametro = new Parametro();
            parametro.setCategoria("Etnia");
            parametro.setAspectoAvaliacao(etnias.get(i).getTipo());
            parametro.setPontuacao(etnias.get(i).getPontuacao());
            parametro.setPeso(etniaRN.getPeso());
            ListParametros.add(parametro);
        }
        for(i = 0; i < composicaoFamiliars.size(); i++){
            Parametro parametro = new Parametro();
            parametro.setCategoria("Composição Familiar");
            parametro.setAspectoAvaliacao(composicaoFamiliars.get(i).getTipo());
            parametro.setPontuacao(composicaoFamiliars.get(i).getPontuacao());
            parametro.setPeso(composicaoFamiliarRN.getPeso());
            ListParametros.add(parametro);
        }
        for(i = 0; i < moradiaEstudantes.size(); i++){
            Parametro parametro = new Parametro();
            parametro.setCategoria("Moradia do estudante");
            parametro.setAspectoAvaliacao(moradiaEstudantes.get(i).getTipo());
            parametro.setPontuacao(moradiaEstudantes.get(i).getPontuacao());
            parametro.setPeso(moradiaEstudanteRN.getPeso());
            ListParametros.add(parametro);
        }
        for(i = 0; i < moradiaFamilias.size(); i++){
            Parametro parametro = new Parametro();
            parametro.setCategoria("Moradia da família");
            parametro.setAspectoAvaliacao(moradiaFamilias.get(i).getTipo());
            parametro.setPontuacao(moradiaFamilias.get(i).getPontuacao());
            parametro.setPeso(moradiaFamiliaRN.getPeso());
            ListParametros.add(parametro);
        }
        for(i = 0; i < localResidenciaFamilias.size(); i++){
            Parametro parametro = new Parametro();
            parametro.setCategoria("Local de residência da família");
            parametro.setAspectoAvaliacao(localResidenciaFamilias.get(i).getTipo());
            parametro.setPontuacao(localResidenciaFamilias.get(i).getPontuacao());
            parametro.setPeso(localResidenciaFamiliaRN.getPeso());
            ListParametros.add(parametro);
        }
        for(i = 0; i < situacaoOcupacionals.size(); i++){
            Parametro parametro = new Parametro();
            parametro.setCategoria("Situação ocupacional do estudante");
            parametro.setAspectoAvaliacao(situacaoOcupacionals.get(i).getTipo());
            parametro.setPontuacao(situacaoOcupacionals.get(i).getPontuacao());
            parametro.setPeso(situacaoOcupacionalRN.getPeso());
            ListParametros.add(parametro);
        }
        for(i = 0; i < programaSocials.size(); i++){
            Parametro parametro = new Parametro();
            parametro.setCategoria("Programas, projetos, serviços e benefícios governamentais");
            parametro.setAspectoAvaliacao(programaSocials.get(i).getTipo());
            parametro.setPontuacao(programaSocials.get(i).getPontuacao());
            parametro.setPeso(programaSocialRN.getPeso());
            ListParametros.add(parametro);
        }
        for(i = 0; i < saudes.size(); i++){
            Parametro parametro = new Parametro();
            parametro.setCategoria("Saúde");
            parametro.setAspectoAvaliacao(saudes.get(i).getTipo());
            parametro.setPontuacao(saudes.get(i).getPontuacao());
            parametro.setPeso(saudeRN.getPeso());
            ListParametros.add(parametro);
        }
        for(i = 0; i < escolaOrigems.size(); i++){
            Parametro parametro = new Parametro();
            parametro.setCategoria("Escola de origem");
            parametro.setAspectoAvaliacao(escolaOrigems.get(i).getTipo());
            parametro.setPontuacao(escolaOrigems.get(i).getPontuacao());
            parametro.setPeso(escolaOrigemRN.getPeso());
            ListParametros.add(parametro);
        }
        
        return ListParametros;
                
    }

    
// Getters e Setters

    public List<Parametro> getParametros() {
        return parametros;
    }

    public void setParametros(List<Parametro> parametros) {
        this.parametros = parametros;
    }
    


}
