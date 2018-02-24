package br.edu.ifba.paae.rn.analise;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.analise.EntrevistaDAO;
import br.edu.ifba.paae.entidades.analise.*;
import br.edu.ifba.paae.entidades.formulario.*;
import br.edu.ifba.paae.rn.formulario.*;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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
            
            entrevista.setPontuacaoTotal(getPontuacao(aluno));
            
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
    
// -------------------------------------------------------------------------------------------------------------------    
    private Float calcularPontuacaoComposicaoFamiliar(Aluno aluno){
        ComposicaoFamiliarRN composicaoFamiliarRN = new ComposicaoFamiliarRN();
        ComposicaoFamiliar composicaoFamiliar;
        
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        DoencaRN doencaRN = new DoencaRN();
        FamiliaRN familiaRN = new FamiliaRN();

        List<MembroFamiliar> membroFamiliars = membroFamiliarRN.buscarPorFamilia(aluno.getAluno());
        Familia familia = familiaRN.buscarPorAluno(aluno.getAluno());
        Doenca doenca = doencaRN.buscarPorFamilia(aluno.getAluno());
        
        Float pontuacao = 0F;
        
        int i;
        
        if(membroFamiliars != null && !membroFamiliars.isEmpty()){
            for(i=0; i<membroFamiliars.size(); i++){
                if(membroFamiliars.get(i).getIdade() != null){
                    if(membroFamiliars.get(i).getIdade() < 18){
                        composicaoFamiliar = composicaoFamiliarRN.buscarPorAspectoEmAvaliacao("Crianças/Adolescentes");
                        pontuacao +=  composicaoFamiliar.getPontuacao();
                    }
                    if(membroFamiliars.get(i).getIdade() >= 18 && membroFamiliars.get(i).getIdade() < 60){
                        composicaoFamiliar = composicaoFamiliarRN.buscarPorAspectoEmAvaliacao("Adulto");
                        pontuacao +=  composicaoFamiliar.getPontuacao();
                    }              
                    if(membroFamiliars.get(i).getIdade() >= 60){
                        composicaoFamiliar = composicaoFamiliarRN.buscarPorAspectoEmAvaliacao("Idosos");
                        pontuacao +=  composicaoFamiliar.getPontuacao();                    
                    }
                }
            } 
        }
        
        if(familia != null && familia.getPossuiGestante() != null && familia.getPossuiGestante()){
            composicaoFamiliar = composicaoFamiliarRN.buscarPorAspectoEmAvaliacao("Gestantes");
            pontuacao += composicaoFamiliar.getPontuacao();
        }
        if(doenca != null && doenca.getPossuiDoenca() != null && doenca.getPossuiDoenca()){
            composicaoFamiliar = composicaoFamiliarRN.buscarPorAspectoEmAvaliacao("PDC/Doença incapacitante");
            pontuacao +=  composicaoFamiliar.getPontuacao();                    
        }
        
        if(pontuacao > 10) pontuacao = 10F;

        System.out.println("\tPontuacaoComposicaoFamiliar = " + pontuacao);        
        return pontuacao;
    }

// -------------------------------------------------------------------------------------------------------------------        
    private Float calcularPontuacaoCondicaoEconomicaEstudante(Aluno aluno){
        CondicaoEconomicaEstudanteRN condicaoEconomicaEstudanteRN = new CondicaoEconomicaEstudanteRN();
        CondicaoEconomicaEstudante condicaoEconomicaEstudante;
        Float pontuacao = 0F;

        CondicaoManutencaoRN condicaoManutencaoRN = new CondicaoManutencaoRN();
        OcupacaoRN ocupacaoRN = new OcupacaoRN();
        
        CondicaoManutencao condicaoManutencao = condicaoManutencaoRN.buscarPorAluno(aluno.getAluno());
        Ocupacao ocupacao = ocupacaoRN.buscarPorAluno(aluno.getAluno());
        
        if(condicaoManutencao != null){
            if((condicaoManutencao.getAmbosPais() != null && condicaoManutencao.getAmbosPais()) ||
                    (condicaoManutencao.getApenasMae() != null && condicaoManutencao.getApenasMae()) || 
                    (condicaoManutencao.getApenasPai() != null && condicaoManutencao.getApenasPai()) || 
                    (condicaoManutencao.getAvos() != null && condicaoManutencao.getAvos()) || 
                    (condicaoManutencao.getOutrosMeios() != null && condicaoManutencao.getOutrosMeios()) || 
                    (condicaoManutencao.getOutrosParentes() != null && condicaoManutencao.getOutrosParentes()) 
                ){
                if(ocupacao != null && ocupacao.getSituacaoOcupacional() != null && ocupacao.getPossuiEstagio() != null){
                    if(!(ocupacao.getSituacaoOcupacional().equals("Apenas estudando") || ocupacao.getSituacaoOcupacional().equals("Desempregado(a)")) || ocupacao.getPossuiEstagio()){
                        condicaoEconomicaEstudante = condicaoEconomicaEstudanteRN.buscarPorAspectoEmAvaliacao("Colaborador(a)");
                        pontuacao = condicaoEconomicaEstudante.getPontuacao();
                    }else{
                        condicaoEconomicaEstudante = condicaoEconomicaEstudanteRN.buscarPorAspectoEmAvaliacao("Dependente");
                        pontuacao = condicaoEconomicaEstudante.getPontuacao();                                
                    }
                }
            }else{
                condicaoEconomicaEstudante = condicaoEconomicaEstudanteRN.buscarPorAspectoEmAvaliacao("Provedor(a)");
                pontuacao = condicaoEconomicaEstudante.getPontuacao(); 
            }

        }
        
        System.out.println("PontuacaoCondicaoEconomicaEstudante = " + pontuacao);
        return pontuacao;
    }

// -------------------------------------------------------------------------------------------------------------------        
    private Float calcularPontuacaoDespesaAnalise(Aluno aluno){
        DespesaAnaliseRN despesaAnaliseRN = new DespesaAnaliseRN();
        DespesaAnalise despesaAnalise;
        
        DespesaRN despesaRN = new DespesaRN();
        Despesa despesa = despesaRN.buscarPorFamilia(aluno.getAluno());

        Float pontuacao = 0F;
        
        if(despesa != null){
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
            if((despesa.getPlanoSaude() != null && despesa.getPlanoSaude()) || (despesa.getMedicamentos() != null && despesa.getMedicamentos())){
                despesaAnalise = despesaAnaliseRN.buscarPorAspectoEmAvaliacao("Saúde");
                pontuacao += despesaAnalise.getPontuacao();
            }
            if((despesa.getInvestimentosEducacao() != null && despesa.getInvestimentosEducacao()) || (despesa.getMensalidadeEscolar() != null && despesa.getMensalidadeEscolar())){
                despesaAnalise = despesaAnaliseRN.buscarPorAspectoEmAvaliacao("Educação");
                pontuacao += despesaAnalise.getPontuacao();
            }
            if((despesa.getAluguel() != null && despesa.getAluguel()) ||
                    (despesa.getFinanciamentos() != null && despesa.getFinanciamentos()) ||
                    (despesa.getInternet() != null && despesa.getInternet()) ||
                    (despesa.getTelefone() != null && despesa.getTelefone()) ||
                    (despesa.getTransporte() != null && despesa.getTransporte())
                ){
                despesaAnalise = despesaAnaliseRN.buscarPorAspectoEmAvaliacao("Outro(s) de relevância");
                pontuacao += despesaAnalise.getPontuacao();                
            }
            
        }
        
        System.out.println("PontuacaoDespesaAnalise = " + pontuacao);
        return pontuacao;
    }

// -------------------------------------------------------------------------------------------------------------------    
    private Float calcularPontuacaoEscolaOrigem(Aluno aluno){
        EscolaOrigemRN escolaOrigemRN = new EscolaOrigemRN();
        EscolaOrigem escolaOrigem;

        InformacoesCurricularesRN informacoesCurricularesRN = new InformacoesCurricularesRN();
        InformacoesCurriculares informacoesCurriculares = informacoesCurricularesRN.buscarPorAluno(aluno.getAluno());
        
        Float pontuacao = 0F;

        if(informacoesCurriculares != null && informacoesCurriculares.getOndeEstudou() != null){
            if("Escola pública".equals(informacoesCurriculares.getOndeEstudou())){
                escolaOrigem = escolaOrigemRN.buscarPorAspectoEmAvaliacao("Pública");
                pontuacao = escolaOrigem.getPontuacao();
            }
            if("Escola particular sem bolsa".equals(informacoesCurriculares.getOndeEstudou()) || 
                    "Parte em escola pública e parte em escola particular sem bolsa".equals(informacoesCurriculares.getOndeEstudou())
                ){
                escolaOrigem = escolaOrigemRN.buscarPorAspectoEmAvaliacao("Privada sem bolsa de estudo");
                pontuacao = escolaOrigem.getPontuacao();
            }
            if("Escola particular com bolsa".equals(informacoesCurriculares.getOndeEstudou()) || 
                    "Parte em escola pública e parte em escola particular com bolsa".equals(informacoesCurriculares.getOndeEstudou())
                ){
                escolaOrigem = escolaOrigemRN.buscarPorAspectoEmAvaliacao("Privada com bolsa de estudo parcial ou integral");
                pontuacao = escolaOrigem.getPontuacao();
            }            
        }
        
        System.out.println("PontuacaoEscolaOrigem" + pontuacao);        
        return pontuacao;
    }

// -------------------------------------------------------------------------------------------------------------------        
    private Float calcularPontuacaoEtnia(Aluno aluno){
        EtniaRN etniaRN = new EtniaRN();
        Etnia etnia;
        
        Float pontuacao = 0F;
        
        if(aluno != null && aluno.getEtnia() != null){
            if("Negro(a)".equals(aluno.getEtnia()) || "Indigena(a)".equals(aluno.getEtnia())){
                etnia = etniaRN.buscarPorAspectoEmAvaliacao("Negro ou Indígena");
                pontuacao = etnia.getPontuacao();
            }        
            if("Pardo(a)".equals(aluno.getEtnia())){
                etnia = etniaRN.buscarPorAspectoEmAvaliacao("Pardo");
                pontuacao = etnia.getPontuacao();
            }
            if("Branco(a)".equals(aluno.getEtnia()) || "Amarelo(a)".equals(aluno.getEtnia()) || "Outro(a)".equals(aluno.getEtnia())){
                etnia = etniaRN.buscarPorAspectoEmAvaliacao("Branco, amarelo ou outra");
                pontuacao = etnia.getPontuacao();
            }            
        }

        System.out.println("PontuacaoEtnia" + pontuacao);        
        return pontuacao;
    }

// -------------------------------------------------------------------------------------------------------------------    
    private Float calcularPontuacaoGenero(Aluno aluno){
        GeneroRN generoRN = new GeneroRN();
        Genero genero;
        
        Float pontuacao = 0F;
        
        CondicaoManutencaoRN condicaoManutencaoRN = new CondicaoManutencaoRN();
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        DependentesRN dependentesRN = new DependentesRN();
        OcupacaoRN ocupacaoRN = new OcupacaoRN();
        
        int i;
        Ocupacao ocupacao = ocupacaoRN.buscarPorAluno(aluno.getAluno());
        Dependentes dependentes = dependentesRN.buscarPorAluno(aluno.getAluno());
        CondicaoManutencao condicaoManutencao = condicaoManutencaoRN.buscarPorAluno(aluno.getAluno());
        List<MembroFamiliar> membroFamiliars = membroFamiliarRN.buscarPorFamilia(aluno.getAluno());

        if(condicaoManutencao != null){
            if(!((condicaoManutencao.getAmbosPais() != null && condicaoManutencao.getAmbosPais()) ||
                    (condicaoManutencao.getApenasMae() != null && condicaoManutencao.getApenasMae()) || 
                    (condicaoManutencao.getApenasPai() != null && condicaoManutencao.getApenasPai()) || 
                    (condicaoManutencao.getAvos() != null && condicaoManutencao.getAvos()) || 
                    (condicaoManutencao.getOutrosMeios() != null && condicaoManutencao.getOutrosMeios()) || 
                    (condicaoManutencao.getOutrosParentes() != null && condicaoManutencao.getOutrosParentes()) 
                )){
                if((aluno.getSexo() != null && aluno.getSexo().equals("Feminino")) && (dependentes != null && dependentes.getFilho() != null && dependentes.getFilho())){
                    genero = generoRN.buscarPorAspectoEmAvaliacao("Mulher chefe de família, mãe solteira ou viúva");
                    pontuacao = genero.getPontuacao();
                }
            }else{
                if(condicaoManutencao.getApenasMae() != null && condicaoManutencao.getApenasMae()){
                    genero = generoRN.buscarPorAspectoEmAvaliacao("Mulher chefe de família, mãe solteira ou viúva");
                    pontuacao = genero.getPontuacao();
                }else{
                    if(membroFamiliars != null && !membroFamiliars.isEmpty()){
                        MembroFamiliar aux = new MembroFamiliar();
                        aux.setSalario(0.0);
                        int count = 0;
                        for(i=0; i<membroFamiliars.size(); i++){
                            if(membroFamiliars.get(i).getSalario() != null && membroFamiliars.get(i).getSalario() > 0.0){
                                if(membroFamiliars.get(i).getSalario() >= aux.getSalario()){
                                    aux = membroFamiliars.get(i);
                                }
                                count++;
                            }
                        }
                        if(aux.getSexo() != null && aux.getSexo().equals("Feminino") && count == 1){
                            if(!(ocupacao.getSituacaoOcupacional().equals("Apenas estudando") || ocupacao.getSituacaoOcupacional().equals("Desempregado(a)")) || ocupacao.getPossuiEstagio()){
                                genero = generoRN.buscarPorAspectoEmAvaliacao("Mulher chefe de família com companheiro");
                                pontuacao = genero.getPontuacao();                                 
                            }else{
                                genero = generoRN.buscarPorAspectoEmAvaliacao("Mulher chefe de família, mãe solteira ou viúva");
                                pontuacao = genero.getPontuacao();                                                                                        
                            }
                        }
                        if(aux.getSexo() != null && aux.getSexo().equals("Feminino") && count > 1){
                            genero = generoRN.buscarPorAspectoEmAvaliacao("Mulher chefe de família com companheiro");
                            pontuacao = genero.getPontuacao();                            
                        }
                    }
                }
            }
        }

        System.out.println("PontuacaoGenero = " + pontuacao);        
        return pontuacao;
    }

// -------------------------------------------------------------------------------------------------------------------    
    private Float calcularPontuacaoLocalResidenciaFamilia(Aluno aluno){
        LocalResidenciaFamiliaRN localResidenciaFamiliaRN = new LocalResidenciaFamiliaRN();
        LocalResidenciaFamilia localResidenciaFamilia;
        
        ResidenciaFamiliaRN residenciaFamiliaRN = new ResidenciaFamiliaRN();
        EnderecoRN enderecoRN = new EnderecoRN();

        ResidenciaFamilia residenciaFamilia = residenciaFamiliaRN.buscarPorFamilia(aluno.getAluno());
        Endereco endereco = enderecoRN.buscarPorAluno(aluno.getAluno());

        Float pontuacao = 0F;
        
        if(endereco != null && endereco.getCidade() != null && residenciaFamilia != null && residenciaFamilia.getZona() != null){
            if(enderecoRN.comparaCidadeAIrece(endereco) && "Zona rural".equals(residenciaFamilia.getZona())){
                localResidenciaFamilia = localResidenciaFamiliaRN.buscarPorAspectoEmAvaliacao("Na zona rural do município do campus");
                pontuacao = localResidenciaFamilia.getPontuacao();
            }
            if(enderecoRN.comparaCidadeAIrece(endereco) && "Zona urbana".equals(residenciaFamilia.getZona())){
                localResidenciaFamilia = localResidenciaFamiliaRN.buscarPorAspectoEmAvaliacao("No município do campus");
                pontuacao = localResidenciaFamilia.getPontuacao();
            }
            if(!enderecoRN.comparaCidadeAIrece(endereco) && "Zona urbana".equals(residenciaFamilia.getZona())){
                localResidenciaFamilia = localResidenciaFamiliaRN.buscarPorAspectoEmAvaliacao("Em município diferente do campus");
                pontuacao = localResidenciaFamilia.getPontuacao();
            }
            if(!enderecoRN.comparaCidadeAIrece(endereco) && "Zona rural".equals(residenciaFamilia.getZona())){
                localResidenciaFamilia = localResidenciaFamiliaRN.buscarPorAspectoEmAvaliacao("Na zona rural de município diferente do campus");
                pontuacao = localResidenciaFamilia.getPontuacao();
            }            
        }

        System.out.println("PontuacaoLocalResidenciaFamilia" + pontuacao);                
        return pontuacao;
    }

// -------------------------------------------------------------------------------------------------------------------        
    private Float calcularPontuacaoMoradiaEstudante(Aluno aluno){
        MoradiaEstudanteRN moradiaEstudanteRN = new MoradiaEstudanteRN();
        MoradiaEstudante moradiaEstudante;
        
        SituacaoResidencialRN situacaoResidencialRN = new SituacaoResidencialRN();
        SituacaoResidencial situacaoResidencial = situacaoResidencialRN.buscarPorAluno(aluno.getAluno());
        
        Float pontuacao = 0F;
        
        if("Casa alugada".equals(situacaoResidencial.getSituacaoCasa())){
            moradiaEstudante = moradiaEstudanteRN.buscarPorAspectoEmAvaliacao("Alugado");
            pontuacao = moradiaEstudante.getPontuacao();
        }
        if("Casa cedida".equals(situacaoResidencial.getSituacaoCasa())){
            moradiaEstudante = moradiaEstudanteRN.buscarPorAspectoEmAvaliacao("Cedido");
            pontuacao = moradiaEstudante.getPontuacao();
        }
        if("Casa própria".equals(situacaoResidencial.getSituacaoCasa())){
            moradiaEstudante = moradiaEstudanteRN.buscarPorAspectoEmAvaliacao("Próprio");
            pontuacao = moradiaEstudante.getPontuacao();
        }
        if("Casa financiada".equals(situacaoResidencial.getSituacaoCasa())){
            moradiaEstudante = moradiaEstudanteRN.buscarPorAspectoEmAvaliacao("	Financiado");
            pontuacao = moradiaEstudante.getPontuacao();
        }
        
        System.out.println("PontuacaoMoradiaEstudante = " + pontuacao);        
        return pontuacao;
    }

// -------------------------------------------------------------------------------------------------------------------    
    private Float calcularPontuacaoMoradiaFamilia(Aluno aluno){
        ResidenciaFamiliaRN residenciaFamiliaRN = new ResidenciaFamiliaRN();
        ResidenciaFamilia residenciaFamilia = residenciaFamiliaRN.buscarPorFamilia(aluno.getAluno());
        
        Float pontuacao = 0F;
        
        MoradiaFamiliaRN moradiaFamiliaRN = new MoradiaFamiliaRN();
        MoradiaFamilia moradiaFamilia;

        if("Casa alugada".equals(residenciaFamilia.getSituacaoCasa())){
            moradiaFamilia = moradiaFamiliaRN.buscarPorAspectoEmAvaliacao("Alugado");
            pontuacao = moradiaFamilia.getPontuacao();
        }
        if("Casa cedida".equals(residenciaFamilia.getSituacaoCasa())){
            moradiaFamilia = moradiaFamiliaRN.buscarPorAspectoEmAvaliacao("Cedido");
            pontuacao = moradiaFamilia.getPontuacao();
        }
        if("Casa própria".equals(residenciaFamilia.getSituacaoCasa())){
            moradiaFamilia = moradiaFamiliaRN.buscarPorAspectoEmAvaliacao("Próprio");
            pontuacao = moradiaFamilia.getPontuacao();
        }
        if("Casa financiada".equals(residenciaFamilia.getSituacaoCasa())){
            moradiaFamilia = moradiaFamiliaRN.buscarPorAspectoEmAvaliacao("	Financiado");
            pontuacao = moradiaFamilia.getPontuacao();
        }     
        
        System.out.println("PontuacaoMoradiaFamilia = " + pontuacao);        
        return pontuacao;
    }    

// -------------------------------------------------------------------------------------------------------------------    
    private Float calcularPontuacaoProgramaSocial(Aluno aluno){
        ProgramaSocialRN programaSocialRN = new ProgramaSocialRN();
        ProgramaSocial programaSocial;

        Float pontuacao = 0F;
        
        FamiliaRN familiaRN = new FamiliaRN();
        Familia familia = familiaRN.buscarPorAluno(aluno.getAluno());
     
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

        System.out.println("PontuacaoProgramaSocial" + pontuacao);        
        return pontuacao;
    }    

// -------------------------------------------------------------------------------------------------------------------    
    private Float calcularPontuacaoRendaPerCapita(Aluno aluno){
        RendaPerCapitaRN rendaPerCapitaRN = new RendaPerCapitaRN();
        RendaPerCapita rendaPerCapita;
        
        Float pontuacao = 0F;
        
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        OcupacaoRN ocupacaoRN = new OcupacaoRN();
        RendaRN rendaRN = new RendaRN();
        
        List<MembroFamiliar> membroFamiliars = membroFamiliarRN.buscarPorFamilia(aluno.getAluno());
        Ocupacao ocupacao = ocupacaoRN.buscarPorAluno(aluno.getAluno());
        Renda renda = rendaRN.buscarPorFamilia(aluno.getAluno());
        
        int i;
        Double rendaTotal = 0.0;
        List<Double> limites = rendaPerCapitaRN.listarLimites();
                
        Collections.sort(limites);
        Double limite = limites.get(0);
        
        if(membroFamiliars != null && !membroFamiliars.isEmpty()){
            for(i=0; i<membroFamiliars.size(); i++){
                if(membroFamiliars.get(i).getSalario() != null){
                    rendaTotal += membroFamiliars.get(i).getSalario();
                }
            }            
        }
        if(ocupacao != null){
            if(ocupacao.getSalarioMensal() != null){
                rendaTotal += ocupacao.getSalarioMensal();
            }
        }
        if(renda != null){
            if(renda.getAjuda() != null && renda.getAjuda() && renda.getValorAjuda() != null){
                rendaTotal += renda.getValorAjuda();
            }
            if(renda.getAluguel()!= null && renda.getAluguel() && renda.getValorAluguel()!= null){
                rendaTotal += renda.getValorAluguel();
            }
            if(renda.getOutros()!= null && renda.getOutros() && renda.getValorOutros()!= null){
                rendaTotal += renda.getValorOutros();
            }
            if(renda.getPensaoAlimenticia()!= null && renda.getPensaoAlimenticia() && renda.getValorPensaoAlimenticia()!= null){
                rendaTotal += renda.getValorPensaoMorte();
            }
            if(renda.getPensaoMorte()!= null && renda.getPensaoMorte() && renda.getValorPensaoMorte()!= null){
                rendaTotal += renda.getValorPensaoMorte();
            }
        }
        System.out.println("-Renda total: " + rendaTotal);
        
        if(membroFamiliars != null)
            rendaTotal = rendaTotal/(membroFamiliars.size()+1);
        System.out.println("-Renda perCapita: " + rendaTotal);
        
        for (int j = limites.size()-1; j >= 0; j--) {
            if(rendaTotal < limites.get(j)){
                limite = limites.get(j);
            }
        }
        
        System.out.println("-Limite: " + limite);
        rendaPerCapita = rendaPerCapitaRN.buscarPorLimite(limite);
        pontuacao = rendaPerCapita.getPontuacao();
        
        System.out.println("PontuacaoRendaPerCapita = " + pontuacao);        
        return pontuacao;
    }

// -------------------------------------------------------------------------------------------------------------------    
    private Float calcularPontuacaoRendaPrincipalOrigem(Aluno aluno){
        RendaPrincipalOrigemRN rendaPrincipalOrigemRN = new RendaPrincipalOrigemRN();
        RendaPrincipalOrigem rendaPrincipalOrigem;
        
        Float pontuacao = 0F;
        
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        OcupacaoRN ocupacaoRN = new OcupacaoRN();
        RendaRN rendaRN = new RendaRN();
        FamiliaRN familiaRN = new FamiliaRN();
        
        List<MembroFamiliar> membroFamiliars = membroFamiliarRN.buscarPorFamilia(aluno.getAluno());
        Ocupacao ocupacao = ocupacaoRN.buscarPorAluno(aluno.getAluno());
        Renda renda = rendaRN.buscarPorFamilia(aluno.getAluno());
        Familia familia = familiaRN.buscarPorAluno(aluno.getAluno());
        
        int i;
        Double rendaSalario = 0.0, rendaAluguel = 0.0, rendas = 0.0;
        String situacaoOcupacional = "";
        String trabalho = "";
        
        if(membroFamiliars != null && !membroFamiliars.isEmpty()){
            for(i=0; i<membroFamiliars.size(); i++){
                if(membroFamiliars.get(i).getSalario() != null && membroFamiliars.get(i).getSalario() > rendaSalario){
                    rendaSalario = membroFamiliars.get(i).getSalario();
                    situacaoOcupacional = membroFamiliars.get(i).getSituacaoOcupacional();
                }
            }            
        }
        if(ocupacao != null && ocupacao.getSalarioMensal() != null && ocupacao.getSituacaoOcupacional()!= null){
            if(ocupacao.getSalarioMensal() > rendaSalario){
                rendaSalario = ocupacao.getSalarioMensal();
                situacaoOcupacional = ocupacao.getSituacaoOcupacional();
                if(ocupacao.getTrabalho() != null)
                    trabalho = ocupacao.getTrabalho();
            }
        }
        if(renda != null){
            if(renda.getAjuda() != null && renda.getAjuda() && renda.getValorAjuda() != null){
                rendas += renda.getValorAjuda();
            }
            if(renda.getAluguel()!= null && renda.getAluguel() && renda.getValorAluguel()!= null){
                rendaAluguel = renda.getValorAluguel();
                rendas += renda.getValorAjuda();
            }
            if(renda.getOutros()!= null && renda.getOutros() && renda.getValorOutros()!= null){
                rendas += renda.getValorOutros();
            }
            if(renda.getPensaoAlimenticia()!= null && renda.getPensaoAlimenticia()&& renda.getValorPensaoAlimenticia()!= null){
                rendas += renda.getValorPensaoAlimenticia();
            }
            if(renda.getPensaoMorte()!= null && renda.getPensaoMorte()&& renda.getValorPensaoMorte()!= null){
                rendas += renda.getValorPensaoMorte();
            }
        }

       
        if(rendas > 0.0 && rendaSalario == 0.0 && rendaAluguel == 0.0){
            System.out.println("\tRenda Ajuda e outros: " + rendas);
            rendaPrincipalOrigem = rendaPrincipalOrigemRN.buscarPorAspectoEmAvaliacao("Apenas ajuda da família e outros");
            pontuacao = rendaPrincipalOrigem.getPontuacao();            
        }
        if(rendaAluguel > 0.0 && rendaSalario == 0.0 && Objects.equals(rendaAluguel, rendas)){
            System.out.println("\tRenda Aluguel: " + rendaAluguel);
            rendaPrincipalOrigem = rendaPrincipalOrigemRN.buscarPorAspectoEmAvaliacao("Renda da locação de imóveis (exclusivamente)");
            pontuacao = rendaPrincipalOrigem.getPontuacao();                        
        }
        if(rendas == 0.0 && rendaSalario == 0.0){
            if(familia != null && familia.getPossuiProgramaSocial() != null && familia.getPossuiProgramaSocial() && familia.getProgramaSocial().equals("Bolsa Família")){
                System.out.println("\tRenda Bolsa Familia");
                rendaPrincipalOrigem = rendaPrincipalOrigemRN.buscarPorAspectoEmAvaliacao("Apenas benefícios assistenciais PBF");
                pontuacao = rendaPrincipalOrigem.getPontuacao();            
            }else{
                System.out.println("\tNão existe nenhuma renda!");
            }            
        }
        if(rendaSalario > 0.0){
            System.out.println("Renda Salario: " + rendaSalario);
            if(situacaoOcupacional != null && !situacaoOcupacional.equals("")){
                if(situacaoOcupacional.equals("Trabalhador(a)")){
                    if(trabalho.equals("Carteira Assinada") || trabalho.equals("Servidor Público")){
                        rendaPrincipalOrigem = rendaPrincipalOrigemRN.buscarPorAspectoEmAvaliacao("Trabalho formal do(s) provedore(s)");
                        pontuacao = rendaPrincipalOrigem.getPontuacao();                        
                    }
                    if(trabalho.equals("Trabalho Informal")){
                        rendaPrincipalOrigem = rendaPrincipalOrigemRN.buscarPorAspectoEmAvaliacao("Trabalho informal do(s) provedor(es)");
                        pontuacao = rendaPrincipalOrigem.getPontuacao();                                                
                    }
                    if(trabalho.equals("Trabalho Rural")){
                        rendaPrincipalOrigem = rendaPrincipalOrigemRN.buscarPorAspectoEmAvaliacao("Trabalhador rural/agricultura familiar");
                        pontuacao = rendaPrincipalOrigem.getPontuacao();                                                
                    }
                    if(trabalho.equals("Autônomo")){
                        rendaPrincipalOrigem = rendaPrincipalOrigemRN.buscarPorAspectoEmAvaliacao("Trabalho autônomo do(s) provedor(es)");
                        pontuacao = rendaPrincipalOrigem.getPontuacao();                                                
                    }
                }
                if(situacaoOcupacional.equals("Trabalhador rural/agricultura familiar")){
                    rendaPrincipalOrigem = rendaPrincipalOrigemRN.buscarPorAspectoEmAvaliacao("Trabalhador rural/agricultura familiar");
                    pontuacao = rendaPrincipalOrigem.getPontuacao();                    
                }
                if(situacaoOcupacional.equals("Trabalhador(a) autônomo")){
                    rendaPrincipalOrigem = rendaPrincipalOrigemRN.buscarPorAspectoEmAvaliacao("Trabalho autônomo do(s) provedor(es)");
                    pontuacao = rendaPrincipalOrigem.getPontuacao();                    
                }
                if(situacaoOcupacional.equals("Trabalhador(a) informal")){
                    rendaPrincipalOrigem = rendaPrincipalOrigemRN.buscarPorAspectoEmAvaliacao("Trabalho informal do(s) provedor(es)");
                    pontuacao = rendaPrincipalOrigem.getPontuacao();                                        
                }
                if(situacaoOcupacional.equals("Trabalhodor(a) formal")){
                    rendaPrincipalOrigem = rendaPrincipalOrigemRN.buscarPorAspectoEmAvaliacao("Trabalho formal do(s) provedore(s)");
                    pontuacao = rendaPrincipalOrigem.getPontuacao();                                        
                }
                if(situacaoOcupacional.equals("Beneficiário do BPC") || situacaoOcupacional.equals("Aposentado(a)/Pensionista")){
                    rendaPrincipalOrigem = rendaPrincipalOrigemRN.buscarPorAspectoEmAvaliacao("Benefício(s) previdenciário(s)");
                    pontuacao = rendaPrincipalOrigem.getPontuacao();                                        
                }
                if(situacaoOcupacional.equals("Estágio remunerado") || situacaoOcupacional.equals("Aviso Prévio/Seguro desemprego")){
                    rendaPrincipalOrigem = rendaPrincipalOrigemRN.buscarPorAspectoEmAvaliacao("Aviso Prévio/Seguro desemprego/Estágio remunerado");
                    pontuacao = rendaPrincipalOrigem.getPontuacao();                                        
                }
            }
        }        

        System.out.println("PontuacaoRendaPrincipalOrigem" + pontuacao);        
        return pontuacao;
    }
   
// -------------------------------------------------------------------------------------------------------------------    
    private Float calcularPontuacaoSaude(Aluno aluno){
        SaudeRN saudeRN = new SaudeRN();
        Saude saude;
        
        Float pontuacao = 0F;
        
        DoencaRN doencaRN = new DoencaRN();
        Doenca doenca = doencaRN.buscarPorFamilia(aluno.getAluno());
        
        if(doenca != null && doenca.getPossuiDoenca() != null && doenca.getPossuiDoenca()){
            saude = saudeRN.buscarPorAspectoEmAvaliacao("Diagnóstico de doença grave");
            pontuacao += saude.getPontuacao();
            
            if(doenca.getTratamento() != null){
                if(doenca.getTratamento().equals("No mesmo município do domicílio")){
                    saude = saudeRN.buscarPorAspectoEmAvaliacao("Tratamento realizado no mesmo município do domicílio");
                    pontuacao += saude.getPontuacao();
                }
                if(doenca.getTratamento().equals("Em município diferente do domicílio")){
                    saude = saudeRN.buscarPorAspectoEmAvaliacao("Tratamento realizado em município diferente do domicílio");
                    pontuacao += saude.getPontuacao();
                }
            }
        }
        
        System.out.println("PontuacaoSaude" + pontuacao);        
        return pontuacao;
    }   
// -------------------------------------------------------------------------------------------------------------------    
    private Float calcularPontuacaoSituacaoOcupacional(Aluno aluno){
        SituacaoOcupacionalRN situacaoOcupacionalRN = new SituacaoOcupacionalRN();
        SituacaoOcupacional situacaoOcupacional;
        
        Float pontuacao = 0F;
        
        OcupacaoRN ocupacaoRN = new OcupacaoRN();
        Ocupacao ocupacao = ocupacaoRN.buscarPorAluno(aluno.getAluno());
        
        if(ocupacao != null && ocupacao.getSituacaoOcupacional() != null){
            if(ocupacao.getSituacaoOcupacional().equals("Trabalhador(a)") && ocupacao.getTrabalho() != null){
                if(ocupacao.getTrabalho().equals("Carteira Assinada") || ocupacao.getTrabalho().equals("Servidor Público")){
                    situacaoOcupacional = situacaoOcupacionalRN.buscarPorAspectoEmAvaliacao("Trabalhador(a) formal");
                    pontuacao = situacaoOcupacional.getPontuacao();
                }
                if(ocupacao.getTrabalho().equals("Trabalho Informal") || ocupacao.getTrabalho().equals("Trabalho Rural")){
                    situacaoOcupacional = situacaoOcupacionalRN.buscarPorAspectoEmAvaliacao("Trabalhador(a) informal");
                    pontuacao = situacaoOcupacional.getPontuacao();                                               
                }
                if(ocupacao.getTrabalho().equals("Autônomo")){
                    situacaoOcupacional = situacaoOcupacionalRN.buscarPorAspectoEmAvaliacao("Autônomo(a)");
                    pontuacao = situacaoOcupacional.getPontuacao();
                }
            }
            if(ocupacao.getSituacaoOcupacional().equals("Apenas estudando")){
                situacaoOcupacional = situacaoOcupacionalRN.buscarPorAspectoEmAvaliacao("Apenas estudando");
                pontuacao = situacaoOcupacional.getPontuacao();
            }            
            if(ocupacao.getSituacaoOcupacional().equals("Desempregado(a)")){
                situacaoOcupacional = situacaoOcupacionalRN.buscarPorAspectoEmAvaliacao("Desempregado(a)");
                pontuacao = situacaoOcupacional.getPontuacao();
            }            
            if(ocupacao.getSituacaoOcupacional().equals("Aviso Prévio/Seguro desemprego")){
                situacaoOcupacional = situacaoOcupacionalRN.buscarPorAspectoEmAvaliacao("Aviso Prévio/Seguro desemprego");
                pontuacao = situacaoOcupacional.getPontuacao();
            }            
            if(ocupacao.getSituacaoOcupacional().equals("Beneficiário do BPC")){
                situacaoOcupacional = situacaoOcupacionalRN.buscarPorAspectoEmAvaliacao("Beneficiário do BPC");
                pontuacao = situacaoOcupacional.getPontuacao();
            }            
            if(ocupacao.getSituacaoOcupacional().equals("Aposentado(a)/Pensionista")){
                situacaoOcupacional = situacaoOcupacionalRN.buscarPorAspectoEmAvaliacao("Aposentado(a)/Pensionista");
                pontuacao = situacaoOcupacional.getPontuacao();
            }  
            if(ocupacao.getPossuiEstagio() != null && ocupacao.getPossuiEstagio()){
                situacaoOcupacional = situacaoOcupacionalRN.buscarPorAspectoEmAvaliacao("Estagiário remunerado");
                pontuacao = situacaoOcupacional.getPontuacao();
            }
        }
        
        System.out.println("PontuacaoSituacaoOcupacional" + pontuacao);        
        return pontuacao;
    }
    
}
