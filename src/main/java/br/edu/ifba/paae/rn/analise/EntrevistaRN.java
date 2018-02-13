package br.edu.ifba.paae.rn.analise;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.analise.EntrevistaDAO;
import br.edu.ifba.paae.entidades.analise.*;
import br.edu.ifba.paae.entidades.formulario.*;
import br.edu.ifba.paae.rn.formulario.*;
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
    public void setPontuacao(Aluno aluno){
       Float pontuacao = 0F; 
       Entrevista entrevista = this.buscarPorAluno(aluno.getAluno());
       
       if(entrevista != null){
            entrevista.setPontuacaoComposicaoFamiliar(calcularPontuacaoComposicaoFamiliar(aluno));
            entrevista.setPontuacaoCondicaoEconomicaEstudante(calcularPontuacaoCondicaoEconomicaEstudante(aluno));
            entrevista.setPontuacaoDespesaAnalise(calcularPontuacaoDespesaAnalise(aluno));
            entrevista.setPontuacaoEscolaOrigem(calcularPontuacaoEscolaOrigem(aluno));
            entrevista.setPontuacaoEtnia(calcularPontuacaoEtnia(aluno));
            entrevista.setPontuacaoGenero(calcularPontuacaoGenero(aluno));
            entrevista.setPontuacaoLocalResidenciaFamilia(calcularPontuacaoLocalResidenciaFamilia(aluno));
            entrevista.setPontuacaoMoradiaEstudante(calcularPontuacaoMoradiaEstudante(aluno));
            entrevista.setPontuacaoMoradiaFamilia(calcularPontuacaoMoradiaFamilia(aluno));
            entrevista.setPontuacaoProgramaSocial(calcularPontuacaoProgramaSocial(aluno));
            entrevista.setPontuacaoRendaPerCapita(calcularPontuacaoRendaPerCapita(aluno));
            entrevista.setPontuacaoRendaPrincipalOrigem(calcularPontuacaoRendaPrincipalOrigem(aluno));
            entrevista.setPontuacaoSaude(calcularPontuacaoSaude(aluno));
            entrevista.setPontuacaoSituacaoOcupacional(calcularPontuacaoSituacaoOcupacional(aluno));
      
            salvar(entrevista);
           
       }
     
    }
    public Float getPontuacao(Aluno aluno){
       Float pontuacao = 0F; 
       Entrevista entrevista = buscarPorAluno(aluno.getAluno());
       
       if(entrevista != null){
            pontuacao += entrevista.getPontuacaoComposicaoFamiliar();
            pontuacao += entrevista.getPontuacaoCondicaoEconomicaEstudante();
            pontuacao += entrevista.getPontuacaoDespesaAnalise();
            pontuacao += entrevista.getPontuacaoEscolaOrigem();
            pontuacao += entrevista.getPontuacaoEtnia();
            pontuacao += entrevista.getPontuacaoGenero();
            pontuacao += entrevista.getPontuacaoLocalResidenciaFamilia();
            pontuacao += entrevista.getPontuacaoMoradiaEstudante();
            pontuacao += entrevista.getPontuacaoMoradiaFamilia();
            pontuacao += entrevista.getPontuacaoProgramaSocial();
            pontuacao += entrevista.getPontuacaoRendaPerCapita();
            pontuacao += entrevista.getPontuacaoRendaPrincipalOrigem();
            pontuacao += entrevista.getPontuacaoSaude();
            pontuacao += entrevista.getPontuacaoSituacaoOcupacional();
       }
       
       return pontuacao;
    }
    
    private Float calcularPontuacaoComposicaoFamiliar(Aluno aluno){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        List<MembroFamiliar> membroFamiliars = membroFamiliarRN.buscarPorFamilia(aluno.getAluno());
        DoencaRN doencaRN = new DoencaRN();
        FamiliaRN familiaRN = new FamiliaRN();
        Familia familia = familiaRN.buscarPorAluno(aluno.getAluno());
        Doenca doenca = new Doenca();
        
        ComposicaoFamiliarRN composicaoFamiliarRN = new ComposicaoFamiliarRN();
        ComposicaoFamiliar composicaoFamiliar;
        
        Float pontuacao = 0F;
        
        int i, k;
        
        if(membroFamiliars != null && !membroFamiliars.isEmpty()){
            for(i=0; i<membroFamiliars.size(); i++){
                if(membroFamiliars.get(i).getIdade() != null && membroFamiliars.get(i).getIdade() < 18){
                    composicaoFamiliar = composicaoFamiliarRN.buscarPorAspectoEmAvaliacao("Crianças/Adolescentes");
                    pontuacao +=  composicaoFamiliar.getPontuacao();
                }
                if(membroFamiliars.get(i).getIdade() != null && membroFamiliars.get(i).getIdade() >= 18 && membroFamiliars.get(i).getIdade() < 60){
                    composicaoFamiliar = composicaoFamiliarRN.buscarPorAspectoEmAvaliacao("Adulto");
                    pontuacao +=  composicaoFamiliar.getPontuacao();
                }
// Idade do Idoso?                
                if(membroFamiliars.get(i).getIdade() != null && membroFamiliars.get(i).getIdade() >= 60){
                    composicaoFamiliar = composicaoFamiliarRN.buscarPorAspectoEmAvaliacao("Idosos");
                    pontuacao +=  composicaoFamiliar.getPontuacao();
                }
            }
            
        }
        if(familia != null){
            if(familia.getPossuiGestante() != null && familia.getPossuiGestante()){
                composicaoFamiliar = composicaoFamiliarRN.buscarPorAspectoEmAvaliacao("Gestantes");
                pontuacao += composicaoFamiliar.getPontuacao();
            }            
            doenca = doencaRN.buscarPorFamilia(familia.getFamilia());
        }
        if(doenca != null){
            if(doenca.getPossuiDoenca() != null && doenca.getPossuiDoenca()){
                composicaoFamiliar = composicaoFamiliarRN.buscarPorAspectoEmAvaliacao("PDC/Doença incapacitante");
                pontuacao +=  composicaoFamiliar.getPontuacao();                    
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
        DespesaAnalise despesaAnalise;
        
        Float pontuacao = 0F;
        
        if(despesa.getAgua() != null && despesa.getAgua()){
            despesaAnalise = despesaAnaliseRN.buscarPorAspectoEmAvaliacao("Água");
            pontuacao += despesaAnalise.getPontuacao();
        }
        if(despesa.getLuz() != null && despesa.getLuz()){
            despesaAnalise = despesaAnaliseRN.buscarPorAspectoEmAvaliacao("Energia");
            pontuacao += despesaAnalise.getPontuacao();
        }
        if(despesa.getEndividamento() != null && despesa.getEndividamento()){
            despesaAnalise = despesaAnaliseRN.buscarPorAspectoEmAvaliacao("Endividamento (financiamento, consórcio, crédito e/ou 1 empréstimo)");
            pontuacao += despesaAnalise.getPontuacao();
        }
// O plano de saude representa toda a despesa com saúde, não é melhor definir a despesa como apenas saúde?        
        if(despesa.getPlanoSaude() != null && despesa.getPlanoSaude()){
            despesaAnalise = despesaAnaliseRN.buscarPorAspectoEmAvaliacao("Saúde");
            pontuacao += despesaAnalise.getPontuacao();
        }
// Tanto o investimento como as mensalidades computam despesas com educação?
        if((despesa.getInvestimentosEducacao() != null && despesa.getInvestimentosEducacao()) || (despesa.getMensalidadeEscolar() != null && despesa.getMensalidadeEscolar())){
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
        EscolaOrigem escolaOrigem;
        
        Float pontuacao = 0F;
// Algumas possibilidades não são utilizadas e falta uma verificação(olha no barema)   
        if("Pública".equals(informacoesCurriculares.getOndeEstudou())){
            escolaOrigem = escolaOrigemRN.buscarPorAspectoEmAvaliacao("Pública");
            pontuacao += escolaOrigem.getPontuacao();
        }
        if("Escola particular sem bolsa".equals(informacoesCurriculares.getOndeEstudou())){
            escolaOrigem = escolaOrigemRN.buscarPorAspectoEmAvaliacao("Privada sem bolsa de estudo");
            pontuacao += escolaOrigem.getPontuacao();
        }
        
        return pontuacao;
    }
    private Float calcularPontuacaoEtnia(Aluno aluno){
        EtniaRN etniaRN = new EtniaRN();
        Etnia etnia;
        Float pontuacao = 0F;
        
        if("Negro(a)".equals(aluno.getEtnia()) || "Indigena(a)".equals(aluno.getEtnia())){
            etnia = etniaRN.buscarPorAspectoEmAvaliacao("Negro ou Indígena");
            pontuacao += etnia.getPontuacao();
        }        
        if("Pardo(a)".equals(aluno.getEtnia())){
            etnia = etniaRN.buscarPorAspectoEmAvaliacao("Pardo");
            pontuacao += etnia.getPontuacao();
        }
        if("Branco(a)".equals(aluno.getEtnia()) || "Amarelo(a)".equals(aluno.getEtnia()) || "Outro(a)".equals(aluno.getEtnia())){
            etnia = etniaRN.buscarPorAspectoEmAvaliacao("Branco, amarelo ou outra");
            pontuacao += etnia.getPontuacao();
        }
        
        return pontuacao;
    }
    private Float calcularPontuacaoGenero(Aluno aluno){
// Como saber se a mulher é chefe? Se a renda dela for a maior é chefe? Tem que por um atributo sexo no membro familiar     
        Float pontuacao = 0F;
        
        return pontuacao;
    }
    private Float calcularPontuacaoLocalResidenciaFamilia(Aluno aluno){
        ResidenciaFamiliaRN residenciaFamiliaRN = new ResidenciaFamiliaRN();
        ResidenciaFamilia residenciaFamilia = residenciaFamiliaRN.buscarPorFamilia(aluno.getAluno());
        EnderecoRN enderecoRN = new EnderecoRN();
        Endereco endereco = enderecoRN.buscarPorAluno(aluno.getAluno());
        
        LocalResidenciaFamiliaRN localResidenciaFamiliaRN = new LocalResidenciaFamiliaRN();
        LocalResidenciaFamilia localResidenciaFamilia;

        Float pontuacao = 0F;

        if("Irecê".equals(endereco.getCidade()) && "Zona rural".equals(residenciaFamilia.getZona())){
            localResidenciaFamilia = localResidenciaFamiliaRN.buscarPorAspectoEmAvaliacao("Na zona rural do município do campus");
            pontuacao += localResidenciaFamilia.getPontuacao();
        }
        if("Irecê".equals(endereco.getCidade()) && "Zona urbana".equals(residenciaFamilia.getZona())){
            localResidenciaFamilia = localResidenciaFamiliaRN.buscarPorAspectoEmAvaliacao("No município do campus");
            pontuacao += localResidenciaFamilia.getPontuacao();
        }
        if(!"Irecê".equals(endereco.getCidade()) && "Zona urbana".equals(residenciaFamilia.getZona())){
            localResidenciaFamilia = localResidenciaFamiliaRN.buscarPorAspectoEmAvaliacao("Em município diferente do campus");
            pontuacao += localResidenciaFamilia.getPontuacao();
        }
        if(!"Irecê".equals(endereco.getCidade()) && "Zona rural".equals(residenciaFamilia.getZona())){
            localResidenciaFamilia = localResidenciaFamiliaRN.buscarPorAspectoEmAvaliacao("Na zona rural de município diferente do campus");
            pontuacao += localResidenciaFamilia.getPontuacao();
        }
        
        return pontuacao;
    }
    
    private Float calcularPontuacaoMoradiaEstudante(Aluno aluno){
        SituacaoResidencialRN situacaoResidencialRN = new SituacaoResidencialRN();
        SituacaoResidencial situacaoResidencial = situacaoResidencialRN.buscarPorAluno(aluno.getAluno());
        
        MoradiaEstudanteRN moradiaEstudanteRN = new MoradiaEstudanteRN();
        MoradiaEstudante moradiaEstudante;
        
        Float pontuacao = 0F;
        
        if("Casa alugada".equals(situacaoResidencial.getSituacaoCasa())){
            moradiaEstudante = moradiaEstudanteRN.buscarPorAspectoEmAvaliacao("Alugado");
            pontuacao += moradiaEstudante.getPontuacao();
        }
        if("Casa cedida".equals(situacaoResidencial.getSituacaoCasa())){
            moradiaEstudante = moradiaEstudanteRN.buscarPorAspectoEmAvaliacao("Cedido");
            pontuacao += moradiaEstudante.getPontuacao();
        }
        if("Casa própria".equals(situacaoResidencial.getSituacaoCasa())){
            moradiaEstudante = moradiaEstudanteRN.buscarPorAspectoEmAvaliacao("Próprio");
            pontuacao += moradiaEstudante.getPontuacao();
        }
        if("Casa financiada".equals(situacaoResidencial.getSituacaoCasa())){
            moradiaEstudante = moradiaEstudanteRN.buscarPorAspectoEmAvaliacao("	Financiado");
            pontuacao += moradiaEstudante.getPontuacao();
        }
        
        return pontuacao;
    }
    private Float calcularPontuacaoMoradiaFamilia(Aluno aluno){
        ResidenciaFamiliaRN residenciaFamiliaRN = new ResidenciaFamiliaRN();
        ResidenciaFamilia residenciaFamilia = residenciaFamiliaRN.buscarPorFamilia(aluno.getAluno());
        
        MoradiaFamiliaRN moradiaFamiliaRN = new MoradiaFamiliaRN();
        MoradiaFamilia moradiaFamilia;
        
        Float pontuacao = 0F;

        if("Casa alugada".equals(residenciaFamilia.getSituacaoCasa())){
            moradiaFamilia = moradiaFamiliaRN.buscarPorAspectoEmAvaliacao("Alugado");
            pontuacao += moradiaFamilia.getPontuacao();
        }
        if("Casa cedida".equals(residenciaFamilia.getSituacaoCasa())){
            moradiaFamilia = moradiaFamiliaRN.buscarPorAspectoEmAvaliacao("Cedido");
            pontuacao += moradiaFamilia.getPontuacao();
        }
        if("Casa própria".equals(residenciaFamilia.getSituacaoCasa())){
            moradiaFamilia = moradiaFamiliaRN.buscarPorAspectoEmAvaliacao("Próprio");
            pontuacao += moradiaFamilia.getPontuacao();
        }
        if("Casa financiada".equals(residenciaFamilia.getSituacaoCasa())){
            moradiaFamilia = moradiaFamiliaRN.buscarPorAspectoEmAvaliacao("	Financiado");
            pontuacao += moradiaFamilia.getPontuacao();
        }     
        
        return pontuacao;
    }
    private Float calcularPontuacaoProgramaSocial(Aluno aluno){
        FamiliaRN familiaRN = new FamiliaRN();
        Familia familia = familiaRN.buscarPorAluno(aluno.getAluno());
        
        ProgramaSocialRN programaSocialRN = new ProgramaSocialRN();
        ProgramaSocial programaSocial;
        
        Float pontuacao = 0F;
// Não pode ter varios desses?        
        if(familia.getPossuiProgramaSocial() != null && familia.getPossuiProgramaSocial()){
            if("BCP".equals(familia.getProgramaSocial())){
                programaSocial = programaSocialRN.buscarPorAspectoEmAvaliacao("BCP");
                pontuacao += programaSocial.getPontuacao();
            }
            if("Bolsa Família".equals(familia.getProgramaSocial())){
                programaSocial = programaSocialRN.buscarPorAspectoEmAvaliacao("PBF");
                pontuacao += programaSocial.getPontuacao();
            }
            if("Atendimento no CAPS".equals(familia.getProgramaSocial())){
                programaSocial = programaSocialRN.buscarPorAspectoEmAvaliacao("Atendimento no CAPS");
                pontuacao += programaSocial.getPontuacao();
            }
            if("Atendimento no CRAS".equals(familia.getProgramaSocial())){
                programaSocial = programaSocialRN.buscarPorAspectoEmAvaliacao("Atendimento no CRAS");
                pontuacao += programaSocial.getPontuacao();
            }
            if("Fies".equals(familia.getProgramaSocial()) || "Prouni".equals(familia.getProgramaSocial())){
                programaSocial = programaSocialRN.buscarPorAspectoEmAvaliacao("PROUNI/FIES");
                pontuacao += programaSocial.getPontuacao();
            }
            if("Projovem".equals(familia.getProgramaSocial())){
                programaSocial = programaSocialRN.buscarPorAspectoEmAvaliacao("Serviço socioeducativo PROJOVEM");
                pontuacao += programaSocial.getPontuacao();
            }
            if("Jovem Aprendiz".equals(familia.getProgramaSocial())){
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
