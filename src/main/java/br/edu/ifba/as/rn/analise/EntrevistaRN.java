package br.edu.ifba.as.rn.analise;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.analise.EntrevistaDAO;
import br.edu.ifba.as.entidades.analise.ComposicaoFamiliar;
import br.edu.ifba.as.entidades.analise.CondicaoEconomicaEstudante;
import br.edu.ifba.as.entidades.analise.DespesaAnalise;
import br.edu.ifba.as.entidades.analise.Entrevista;
import br.edu.ifba.as.entidades.analise.EscolaOrigem;
import br.edu.ifba.as.entidades.analise.Etnia;
import br.edu.ifba.as.entidades.analise.LocalResidenciaFamilia;
import br.edu.ifba.as.entidades.analise.MoradiaEstudante;
import br.edu.ifba.as.entidades.analise.MoradiaFamilia;
import br.edu.ifba.as.entidades.analise.ProgramaSocial;
import br.edu.ifba.as.entidades.enums.OndeEstudou;
import br.edu.ifba.as.entidades.enums.SituacaoCasa;
import br.edu.ifba.as.entidades.enums.TipoEtnia;
import br.edu.ifba.as.entidades.enums.Zona;
import br.edu.ifba.as.entidades.formulario.Aluno;
import br.edu.ifba.as.entidades.formulario.Dependentes;
import br.edu.ifba.as.entidades.formulario.Despesa;
import br.edu.ifba.as.entidades.formulario.Doenca;
import br.edu.ifba.as.entidades.formulario.Endereco;
import br.edu.ifba.as.entidades.formulario.Familia;
import br.edu.ifba.as.entidades.formulario.InformacoesCurriculares;
import br.edu.ifba.as.entidades.formulario.MembroFamiliar;
import br.edu.ifba.as.entidades.formulario.ResidenciaFamilia;
import br.edu.ifba.as.entidades.formulario.SituacaoResidencial;
import br.edu.ifba.as.rn.DependentesRN;
import br.edu.ifba.as.rn.DespesaRN;
import br.edu.ifba.as.rn.DoencaRN;
import br.edu.ifba.as.rn.EnderecoRN;
import br.edu.ifba.as.rn.FamiliaRN;
import br.edu.ifba.as.rn.InformacoesCurricularesRN;
import br.edu.ifba.as.rn.MembroFamiliarRN;
import br.edu.ifba.as.rn.ResidenciaFamiliaRN;
import br.edu.ifba.as.rn.SituacaoResidencialRN;
import java.util.List;

public class EntrevistaRN {
    private EntrevistaDAO entrevistaDAO;

    public EntrevistaRN() {
        this.entrevistaDAO = DAOFactory.criarEntrevistaDAO();
    }
    
    public void salvar(Entrevista entrevista){
        this.entrevistaDAO.salvar(entrevista);
    }
    public void excluir(Entrevista entrevista){
        this.entrevistaDAO.excluir(entrevista);
    }
    public Entrevista buscarPorAluno(Integer codAluno){
        return this.entrevistaDAO.buscarPorAluno(codAluno);
    }
    public Entrevista carregar(Integer codigo){
        return this.entrevistaDAO.carregar(codigo);
    }
    public List<Entrevista> listar(){
        return this.entrevistaDAO.listar();
    }
    public Float calcularPontuacao(Aluno aluno){
       Float pontuacao = 0F; 
       
       pontuacao += calcularPontuacaoComposicaoFamiliar(aluno);
       pontuacao += calcularPontuacaoCondicaoEconomicaEstudante(aluno);
       pontuacao += calcularPontuacaoDespesaAnalise(aluno);
       pontuacao += calcularPontuacaoEscolaOrigem(aluno);
       pontuacao += calcularPontuacaoEtnia(aluno);
       pontuacao += calcularPontuacaoGenero(aluno);
       pontuacao += calcularPontuacaoLocalResidenciaFamilia(aluno);
       pontuacao += calcularPontuacaoMoradiaEstudante(aluno);
       pontuacao += calcularPontuacaoMoradiaFamilia(aluno);
       pontuacao += calcularPontuacaoProgramaSocial(aluno);
       pontuacao += calcularPontuacaoRendaPerCapita(aluno);
       pontuacao += calcularPontuacaoRendaPrincipalOrigem(aluno);
       pontuacao += calcularPontuacaoSaude(aluno);
       pontuacao += calcularPontuacaoSituacaoOcupacional(aluno);

       return pontuacao;       
    }
    
    private Float calcularPontuacaoComposicaoFamiliar(Aluno aluno){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        List<MembroFamiliar> membroFamiliars = membroFamiliarRN.buscarPorFamilia(aluno.getAluno());
        DoencaRN doencaRN = new DoencaRN();
        FamiliaRN familiaRN = new FamiliaRN();
        Familia familia = familiaRN.buscarPorAluno(aluno.getAluno());
        
        ComposicaoFamiliarRN composicaoFamiliarRN = new ComposicaoFamiliarRN();
        ComposicaoFamiliar composicaoFamiliar = new ComposicaoFamiliar();
        
        Float pontuacao = 0F;
        
        int i, k;
        
        if(membroFamiliars != null){
            for(i=0; i<membroFamiliars.size(); i++){
                if(membroFamiliars.get(i).getIdade() < 18){
                    composicaoFamiliar = composicaoFamiliarRN.buscarPorAspectoEmAvaliacao("Crianças/Adolescentes");
                    pontuacao +=  composicaoFamiliar.getPontuacao();
                }
                if(membroFamiliars.get(i).getIdade() >= 18 && membroFamiliars.get(i).getIdade() < 60){
                    composicaoFamiliar = composicaoFamiliarRN.buscarPorAspectoEmAvaliacao("Adulto");
                    pontuacao +=  composicaoFamiliar.getPontuacao();
                }
// Idade do Idoso?                
                if(membroFamiliars.get(i).getIdade() >= 60){
                    composicaoFamiliar = composicaoFamiliarRN.buscarPorAspectoEmAvaliacao("Idosos");
                    pontuacao +=  composicaoFamiliar.getPontuacao();
                }
                if(doencaRN.buscarPorMembroFamiliar(membroFamiliars.get(i).getMembroFamiliar()) != null){
                    composicaoFamiliar = composicaoFamiliarRN.buscarPorAspectoEmAvaliacao("PDC/Doença incapacitante");
                    pontuacao +=  composicaoFamiliar.getPontuacao();                    
                }
                if(familia.getPossuiGestante()){
                    composicaoFamiliar = composicaoFamiliarRN.buscarPorAspectoEmAvaliacao("Gestantes");
                    pontuacao += composicaoFamiliar.getPontuacao();
                }
            }
            
        }
        return pontuacao;
    }
    
// Ver com Mirela quando é que o aluno é cada uma dessas coisas(provedor, ...)
    private Float calcularPontuacaoCondicaoEconomicaEstudante(Aluno aluno){
        CondicaoEconomicaEstudanteRN condicaoEconomicaEstudanteRN = new CondicaoEconomicaEstudanteRN();
        CondicaoEconomicaEstudante condicaoEconomicaEstudante = new CondicaoEconomicaEstudante();
        
        Float pontuacao = 0F;
        
        return pontuacao;
    }
    
    private Float calcularPontuacaoDespesaAnalise(Aluno aluno){
        DespesaRN despesaRN = new DespesaRN();
        Despesa despesa = despesaRN.buscarPorFamilia(aluno.getAluno());
        
        DespesaAnaliseRN despesaAnaliseRN = new DespesaAnaliseRN();
        DespesaAnalise despesaAnalise = new DespesaAnalise();
        
        Float pontuacao = 0F;
        
        if(despesa.getAgua()){
            despesaAnalise = despesaAnaliseRN.buscarPorAspectoEmAvaliacao("Água");
            pontuacao += despesaAnalise.getPontuacao();
        }
        if(despesa.getLuz()){
            despesaAnalise = despesaAnaliseRN.buscarPorAspectoEmAvaliacao("Energia");
            pontuacao += despesaAnalise.getPontuacao();
        }
        if(despesa.getEndividamento()){
            despesaAnalise = despesaAnaliseRN.buscarPorAspectoEmAvaliacao("Endividamento (financiamento, consórcio, crédito e/ou 1 empréstimo)");
            pontuacao += despesaAnalise.getPontuacao();
        }
// O plano de saude representa toda a despesa com saúde, não é melhor definir a despesa como apenas saúde?        
        if(despesa.getPlanoSaude()){
            despesaAnalise = despesaAnaliseRN.buscarPorAspectoEmAvaliacao("Saúde");
            pontuacao += despesaAnalise.getPontuacao();
        }
// Tanto o investimento como as mensalidades computam despesas com educação?
        if(despesa.getInvestimentosEducacao() || despesa.getMensalidadeEscolar()){
            despesaAnalise = despesaAnaliseRN.buscarPorAspectoEmAvaliacao("Educação");
            pontuacao += despesaAnalise.getPontuacao();
        }
// Como definir os outros de relevancia?
        
        return pontuacao;
    }

    private Float calcularPontuacaoEscolaOrigem(Aluno aluno){
        InformacoesCurricularesRN informacoesCurricularesRN = new InformacoesCurricularesRN();
        InformacoesCurriculares informacoesCurriculares = informacoesCurricularesRN.buscarPorAluno(aluno.getAluno());
        EscolaOrigemRN escolaOrigemRN = new EscolaOrigemRN();
        EscolaOrigem escolaOrigem = new EscolaOrigem();
        
        Float pontuacao = 0F;
// Algumas possibilidades não são utilizadas e falta uma verificação(olha no barema)   
        if(informacoesCurriculares.getOndeEstudou() == OndeEstudou.Publica){
            escolaOrigem = escolaOrigemRN.buscarPorAspectoEmAvaliacao("Pública");
            pontuacao += escolaOrigem.getPontuacao();
        }
        if(informacoesCurriculares.getOndeEstudou() == OndeEstudou.ParticularSemBolsa){
            escolaOrigem = escolaOrigemRN.buscarPorAspectoEmAvaliacao("Privada sem bolsa de estudo");
            pontuacao += escolaOrigem.getPontuacao();
        }
        
        return pontuacao;
    }
    private Float calcularPontuacaoEtnia(Aluno aluno){
        EtniaRN etniaRN = new EtniaRN();
        Etnia etnia = new Etnia();
        Float pontuacao = 0F;
        
        if(aluno.getEtnia() == TipoEtnia.Negro || aluno.getEtnia() == TipoEtnia.Indigena){
            etnia = etniaRN.buscarPorAspectoEmAvaliacao("Negro ou Indígena");
            pontuacao += etnia.getPontuacao();
        }        
        if(aluno.getEtnia() == TipoEtnia.Pardo){
            etnia = etniaRN.buscarPorAspectoEmAvaliacao("Pardo");
            pontuacao += etnia.getPontuacao();
        }
        if(aluno.getEtnia() == TipoEtnia.Branco || aluno.getEtnia() == TipoEtnia.Amarelo || aluno.getEtnia() == TipoEtnia.Outro){
            etnia = etniaRN.buscarPorAspectoEmAvaliacao("Branco, amarelo ou outra");
            pontuacao += etnia.getPontuacao();
        }
        
        return pontuacao;
    }
    private Float calcularPontuacaoGenero(Aluno aluno){
// Como saber se a mulher é chefe?        
        Float pontuacao = 0F;
        
        return pontuacao;
    }
    private Float calcularPontuacaoLocalResidenciaFamilia(Aluno aluno){
        ResidenciaFamiliaRN residenciaFamiliaRN = new ResidenciaFamiliaRN();
        ResidenciaFamilia residenciaFamilia = residenciaFamiliaRN.buscarPorFamilia(aluno.getAluno());
        EnderecoRN enderecoRN = new EnderecoRN();
        Endereco endereco = enderecoRN.buscarPorAluno(aluno.getAluno());
        
        LocalResidenciaFamiliaRN localResidenciaFamiliaRN = new LocalResidenciaFamiliaRN();
        LocalResidenciaFamilia localResidenciaFamilia = new LocalResidenciaFamilia();

        Float pontuacao = 0F;

        if("Irecê".equals(endereco.getCidade()) && residenciaFamilia.getZona() == Zona.Rural){
            localResidenciaFamilia = localResidenciaFamiliaRN.buscarPorAspectoEmAvaliacao("Na zona rural do município do campus");
            pontuacao += localResidenciaFamilia.getPontuacao();
        }
        if("Irecê".equals(endereco.getCidade()) && residenciaFamilia.getZona() == Zona.Urbana){
            localResidenciaFamilia = localResidenciaFamiliaRN.buscarPorAspectoEmAvaliacao("No município do campus");
            pontuacao += localResidenciaFamilia.getPontuacao();
        }
        if(!"Irecê".equals(endereco.getCidade()) && residenciaFamilia.getZona() == Zona.Urbana){
            localResidenciaFamilia = localResidenciaFamiliaRN.buscarPorAspectoEmAvaliacao("Em município diferente do campus");
            pontuacao += localResidenciaFamilia.getPontuacao();
        }
        if(!"Irecê".equals(endereco.getCidade()) && residenciaFamilia.getZona() == Zona.Rural){
            localResidenciaFamilia = localResidenciaFamiliaRN.buscarPorAspectoEmAvaliacao("Na zona rural de município diferente do campus");
            pontuacao += localResidenciaFamilia.getPontuacao();
        }
        
        return pontuacao;
    }
    
    private Float calcularPontuacaoMoradiaEstudante(Aluno aluno){
        SituacaoResidencialRN situacaoResidencialRN = new SituacaoResidencialRN();
        SituacaoResidencial situacaoResidencial = situacaoResidencialRN.buscarPorAluno(aluno.getAluno());
        
        MoradiaEstudanteRN moradiaEstudanteRN = new MoradiaEstudanteRN();
        MoradiaEstudante moradiaEstudante = new MoradiaEstudante();
        
        Float pontuacao = 0F;
        
        if(situacaoResidencial.getSituacaoCasa() == SituacaoCasa.Alugada){
            moradiaEstudante = moradiaEstudanteRN.buscarPorAspectoEmAvaliacao("Alugado");
            pontuacao += moradiaEstudante.getPontuacao();
        }
        if(situacaoResidencial.getSituacaoCasa() == SituacaoCasa.Cedida){
            moradiaEstudante = moradiaEstudanteRN.buscarPorAspectoEmAvaliacao("Cedido");
            pontuacao += moradiaEstudante.getPontuacao();
        }
        if(situacaoResidencial.getSituacaoCasa() == SituacaoCasa.Propria){
            moradiaEstudante = moradiaEstudanteRN.buscarPorAspectoEmAvaliacao("Próprio");
            pontuacao += moradiaEstudante.getPontuacao();
        }
        if(situacaoResidencial.getSituacaoCasa() == SituacaoCasa.Financiada){
            moradiaEstudante = moradiaEstudanteRN.buscarPorAspectoEmAvaliacao("	Financiado");
            pontuacao += moradiaEstudante.getPontuacao();
        }
        
        return pontuacao;
    }
    private Float calcularPontuacaoMoradiaFamilia(Aluno aluno){
        ResidenciaFamiliaRN residenciaFamiliaRN = new ResidenciaFamiliaRN();
        ResidenciaFamilia residenciaFamilia = residenciaFamiliaRN.buscarPorFamilia(aluno.getAluno());
        
        MoradiaFamiliaRN moradiaFamiliaRN = new MoradiaFamiliaRN();
        MoradiaFamilia moradiaFamilia = new MoradiaFamilia();
        
        Float pontuacao = 0F;

        if(residenciaFamilia.getSituacaoCasa() == SituacaoCasa.Alugada){
            moradiaFamilia = moradiaFamiliaRN.buscarPorAspectoEmAvaliacao("Alugado");
            pontuacao += moradiaFamilia.getPontuacao();
        }
        if(residenciaFamilia.getSituacaoCasa() == SituacaoCasa.Cedida){
            moradiaFamilia = moradiaFamiliaRN.buscarPorAspectoEmAvaliacao("Cedido");
            pontuacao += moradiaFamilia.getPontuacao();
        }
        if(residenciaFamilia.getSituacaoCasa() == SituacaoCasa.Propria){
            moradiaFamilia = moradiaFamiliaRN.buscarPorAspectoEmAvaliacao("Próprio");
            pontuacao += moradiaFamilia.getPontuacao();
        }
        if(residenciaFamilia.getSituacaoCasa() == SituacaoCasa.Financiada){
            moradiaFamilia = moradiaFamiliaRN.buscarPorAspectoEmAvaliacao("	Financiado");
            pontuacao += moradiaFamilia.getPontuacao();
        }     
        
        return pontuacao;
    }
    private Float calcularPontuacaoProgramaSocial(Aluno aluno){
        FamiliaRN familiaRN = new FamiliaRN();
        Familia familia = familiaRN.buscarPorAluno(aluno.getAluno());
        
        ProgramaSocialRN programaSocialRN = new ProgramaSocialRN();
        ProgramaSocial programaSocial = new ProgramaSocial();
        
        Float pontuacao = 0F;
// Não pode ter varios desses?        
        if(familia.getPossuiProgramaSocial()){
            if(familia.getProgramaSocial() == br.edu.ifba.as.entidades.enums.ProgramaSocial.BCP){
                programaSocial = programaSocialRN.buscarPorAspectoEmAvaliacao("BCP");
                pontuacao += programaSocial.getPontuacao();
            }
            if(familia.getProgramaSocial() == br.edu.ifba.as.entidades.enums.ProgramaSocial.BolsaFamilia){
                programaSocial = programaSocialRN.buscarPorAspectoEmAvaliacao("PBF");
                pontuacao += programaSocial.getPontuacao();
            }
            if(familia.getProgramaSocial() == br.edu.ifba.as.entidades.enums.ProgramaSocial.Caps){
                programaSocial = programaSocialRN.buscarPorAspectoEmAvaliacao("Atendimento no CAPS");
                pontuacao += programaSocial.getPontuacao();
            }
            if(familia.getProgramaSocial() == br.edu.ifba.as.entidades.enums.ProgramaSocial.Cras){
                programaSocial = programaSocialRN.buscarPorAspectoEmAvaliacao("Atendimento no CRAS");
                pontuacao += programaSocial.getPontuacao();
            }
            if(familia.getProgramaSocial() == br.edu.ifba.as.entidades.enums.ProgramaSocial.Fies){
                programaSocial = programaSocialRN.buscarPorAspectoEmAvaliacao("PROUNI/FIES");
                pontuacao += programaSocial.getPontuacao();
            }
            if(familia.getProgramaSocial() == br.edu.ifba.as.entidades.enums.ProgramaSocial.Prouni){
                programaSocial = programaSocialRN.buscarPorAspectoEmAvaliacao("PROUNI/FIES");
                pontuacao += programaSocial.getPontuacao();
            }
            if(familia.getProgramaSocial() == br.edu.ifba.as.entidades.enums.ProgramaSocial.Projovem){
                programaSocial = programaSocialRN.buscarPorAspectoEmAvaliacao("Serviço socioeducativo PROJOVEM");
                pontuacao += programaSocial.getPontuacao();
            }
            if(familia.getProgramaSocial() == br.edu.ifba.as.entidades.enums.ProgramaSocial.JovemAprendiz){
                programaSocial = programaSocialRN.buscarPorAspectoEmAvaliacao("Programa JOVEM APRENDIZ");
                pontuacao += programaSocial.getPontuacao();
            }
        }
        
        return pontuacao;
    }
    
// Ver como vai ficar com os valores diferentes    
    private Float calcularPontuacaoRendaPerCapita(Aluno aluno){
        
        Float pontuacao = 0F;
        
        return pontuacao;
    }
    private Float calcularPontuacaoRendaPrincipalOrigem(Aluno aluno){
        
        Float pontuacao = 0F;
        
        return pontuacao;
    }
// Situação de conflito e/ou violência    
    private Float calcularPontuacaoSaude(Aluno aluno){
        
        Float pontuacao = 0F;
        
        return pontuacao;
    }
// Considera apenas o trabalho ou tem que levar em conta a participacao?    
    private Float calcularPontuacaoSituacaoOcupacional(Aluno aluno){
        
        Float pontuacao = 0F;
        
        return pontuacao;
    }
    
}
