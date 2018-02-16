package br.edu.ifba.paae.bean.adm;


import br.edu.ifba.paae.entidades.analise.ComposicaoFamiliar;
import br.edu.ifba.paae.entidades.analise.CondicaoEconomicaEstudante;
import br.edu.ifba.paae.entidades.analise.DespesaAnalise;
import br.edu.ifba.paae.entidades.analise.EscolaOrigem;
import br.edu.ifba.paae.entidades.analise.Etnia;
import br.edu.ifba.paae.entidades.analise.Genero;
import br.edu.ifba.paae.entidades.analise.LocalResidenciaFamilia;
import br.edu.ifba.paae.entidades.analise.MoradiaEstudante;
import br.edu.ifba.paae.entidades.analise.MoradiaFamilia;
import br.edu.ifba.paae.entidades.analise.ProgramaSocial;
import br.edu.ifba.paae.entidades.analise.RendaPerCapita;
import br.edu.ifba.paae.entidades.analise.RendaPrincipalOrigem;
import br.edu.ifba.paae.entidades.analise.Saude;
import br.edu.ifba.paae.entidades.analise.SituacaoOcupacional;
import br.edu.ifba.paae.logica.Barema;
import br.edu.ifba.paae.logica.Parametro;
import br.edu.ifba.paae.rn.analise.ComposicaoFamiliarRN;
import br.edu.ifba.paae.rn.analise.CondicaoEconomicaEstudanteRN;
import br.edu.ifba.paae.rn.analise.DespesaAnaliseRN;
import br.edu.ifba.paae.rn.analise.EscolaOrigemRN;
import br.edu.ifba.paae.rn.analise.EtniaRN;
import br.edu.ifba.paae.rn.analise.GeneroRN;
import br.edu.ifba.paae.rn.analise.LocalResidenciaFamiliaRN;
import br.edu.ifba.paae.rn.analise.MoradiaEstudanteRN;
import br.edu.ifba.paae.rn.analise.MoradiaFamiliaRN;
import br.edu.ifba.paae.rn.analise.ProgramaSocialRN;
import br.edu.ifba.paae.rn.analise.RendaPerCapitaRN;
import br.edu.ifba.paae.rn.analise.RendaPrincipalOrigemRN;
import br.edu.ifba.paae.rn.analise.SaudeRN;
import br.edu.ifba.paae.rn.analise.SituacaoOcupacionalRN;
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
    }

    public void editarBarema(Parametro parametro) {
        if(parametro != null) {
//            barema.salvar(parametro);

            System.out.println("\nParametro: \n\tCategoria: " + parametro.getCategoria() + "\n\tAspectoAvaliacao: " + parametro.getAspectoAvaliacao() + "\n\tPontuacao: " + parametro.getPontuacao());

            int i;
            for(i = 0; i<parametros.size(); i++){
                if(parametro.getCategoria().equals(parametros.get(i).getCategoria())){

                    if("Composição Familiar".equals(parametro.getCategoria())){
                        ComposicaoFamiliarRN rn = new ComposicaoFamiliarRN();

                        if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
                            ComposicaoFamiliar aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());

                            aux.setPontuacao(parametro.getPontuacao());
                            rn.salvar(aux);
                            break;
                        }
                    }
                    if("Renda per capita".equals(parametro.getCategoria())){
                        RendaPerCapitaRN rn = new RendaPerCapitaRN();

                        if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
                            RendaPerCapita aux = rn.buscarPorLimite(Double.valueOf(parametro.getAspectoAvaliacao()));
                            aux.setPontuacao(parametro.getPontuacao());
                            rn.salvar(aux);
                            break;
                        }
                    }
                    if("Origem da principal renda do grupo familiar".equals(parametro.getCategoria())){
                        RendaPrincipalOrigemRN rn = new RendaPrincipalOrigemRN();

                        if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
                            RendaPrincipalOrigem aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
                            aux.setPontuacao(parametro.getPontuacao());
                            rn.salvar(aux);
                            break;
                        }
                    }
                    if("Despesas mensais do grupo familiar".equals(parametro.getCategoria())){
                        DespesaAnaliseRN rn = new DespesaAnaliseRN();

                        if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
                            DespesaAnalise aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
                            aux.setPontuacao(parametro.getPontuacao());
                            rn.salvar(aux);
                            break;
                        }
                    }
                    if("Condição economica do estudante".equals(parametro.getCategoria())){
                        CondicaoEconomicaEstudanteRN rn = new CondicaoEconomicaEstudanteRN();

                        if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
                            CondicaoEconomicaEstudante aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
                            aux.setPontuacao(parametro.getPontuacao());
                            rn.salvar(aux);
                            break;
                        }
                    }
                    if("Gênero".equals(parametro.getCategoria())){
                        GeneroRN rn = new GeneroRN();

                        if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
                            Genero aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
                            aux.setPontuacao(parametro.getPontuacao());
                            rn.salvar(aux);
                            break;
                        }
                    }
                    if("Etnia".equals(parametro.getCategoria())){
                        EtniaRN rn = new EtniaRN();

                        if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
                            Etnia aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
                            aux.setPontuacao(parametro.getPontuacao());
                            rn.salvar(aux);
                            break;
                        }
                    }
                    if("Moradia do estudante".equals(parametro.getCategoria())){
                        MoradiaEstudanteRN rn = new MoradiaEstudanteRN();

                        if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
                            MoradiaEstudante aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
                            aux.setPontuacao(parametro.getPontuacao());
                            rn.salvar(aux);
                            break;
                        }
                    }
                    if("Moradia da família".equals(parametro.getCategoria())){
                        MoradiaFamiliaRN rn = new MoradiaFamiliaRN();

                        if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
                            MoradiaFamilia aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
                            aux.setPontuacao(parametro.getPontuacao());
                            rn.salvar(aux);
                            break;
                        }
                    }
                    if("Local de residência da família".equals(parametro.getCategoria())){
                        LocalResidenciaFamiliaRN rn = new LocalResidenciaFamiliaRN();

                        if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
                            LocalResidenciaFamilia aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
                            aux.setPontuacao(parametro.getPontuacao());
                            rn.salvar(aux);
                            break;
                        }
                    }
                    if("Situação ocupacional do estudante".equals(parametro.getCategoria())){
                        SituacaoOcupacionalRN rn = new SituacaoOcupacionalRN();

                        if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
                            SituacaoOcupacional aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
                            aux.setPontuacao(parametro.getPontuacao());
                            rn.salvar(aux);
                            break;
                        }
                    }
                    if("Programas, projetos, serviços e benefícios governamentais".equals(parametro.getCategoria())){
                        ProgramaSocialRN rn = new ProgramaSocialRN();

                        if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
                            ProgramaSocial aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
                            aux.setPontuacao(parametro.getPontuacao());
                            rn.salvar(aux);
                            break;
                        }
                    }
                    if("Saúde".equals(parametro.getCategoria())){
                        SaudeRN rn = new SaudeRN();

                        if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
                            Saude aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
                            aux.setPontuacao(parametro.getPontuacao());
                            rn.salvar(aux);
                            break;
                        }
                    }
                    if("Escola de origem".equals(parametro.getCategoria())){
                        EscolaOrigemRN rn = new EscolaOrigemRN();

                        if(parametros.get(i).getAspectoAvaliacao().equals(parametro.getAspectoAvaliacao())){
                            EscolaOrigem aux = rn.buscarPorAspectoEmAvaliacao(parametro.getAspectoAvaliacao());
                            aux.setPontuacao(parametro.getPontuacao());
                            rn.salvar(aux);
                            break;
                        }
                    }
                }
            }
        }

    }    
    
    public void editarSalario(){
        RendaPerCapitaRN rendaPerCapitaRN = new RendaPerCapitaRN();
        if(salario != null){
            rendaPerCapitaRN.editarSalario(salario);
            parametros = barema.criarLista();            
            System.out.println("Salario = "+salario);
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
