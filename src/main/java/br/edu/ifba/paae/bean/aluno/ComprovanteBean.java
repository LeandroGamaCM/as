package br.edu.ifba.paae.bean.aluno;

import br.edu.ifba.paae.entidades.arquivo.Arquivo;
import br.edu.ifba.paae.entidades.formulario.MembroFamiliar;
import br.edu.ifba.paae.entidades.usuario.Usuario;
import br.edu.ifba.paae.logica.FormularioAluno;
import br.edu.ifba.paae.rn.arquivo.ArquivoRN;
import br.edu.ifba.paae.rn.formulario.*;
import br.edu.ifba.paae.rn.usuario.UsuarioRN;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "comprovanteBean")
@ViewScoped
public class ComprovanteBean implements Serializable{
    private static final long serialVersionUID = -6068457508452314173L;
    
    private FormularioAluno formularioAluno;
    private int qtdeMembrosFamiliares = 0;
    private UploadedFile arquivoMembroFamilar;
    private MembrosFamiliares membrosFamiliares;
    
    @PostConstruct
    public void init() {
        UsuarioRN usuarioRN = new UsuarioRN();
        AlunoRN alunoRN = new AlunoRN();
        
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext external = context.getExternalContext();
        String cpf = external.getRemoteUser();
        Usuario usuario = usuarioRN.buscarPorLogin(cpf);
        
        if(usuario != null){
            System.out.println("\tNome usuario: " + usuario.getNome());
            if(!usuario.getPermissao().contains("ROLE_ADMINISTRADOR")){
                formularioAluno = new FormularioAluno(alunoRN.buscarPorCPF(cpf));
                if(formularioAluno.getMembroFamiliars() != null || !formularioAluno.getMembroFamiliars().isEmpty()){
                    qtdeMembrosFamiliares = formularioAluno.getMembroFamiliars().size();
                    membrosFamiliares = new MembrosFamiliares(formularioAluno.getMembroFamiliars());
                }
            }else
                System.out.println("\n\tADM!\n");            
        }else{
            System.out.println("\tUsuario nulo");
        }
        
    }
    
// Upload de Arquivos ----------------------------------------------------------
    private void upload(FileUploadEvent event, String nomeArquivo){
        UploadedFile uploadedFile = event.getFile();    
        
        Arquivo arquivo = new Arquivo();
        ArquivoRN arquivoRN = new ArquivoRN();
        
        if(arquivoRN.buscarPorNome(nomeArquivo) != null){
            arquivo = arquivoRN.buscarPorNome(nomeArquivo);
        }
        arquivo.setContents(uploadedFile.getContents());
        arquivo.setNome(nomeArquivo);
        arquivoRN.salvar(arquivo); 
        System.out.println("\tSalvou arquivo " + nomeArquivo);
    }
    
    public void uploadArquivoOcupacao(FileUploadEvent event){
        OcupacaoRN ocupacaoRN = new OcupacaoRN();
        
        String nomeArquivo = "arquivoOcupacao" + formularioAluno.getOcupacao().getOcupacao().toString();
        
        upload(event, nomeArquivo);
        
        formularioAluno.getOcupacao().setArquivoOcupacao(nomeArquivo);
        ocupacaoRN.salvar(formularioAluno.getOcupacao());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoAutomovel(FileUploadEvent event){
        ResidenciaFamiliaRN residenciaFamiliaRN = new ResidenciaFamiliaRN();
        
        String nomeArquivo = "arquivoAutomovel" + formularioAluno.getResidenciaFamilia().getResidenciaFamilia().toString();
        
        upload(event, nomeArquivo);
        
        formularioAluno.getResidenciaFamilia().setArquivoAutomovel(nomeArquivo);
        residenciaFamiliaRN.salvar(formularioAluno.getResidenciaFamilia());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoDespesasExtra(FileUploadEvent event){
        SituacaoResidencialRN situacaoResidencialRN = new SituacaoResidencialRN();
        
        String nomeArquivo = "arquivoDespesasExtra" + formularioAluno.getSituacaoResidencial().getSituacaoResidencial().toString();
        
        upload(event, nomeArquivo);
        
        formularioAluno.getSituacaoResidencial().setArquivoDespesasExtras(nomeArquivo);
        situacaoResidencialRN.salvar(formularioAluno.getSituacaoResidencial());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoImovel(FileUploadEvent event){
        ImovelRN imovelRN = new ImovelRN();
        
        String nomeArquivo = "arquivoImovel" + formularioAluno.getImovel().getImovel().toString();
        
        upload(event, nomeArquivo);
        
        formularioAluno.getImovel().setArquivoImovel(nomeArquivo);
        imovelRN.salvar(formularioAluno.getImovel());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoProgramaSocial(FileUploadEvent event){
        FamiliaRN familiaRN = new FamiliaRN();
        
        String nomeArquivo = "arquivoProgramaSocial" + formularioAluno.getFamilia().getFamilia().toString();
        
        upload(event, nomeArquivo);
        
        formularioAluno.getFamilia().setArquivoProgramaSocial(nomeArquivo);
        familiaRN.salvar(formularioAluno.getFamilia());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoDoenca(FileUploadEvent event){
        DoencaRN doencaRN = new DoencaRN();
        
        String nomeArquivo = "arquivoDoenca" + formularioAluno.getDoenca().getDoenca().toString();
        
        upload(event, nomeArquivo);
        
        formularioAluno.getDoenca().setArquivoDoenca(nomeArquivo);
        doencaRN.salvar(formularioAluno.getDoenca());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoRendaPai(FileUploadEvent event){
        CondicaoManutencaoRN condicaoManutencaoRN = new CondicaoManutencaoRN();
        
        String nomeArquivo = "arquivoRendaPai" + formularioAluno.getCondicaoManutencao().getCondicaoManutencao().toString();
        
        upload(event, nomeArquivo);
        
        formularioAluno.getCondicaoManutencao().setArquivoRendaPai(nomeArquivo);
        condicaoManutencaoRN.salvar(formularioAluno.getCondicaoManutencao());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoRendaMae(FileUploadEvent event){
        CondicaoManutencaoRN condicaoManutencaoRN = new CondicaoManutencaoRN();
        
        String nomeArquivo = "arquivoRendaMae" + formularioAluno.getCondicaoManutencao().getCondicaoManutencao().toString();
        
        upload(event, nomeArquivo);
        
        formularioAluno.getCondicaoManutencao().setArquivoRendaMae(nomeArquivo);
        condicaoManutencaoRN.salvar(formularioAluno.getCondicaoManutencao());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoRendaAvos(FileUploadEvent event){
        CondicaoManutencaoRN condicaoManutencaoRN = new CondicaoManutencaoRN();
        
        String nomeArquivo = "arquivoRendaAvos" + formularioAluno.getCondicaoManutencao().getCondicaoManutencao().toString();
        
        upload(event, nomeArquivo);
        
        formularioAluno.getCondicaoManutencao().setArquivoRendaAvos(nomeArquivo);
        condicaoManutencaoRN.salvar(formularioAluno.getCondicaoManutencao());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoRendaParentes(FileUploadEvent event){
        CondicaoManutencaoRN condicaoManutencaoRN = new CondicaoManutencaoRN();
        
        String nomeArquivo = "arquivoRendaParentes" + formularioAluno.getCondicaoManutencao().getCondicaoManutencao().toString();
        
        upload(event, nomeArquivo);
        
        formularioAluno.getCondicaoManutencao().setArquivoRendaParentes(nomeArquivo);
        condicaoManutencaoRN.salvar(formularioAluno.getCondicaoManutencao());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoRendaOutrosMeios(FileUploadEvent event){
        CondicaoManutencaoRN condicaoManutencaoRN = new CondicaoManutencaoRN();
        
        String nomeArquivo = "arquivoRendaOutrosMeios" + formularioAluno.getCondicaoManutencao().getCondicaoManutencao().toString();
        
        upload(event, nomeArquivo);
        
        formularioAluno.getCondicaoManutencao().setArquivoRendaOutrosMeios(nomeArquivo);
        condicaoManutencaoRN.salvar(formularioAluno.getCondicaoManutencao());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoDespesaAgua(FileUploadEvent event){
        DespesaRN despesaRN = new DespesaRN();
        
        String nomeArquivo = "arquivoDespesaAgua" + formularioAluno.getDespesa().getDespesa().toString();
        
        upload(event, nomeArquivo);
        
        formularioAluno.getDespesa().setArquivoDespesaAgua(nomeArquivo);
        despesaRN.salvar(formularioAluno.getDespesa());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoDespesaAluguel(FileUploadEvent event){
        DespesaRN despesaRN = new DespesaRN();
        
        String nomeArquivo = "arquivoDespesaAluguel" + formularioAluno.getDespesa().getDespesa().toString();
        
        upload(event, nomeArquivo);
        
        formularioAluno.getDespesa().setArquivoDespesaAluguel(nomeArquivo);
        despesaRN.salvar(formularioAluno.getDespesa());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoDespesaEndividamento(FileUploadEvent event){
        DespesaRN despesaRN = new DespesaRN();
        
        String nomeArquivo = "arquivoDespesaEndividamento" + formularioAluno.getDespesa().getDespesa().toString();
        
        upload(event, nomeArquivo);
        
        formularioAluno.getDespesa().setArquivoDespesaEndividamento(nomeArquivo);
        despesaRN.salvar(formularioAluno.getDespesa());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoDespesaFinanciamentos(FileUploadEvent event){
        DespesaRN despesaRN = new DespesaRN();
        
        String nomeArquivo = "arquivoDespesaFinanciamentos" + formularioAluno.getDespesa().getDespesa().toString();
        
        upload(event, nomeArquivo);
        
        formularioAluno.getDespesa().setArquivoDespesaFinanciamentos(nomeArquivo);
        despesaRN.salvar(formularioAluno.getDespesa());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoDespesaInternet(FileUploadEvent event){
        DespesaRN despesaRN = new DespesaRN();
        
        String nomeArquivo = "arquivoDespesaInternet" + formularioAluno.getDespesa().getDespesa().toString();
        
        upload(event, nomeArquivo);
        
        formularioAluno.getDespesa().setArquivoDespesaInternet(nomeArquivo);
        despesaRN.salvar(formularioAluno.getDespesa());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoDespesaInvestimentosEducacao(FileUploadEvent event){
        DespesaRN despesaRN = new DespesaRN();
        
        String nomeArquivo = "arquivoDespesaInvestimentosEducacao" + formularioAluno.getDespesa().getDespesa().toString();
        
        upload(event, nomeArquivo);
        
        formularioAluno.getDespesa().setArquivoDespesaInvestimentosEducacao(nomeArquivo);
        despesaRN.salvar(formularioAluno.getDespesa());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoDespesaLuz(FileUploadEvent event){
        DespesaRN despesaRN = new DespesaRN();
        
        String nomeArquivo = "arquivoDespesaLuz" + formularioAluno.getDespesa().getDespesa().toString();
        
        upload(event, nomeArquivo);
        
        formularioAluno.getDespesa().setArquivoDespesaLuz(nomeArquivo);
        despesaRN.salvar(formularioAluno.getDespesa());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoDespesaMedicamentos(FileUploadEvent event){
        DespesaRN despesaRN = new DespesaRN();
        
        String nomeArquivo = "arquivoDespesaMedicamentos" + formularioAluno.getDespesa().getDespesa().toString();
        
        upload(event, nomeArquivo);
        
        formularioAluno.getDespesa().setArquivoDespesaMedicamentos(nomeArquivo);
        despesaRN.salvar(formularioAluno.getDespesa());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoDespesaMensalidadeEscolar(FileUploadEvent event){
        DespesaRN despesaRN = new DespesaRN();
        
        String nomeArquivo = "arquivoDespesaMensalidadeEscolar" + formularioAluno.getDespesa().getDespesa().toString();
        
        upload(event, nomeArquivo);
        
        formularioAluno.getDespesa().setArquivoDespesaMensalidadeEscolar(nomeArquivo);
        despesaRN.salvar(formularioAluno.getDespesa());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoDespesaOutros(FileUploadEvent event){
        DespesaRN despesaRN = new DespesaRN();
        
        String nomeArquivo = "arquivoDespesaOutros" + formularioAluno.getDespesa().getDespesa().toString();
        
        upload(event, nomeArquivo);
        
        formularioAluno.getDespesa().setArquivoDespesaOutros(nomeArquivo);
        despesaRN.salvar(formularioAluno.getDespesa());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoDespesaPlanoSaude(FileUploadEvent event){
        DespesaRN despesaRN = new DespesaRN();
        
        String nomeArquivo = "arquivoDespesaPlanoSaude" + formularioAluno.getDespesa().getDespesa().toString();
        
        upload(event, nomeArquivo);
        
        formularioAluno.getDespesa().setArquivoDespesaPlanoSaude(nomeArquivo);
        despesaRN.salvar(formularioAluno.getDespesa());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoDespesaTelefone(FileUploadEvent event){
        DespesaRN despesaRN = new DespesaRN();
        
        String nomeArquivo = "arquivoDespesaTelefone" + formularioAluno.getDespesa().getDespesa().toString();
        
        upload(event, nomeArquivo);
        
        formularioAluno.getDespesa().setArquivoDespesaTelefone(nomeArquivo);
        despesaRN.salvar(formularioAluno.getDespesa());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoDespesaTransporte(FileUploadEvent event){
        DespesaRN despesaRN = new DespesaRN();
        
        String nomeArquivo = "arquivoDespesaTransporte" + formularioAluno.getDespesa().getDespesa().toString();
        
        upload(event, nomeArquivo);
        
        formularioAluno.getDespesa().setArquivoDespesaTransporte(nomeArquivo);
        despesaRN.salvar(formularioAluno.getDespesa());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar1(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar1().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar1().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar1());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar2(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar2().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar2().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar2());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar3(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar3().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar3().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar3());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar4(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar4().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar4().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar4());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar5(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar5().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar5().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar5());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar6(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar6().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar6().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar6());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar7(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar7().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar7().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar7());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar8(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar8().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar8().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar8());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar9(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar9().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar9().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar9());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar10(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar10().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar10().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar10());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar11(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar11().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar11().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar11());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar12(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar12().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar12().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar12());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar13(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar13().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar13().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar13());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar14(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar14().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar14().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar14());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar15(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar15().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar15().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar15());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar16(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar16().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar16().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar16());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar17(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar17().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar17().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar17());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar18(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar18().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar18().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar18());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar19(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar19().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar19().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar19());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar20(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar20().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar20().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar20());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar21(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar21().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar21().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar21());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar22(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar22().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar22().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar22());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar23(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar23().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar23().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar23());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar24(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar24().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar24().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar24());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar25(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar25().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar25().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar25());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar26(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar26().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar26().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar26());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar27(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar27().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar27().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar27());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar28(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar28().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar28().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar28());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar29(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar29().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar29().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar29());                
        System.out.println("\tSalvou a ligação");
    }
    
    public void uploadArquivoMembroFamiliar30(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();

        String nomeArquivo = "arquivoMembroFamiliar" + membrosFamiliares.getMembroFamiliar30().getMembroFamiliar().toString();

        upload(event, nomeArquivo);
        
        membrosFamiliares.getMembroFamiliar30().setArquivoRenda(nomeArquivo);
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar30());                
        System.out.println("\tSalvou a ligação");
    }
    

// Getters e Setters -----------------------------------------------------------  
    
    public FormularioAluno getFormularioAluno() {
        return formularioAluno;
    }

    public void setFormularioAluno(FormularioAluno formularioAluno) {
        this.formularioAluno = formularioAluno;
    }

    public int getQtdeMembrosFamiliares() {
        return qtdeMembrosFamiliares;
    }

    public void setQtdeMembrosFamiliares(int qtdeMembrosFamiliares) {
        this.qtdeMembrosFamiliares = qtdeMembrosFamiliares;
    }

    public UploadedFile getArquivoMembroFamilar() {
        return arquivoMembroFamilar;
    }

    public void setArquivoMembroFamilar(UploadedFile arquivoMembroFamilar) {
        this.arquivoMembroFamilar = arquivoMembroFamilar;
    }

    public MembrosFamiliares getMembrosFamiliares() {
        return membrosFamiliares;
    }

    public void setMembrosFamiliares(MembrosFamiliares membrosFamiliares) {
        this.membrosFamiliares = membrosFamiliares;
    }
    

}


// Código útil para manipulação de arquivos por parte do adm
//    private StreamedContent streamedContent;
//    public void descarregar(File file) throws IOException {
//        InputStream inputStream = new FileInputStream(file);
//        
//        streamedContent = new DefaultStreamedContent(inputStream, 
//                Files.probeContentType(file.toPath()), file.getName());
//    }

//    public void baixar() throws IOException{
//        ArquivoRN arquivoRN = new ArquivoRN();
//        List<Arquivo> lista = arquivoRN.listar();
//        
//        if(lista != null){
//            if(lista.get(0) != null){
//                File file = ArquivoRN.escrever(lista.get(0).getNome(), lista.get(0).getContents());
//                InputStream inputStream = new FileInputStream(file);
//
//                streamedContent = new DefaultStreamedContent(inputStream, 
//                Files.probeContentType(file.toPath()), file.getName());  
//                
//                System.out.println("\tDownloading file");
//
//            }            
//        }
//    }
//    public void deleteFiles() throws IOException{
//        if(arquivosCriados != null || !arquivosCriados.isEmpty()){
//            int i;
//            for(i=0; i<arquivosCriados.size(); i++){
//                
//            }
//        }
//        File file = ArquivoRN.escrever(arquivo.getNome(), arquivo.getContents());
//        
//        System.out.println("Apagou?" + file.delete());
//        
//    }
//    public StreamedContent getStreamedContent() {
//        return streamedContent;
//    }
