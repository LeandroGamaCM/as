package br.edu.ifba.as.logica.telaBolsas;

import br.edu.ifba.as.entidades.analise.*;
import br.edu.ifba.as.rn.analise.*;
import java.util.ArrayList;
import java.util.List;

public class Barema {


    private List<Parametro> parametros = criarLista();

    public Barema() {
        
    }
    
    public void salvar(Parametro parametro){
        parametros = criarLista();
        System.out.println("\nParametro: \n\tCategoria: " + parametro.getCategoria() + "\n\tAspectoAvaliacao: " + parametro.getAspectoAvaliacao() + "\n\tPontuacao: " + parametro.getPontuacao());
        
        int i;
        for(i = 0; i<parametros.size(); i++){
            if(parametro.getCategoria().equals(parametros.get(i).getCategoria()) && "Composição Familiar".equals(parametro.getCategoria())){
                ComposicaoFamiliarRN rn = new ComposicaoFamiliarRN();
                System.out.println("\tEntrou em Composicao Familar");

                if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
                    System.out.println("\tEntrou no aspecto avaliação");
                    ComposicaoFamiliar aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
                    System.out.println("\tAux: \n\tAspectoAvaliacao: " + aux.getTipo() + "\n\tPontuacao: " + aux.getPontuacao());

                    aux.setPontuacao(parametro.getPontuacao());
                    rn.salvar(aux);
                    System.out.println("\nO novo aux: ");
                    System.out.println("\tAux: \n\tAspectoAvaliacao: " + aux.getTipo() + "\n\tPontuacao: " + aux.getPontuacao());
                    System.out.println("\tSalvou");
                    break;
                }
            }
//            if(parametro.getCategoria().equals(parametros.get(i).getCategoria()) && "Renda per capita".equals(parametro.getCategoria())){
//                RendaPerCapitaRN rn = new RendaPerCapitaRN();
//
//                if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
//                    RendaPerCapita aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
//                    aux.setPontuacao(parametro.getPontuacao());
//                    rn.salvar(aux);
//                    System.out.println("\tSalvou");
//                }
//            }
            if(parametro.getCategoria().equals(parametros.get(i).getCategoria()) && "Origem da principal renda do grupo familiar".equals(parametro.getCategoria())){
                RendaPrincipalOrigemRN rn = new RendaPrincipalOrigemRN();

                if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
                    RendaPrincipalOrigem aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
                    aux.setPontuacao(parametro.getPontuacao());
                    rn.salvar(aux);
                    System.out.println("\tSalvou");
                }
            }
            if(parametro.getCategoria().equals(parametros.get(i).getCategoria()) && "Despesas mensais do grupo familiar".equals(parametro.getCategoria())){
                DespesaAnaliseRN rn = new DespesaAnaliseRN();

                if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
                    DespesaAnalise aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
                    aux.setPontuacao(parametro.getPontuacao());
                    rn.salvar(aux);
                    System.out.println("\tSalvou");
                }
            }
            if(parametro.getCategoria().equals(parametros.get(i).getCategoria()) && "Condição economica do estudante".equals(parametro.getCategoria())){
                CondicaoEconomicaEstudanteRN rn = new CondicaoEconomicaEstudanteRN();

                if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
                    CondicaoEconomicaEstudante aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
                    aux.setPontuacao(parametro.getPontuacao());
                    rn.salvar(aux);
                    System.out.println("\tSalvou");
                }
            }
            if(parametro.getCategoria().equals(parametros.get(i).getCategoria()) && "Gênero".equals(parametro.getCategoria())){
                GeneroRN rn = new GeneroRN();

                if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
                    Genero aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
                    aux.setPontuacao(parametro.getPontuacao());
                    rn.salvar(aux);
                    System.out.println("\tSalvou");
                }
            }
            if(parametro.getCategoria().equals(parametros.get(i).getCategoria()) && "Etnia".equals(parametro.getCategoria())){
                EtniaRN rn = new EtniaRN();

                if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
                    Etnia aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
                    aux.setPontuacao(parametro.getPontuacao());
                    rn.salvar(aux);
                    System.out.println("\tSalvou");
                }
            }
            if(parametro.getCategoria().equals(parametros.get(i).getCategoria()) && "Moradia do estudante".equals(parametro.getCategoria())){
                MoradiaEstudanteRN rn = new MoradiaEstudanteRN();

                if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
                    MoradiaEstudante aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
                    aux.setPontuacao(parametro.getPontuacao());
                    rn.salvar(aux);
                    System.out.println("\tSalvou");
                }
            }
            if(parametro.getCategoria().equals(parametros.get(i).getCategoria()) && "Moradia da família".equals(parametro.getCategoria())){
                MoradiaFamiliaRN rn = new MoradiaFamiliaRN();

                if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
                    MoradiaFamilia aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
                    aux.setPontuacao(parametro.getPontuacao());
                    rn.salvar(aux);
                    System.out.println("\tSalvou");
                }
            }
            if(parametro.getCategoria().equals(parametros.get(i).getCategoria()) && "Local de residência da família".equals(parametro.getCategoria())){
                LocalResidenciaFamiliaRN rn = new LocalResidenciaFamiliaRN();

                if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
                    LocalResidenciaFamilia aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
                    aux.setPontuacao(parametro.getPontuacao());
                    rn.salvar(aux);
                    System.out.println("\tSalvou");
                }
            }
            if(parametro.getCategoria().equals(parametros.get(i).getCategoria()) && "Situação ocupacional do estudante".equals(parametro.getCategoria())){
                SituacaoOcupacionalRN rn = new SituacaoOcupacionalRN();

                if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
                    SituacaoOcupacional aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
                    aux.setPontuacao(parametro.getPontuacao());
                    rn.salvar(aux);
                    System.out.println("\tSalvou");
                }
            }
            if(parametro.getCategoria().equals(parametros.get(i).getCategoria()) && "Programas, projetos, serviços e benefícios governamentais".equals(parametro.getCategoria())){
                ProgramaSocialRN rn = new ProgramaSocialRN();

                if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
                    ProgramaSocial aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
                    aux.setPontuacao(parametro.getPontuacao());
                    rn.salvar(aux);
                    System.out.println("\tSalvou");
                }
            }
            if(parametro.getCategoria().equals(parametros.get(i).getCategoria()) && "Saúde".equals(parametro.getCategoria())){
                SaudeRN rn = new SaudeRN();

                if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
                    Saude aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
                    aux.setPontuacao(parametro.getPontuacao());
                    rn.salvar(aux);
                    System.out.println("\tSalvou");
                }
            }
            if(parametro.getCategoria().equals(parametros.get(i).getCategoria()) && "Escola de origem".equals(parametro.getCategoria())){
                EscolaOrigemRN rn = new EscolaOrigemRN();

                if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
                    EscolaOrigem aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
                    aux.setPontuacao(parametro.getPontuacao());
                    rn.salvar(aux);
                    System.out.println("\tSalvou");
                }
            }
            
        }
    }
    
    
    public List<Parametro> criarLista() {
        List<Parametro> ListParametros = new ArrayList<>();
        List<ComposicaoFamiliar> composicaoFamiliars;
        List<CondicaoEconomicaEstudante> condicaoEconomicaEstudantes;
        List<DespesaAnalise> despesaAnalises;
        List<EscolaOrigem> escolaOrigems;
        List<Etnia> etnias;
        List<Genero> generos;
        List<LocalResidenciaFamilia> localResidenciaFamilias;
        List<MoradiaEstudante> moradiaEstudantes;
        List<MoradiaFamilia> moradiaFamilias;
        List<ProgramaSocial> programaSocials;
        List<RendaPrincipalOrigem> rendaPrincipalOrigems;
        List<RendaPerCapita> rendaPerCapitas;    
        List<Saude> saudes;
        List<SituacaoOcupacional> situacaoOcupacionals;
        
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
        
        composicaoFamiliars = composicaoFamiliarRN.listar();
        condicaoEconomicaEstudantes = condicaoEconomicaEstudanteRN.listar();
        despesaAnalises = despesaAnaliseRN.listar();
        escolaOrigems = escolaOrigemRN.listar();
        etnias = etniaRN.listar();
        generos = generoRN.listar();
        localResidenciaFamilias = localResidenciaFamiliaRN.listar();
        moradiaEstudantes = moradiaEstudanteRN.listar();
        moradiaFamilias = moradiaFamiliaRN.listar();
        programaSocials = programaSocialRN.listar();
        rendaPerCapitas = rendaPerCapitaRN.listar();
        rendaPrincipalOrigems = rendaPrincipalOrigemRN.listar();
        saudes = saudeRN.listar();
        situacaoOcupacionals = situacaoOcupacionalRN.listar();
        int i;

// Ver renda per capita - Como é impressa e editada na tela ----------------------------------------------------------
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
