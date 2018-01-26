package br.edu.ifba.paae.bean;


import br.edu.ifba.paae.logica.Barema;
import br.edu.ifba.paae.logica.Parametro;
import br.edu.ifba.paae.rn.analise.RendaPerCapitaRN;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "baremaBean")
@ViewScoped
public class BaremaBean implements Serializable{
    private Barema barema = new Barema();
    private List<Parametro> parametros;
    private Double salario;
    
    private String estadoTela = "telaBarema";
    
    @PostConstruct
    public void init() {
        RendaPerCapitaRN rendaPerCapitaRN = new RendaPerCapitaRN();
        parametros = barema.criarLista();
        salario = rendaPerCapitaRN.buscarSalario();
        System.out.println("\tSalário: " + salario);
    }

    public void editarBarema(Parametro parametro) {
        if(parametro != null) {
            barema.salvar(parametro);
        }

//        System.out.println("\tParametro: \n\tCategoria: " + parametro.getCategoria() + "\n\tAspectoAvaliacao: " + parametro.getAspectoAvaliacao() + "\n\tPontuacao: " + parametro.getPontuacao());
//        
//        int i;
//        for(i = 0; i<parametros.size(); i++){
//            if(parametro.getCategoria().equals(parametros.get(i).getCategoria()) && "Composição Familiar".equals(parametro.getCategoria())){
//                ComposicaoFamiliarRN rn = new ComposicaoFamiliarRN();
//                System.out.println("\tEntrou em Composicao Familar");
//
//                if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
//                    System.out.println("\tEntrou no aspecto avaliação");
//                    ComposicaoFamiliar aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
//                    System.out.println("\tAux: \n\tAspectoAvaliacao: " + aux.getTipo() + "\n\tPontuacao: " + aux.getPontuacao());
//
//                    aux.setPontuacao(parametro.getPontuacao());
//                    rn.salvar(aux);
//                    System.out.println("\nO novo aux: ");
//                    System.out.println("\tAux: \n\tAspectoAvaliacao: " + aux.getTipo() + "\n\tPontuacao: " + aux.getPontuacao());
//                    System.out.println("\n\tParametros.get(i): \n\tAspectoAvaliacao: " + parametros.get(i).getAspectoAvaliacao() + "\n\tPontuacao: " + parametros.get(i).getPontuacao());                    
//                    System.out.println("\tSalvou");
//                    break;
//                }
//            }
////            if(parametro.getCategoria().equals(parametros.get(i).getCategoria()) && "Renda per capita".equals(parametro.getCategoria())){
////                RendaPerCapitaRN rn = new RendaPerCapitaRN();
////
////                if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
////                    RendaPerCapita aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
////                    aux.setPontuacao(parametro.getPontuacao());
////                    rn.salvar(aux);
////                    System.out.println("\tSalvou");
////                }
////            }
//            if(parametro.getCategoria().equals(parametros.get(i).getCategoria()) && "Origem da principal renda do grupo familiar".equals(parametro.getCategoria())){
//                RendaPrincipalOrigemRN rn = new RendaPrincipalOrigemRN();
//
//                if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
//                    RendaPrincipalOrigem aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
//                    aux.setPontuacao(parametro.getPontuacao());
//                    rn.salvar(aux);
//                    System.out.println("\tSalvou");
//                }
//            }
//            if(parametro.getCategoria().equals(parametros.get(i).getCategoria()) && "Despesas mensais do grupo familiar".equals(parametro.getCategoria())){
//                DespesaAnaliseRN rn = new DespesaAnaliseRN();
//
//                if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
//                    DespesaAnalise aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
//                    aux.setPontuacao(parametro.getPontuacao());
//                    rn.salvar(aux);
//                    System.out.println("\tSalvou");
//                }
//            }
//            if(parametro.getCategoria().equals(parametros.get(i).getCategoria()) && "Condição economica do estudante".equals(parametro.getCategoria())){
//                CondicaoEconomicaEstudanteRN rn = new CondicaoEconomicaEstudanteRN();
//
//                if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
//                    CondicaoEconomicaEstudante aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
//                    aux.setPontuacao(parametro.getPontuacao());
//                    rn.salvar(aux);
//                    System.out.println("\tSalvou");
//                }
//            }
//            if(parametro.getCategoria().equals(parametros.get(i).getCategoria()) && "Gênero".equals(parametro.getCategoria())){
//                GeneroRN rn = new GeneroRN();
//
//                if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
//                    Genero aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
//                    aux.setPontuacao(parametro.getPontuacao());
//                    rn.salvar(aux);
//                    System.out.println("\tSalvou");
//                }
//            }
//            if(parametro.getCategoria().equals(parametros.get(i).getCategoria()) && "Etnia".equals(parametro.getCategoria())){
//                EtniaRN rn = new EtniaRN();
//
//                if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
//                    Etnia aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
//                    aux.setPontuacao(parametro.getPontuacao());
//                    rn.salvar(aux);
//                    System.out.println("\tSalvou");
//                }
//            }
//            if(parametro.getCategoria().equals(parametros.get(i).getCategoria()) && "Moradia do estudante".equals(parametro.getCategoria())){
//                MoradiaEstudanteRN rn = new MoradiaEstudanteRN();
//
//                if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
//                    MoradiaEstudante aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
//                    aux.setPontuacao(parametro.getPontuacao());
//                    rn.salvar(aux);
//                    System.out.println("\tSalvou");
//                }
//            }
//            if(parametro.getCategoria().equals(parametros.get(i).getCategoria()) && "Moradia da família".equals(parametro.getCategoria())){
//                MoradiaFamiliaRN rn = new MoradiaFamiliaRN();
//
//                if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
//                    MoradiaFamilia aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
//                    aux.setPontuacao(parametro.getPontuacao());
//                    rn.salvar(aux);
//                    System.out.println("\tSalvou");
//                }
//            }
//            if(parametro.getCategoria().equals(parametros.get(i).getCategoria()) && "Local de residência da família".equals(parametro.getCategoria())){
//                LocalResidenciaFamiliaRN rn = new LocalResidenciaFamiliaRN();
//
//                if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
//                    LocalResidenciaFamilia aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
//                    aux.setPontuacao(parametro.getPontuacao());
//                    rn.salvar(aux);
//                    System.out.println("\tSalvou");
//                }
//            }
//            if(parametro.getCategoria().equals(parametros.get(i).getCategoria()) && "Situação ocupacional do estudante".equals(parametro.getCategoria())){
//                SituacaoOcupacionalRN rn = new SituacaoOcupacionalRN();
//
//                if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
//                    SituacaoOcupacional aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
//                    aux.setPontuacao(parametro.getPontuacao());
//                    rn.salvar(aux);
//                    System.out.println("\tSalvou");
//                }
//            }
//            if(parametro.getCategoria().equals(parametros.get(i).getCategoria()) && "Programas, projetos, serviços e benefícios governamentais".equals(parametro.getCategoria())){
//                ProgramaSocialRN rn = new ProgramaSocialRN();
//
//                if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
//                    ProgramaSocial aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
//                    aux.setPontuacao(parametro.getPontuacao());
//                    rn.salvar(aux);
//                    System.out.println("\tSalvou");
//                }
//            }
//            if(parametro.getCategoria().equals(parametros.get(i).getCategoria()) && "Saúde".equals(parametro.getCategoria())){
//                SaudeRN rn = new SaudeRN();
//
//                if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
//                    Saude aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
//                    aux.setPontuacao(parametro.getPontuacao());
//                    rn.salvar(aux);
//                    System.out.println("\tSalvou");
//                }
//            }
//            if(parametro.getCategoria().equals(parametros.get(i).getCategoria()) && "Escola de origem".equals(parametro.getCategoria())){
//                EscolaOrigemRN rn = new EscolaOrigemRN();
//
//                if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
//                    EscolaOrigem aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
//                    aux.setPontuacao(parametro.getPontuacao());
//                    rn.salvar(aux);
//                    System.out.println("\tSalvou");
//                }
//            }
//            parametros = barema.criarLista();
//            
//        }

    }    
    
    public void editarSalario(){
        RendaPerCapitaRN rendaPerCapitaRN = new RendaPerCapitaRN();
        if(salario != null){
            rendaPerCapitaRN.editarSalario(salario);
        }
    }
    
// Controle de Tela

    public boolean isTelaBarema(){
        return "telaBarema".equals(this.estadoTela);
    }
    public void changeToTelaBarema(){
        this.estadoTela = "telaBarema";
    }
    
    
// Getters e Setters    

    public Barema getBarema() {
        return barema;
    }

    public void setBarema(Barema barema) {
        this.barema = barema;
    }

    public List<Parametro> getParametros() {
        return parametros;
    }

    public void setParametros(List<Parametro> parametros) {
        this.parametros = parametros;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getEstadoTela() {
        return estadoTela;
    }

    public void setEstadoTela(String estadoTela) {
        this.estadoTela = estadoTela;
    }


    
    
}
