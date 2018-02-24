package br.edu.ifba.paae.bean.aluno;

import br.edu.ifba.paae.entidades.arquivo.Arquivo;
import br.edu.ifba.paae.entidades.formulario.MembroFamiliar;
import br.edu.ifba.paae.entidades.formulario.Ocupacao;
import br.edu.ifba.paae.entidades.inscricao.PeriodoInscricao;
import br.edu.ifba.paae.entidades.usuario.Usuario;
import br.edu.ifba.paae.logica.FormularioAluno;
import br.edu.ifba.paae.rn.arquivo.ArquivoRN;
import br.edu.ifba.paae.rn.formulario.*;
import br.edu.ifba.paae.rn.inscricao.PeriodoInscricaoRN;
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
    
    private PeriodoInscricao periodoInscricao;
    private FormularioAluno formularioAluno;
    private int qtdeMembrosFamiliares = 0;
    private UploadedFile arquivoMembroFamilar;
    private MembrosFamiliares membrosFamiliares;
    
    @PostConstruct
    public void init() {
        UsuarioRN usuarioRN = new UsuarioRN();
        AlunoRN alunoRN = new AlunoRN();
        PeriodoInscricaoRN periodoInscricaoRN = new PeriodoInscricaoRN();
        
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext external = context.getExternalContext();
        String cpf = external.getRemoteUser();
        Usuario usuario = usuarioRN.buscarPorLogin(cpf);
        
        periodoInscricao = periodoInscricaoRN.last();
        
        if(usuario != null){
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
    
    public void finalizarInscricao(){
        AlunoRN alunoRN = new AlunoRN();
        formularioAluno.getAluno().setStatus("Inscrição realizada");
        
        alunoRN.salvar(formularioAluno.getAluno());
    }
    
// Upload de Arquivos ----------------------------------------------------------
    public void uploadArquivoOcupacao(FileUploadEvent event){
        OcupacaoRN ocupacaoRN = new OcupacaoRN();
        UploadedFile uploadedFile = event.getFile();         
        
        formularioAluno.getOcupacao().setArquivoOcupacao(uploadedFile.getContents());
        formularioAluno.getOcupacao().setArquivoOcupacaoNome(uploadedFile.getFileName());
        
        ocupacaoRN.salvar(formularioAluno.getOcupacao());                
    }
    public void removerArquivoOcupacao(){
        OcupacaoRN rn = new OcupacaoRN();        
        formularioAluno.getOcupacao().setArquivoOcupacao(null);
        formularioAluno.getOcupacao().setArquivoOcupacaoNome(null);
        rn.salvar(formularioAluno.getOcupacao());
    }
    
    public void uploadArquivoAutomovel(FileUploadEvent event){
        ResidenciaFamiliaRN residenciaFamiliaRN = new ResidenciaFamiliaRN();
        UploadedFile uploadedFile = event.getFile();         

        formularioAluno.getResidenciaFamilia().setArquivoAutomovel(uploadedFile.getContents());
        formularioAluno.getResidenciaFamilia().setArquivoAutomovelNome(uploadedFile.getFileName());

        residenciaFamiliaRN.salvar(formularioAluno.getResidenciaFamilia());                
    }

    public void removerArquivoAutomovel(){
        ResidenciaFamiliaRN rn = new ResidenciaFamiliaRN();        
        formularioAluno.getResidenciaFamilia().setArquivoAutomovel(null);
        formularioAluno.getResidenciaFamilia().setArquivoAutomovelNome(null);
        rn.salvar(formularioAluno.getResidenciaFamilia());
    }    
    
    public void uploadArquivoDespesasExtra(FileUploadEvent event){
        SituacaoResidencialRN situacaoResidencialRN = new SituacaoResidencialRN();
        UploadedFile uploadedFile = event.getFile();         
        
        formularioAluno.getSituacaoResidencial().setArquivoDespesasExtras(uploadedFile.getContents());
        formularioAluno.getSituacaoResidencial().setArquivoDespesasExtrasNome(uploadedFile.getFileName());

        situacaoResidencialRN.salvar(formularioAluno.getSituacaoResidencial());                
    }
    public void removerArquivoDespesasExtra(){
        SituacaoResidencialRN situacaoResidencialRN = new SituacaoResidencialRN();
        
        formularioAluno.getSituacaoResidencial().setArquivoDespesasExtras(null);
        formularioAluno.getSituacaoResidencial().setArquivoDespesasExtrasNome(null);

        situacaoResidencialRN.salvar(formularioAluno.getSituacaoResidencial());                
    }
    
    public void uploadArquivoImovel(FileUploadEvent event){
        ImovelRN imovelRN = new ImovelRN();
        UploadedFile uploadedFile = event.getFile();        
        
        formularioAluno.getImovel().setArquivoImovel(uploadedFile.getContents());
        formularioAluno.getImovel().setArquivoImovelNome(uploadedFile.getFileName());
        imovelRN.salvar(formularioAluno.getImovel());                
    }
    public void removerArquivoImovel(){
        ImovelRN imovelRN = new ImovelRN();
        
        formularioAluno.getImovel().setArquivoImovel(null);
        formularioAluno.getImovel().setArquivoImovelNome(null);
        imovelRN.salvar(formularioAluno.getImovel());                
    }
    
    public void uploadArquivoProgramaSocial(FileUploadEvent event){
        FamiliaRN familiaRN = new FamiliaRN();
        UploadedFile uploadedFile = event.getFile();
        
        formularioAluno.getFamilia().setArquivoProgramaSocial(uploadedFile.getContents());
        formularioAluno.getFamilia().setArquivoProgramaSocialNome(uploadedFile.getFileName());
        familiaRN.salvar(formularioAluno.getFamilia());                
    }
    public void removerArquivoProgramaSocial(){
        FamiliaRN familiaRN = new FamiliaRN();
        
        formularioAluno.getFamilia().setArquivoProgramaSocial(null);
        formularioAluno.getFamilia().setArquivoProgramaSocialNome(null);
        familiaRN.salvar(formularioAluno.getFamilia());                
    }
    
    public void uploadArquivoDoenca(FileUploadEvent event){
        DoencaRN doencaRN = new DoencaRN();
        UploadedFile uploadedFile = event.getFile();
        
        formularioAluno.getDoenca().setArquivoDoenca(uploadedFile.getContents());
        formularioAluno.getDoenca().setArquivoDoencaNome(uploadedFile.getFileName());
        doencaRN.salvar(formularioAluno.getDoenca());                
    }
    public void removerArquivoDoenca(){
        DoencaRN doencaRN = new DoencaRN();
        
        formularioAluno.getDoenca().setArquivoDoenca(null);
        formularioAluno.getDoenca().setArquivoDoencaNome(null);
        doencaRN.salvar(formularioAluno.getDoenca());                
    }
    
    public void uploadArquivoRendaPai(FileUploadEvent event){
        CondicaoManutencaoRN condicaoManutencaoRN = new CondicaoManutencaoRN();
        UploadedFile uploadedFile = event.getFile();
        
        formularioAluno.getCondicaoManutencao().setArquivoRendaPai(uploadedFile.getContents());
        formularioAluno.getCondicaoManutencao().setArquivoRendaPaiNome(uploadedFile.getFileName());
        
        condicaoManutencaoRN.salvar(formularioAluno.getCondicaoManutencao());                
    }
    public void removerArquivoRendaPai(){
        CondicaoManutencaoRN condicaoManutencaoRN = new CondicaoManutencaoRN();
        
        formularioAluno.getCondicaoManutencao().setArquivoRendaPai(null);
        formularioAluno.getCondicaoManutencao().setArquivoRendaPaiNome(null);
        
        condicaoManutencaoRN.salvar(formularioAluno.getCondicaoManutencao());                
    }
    
    public void uploadArquivoRendaMae(FileUploadEvent event){
        CondicaoManutencaoRN condicaoManutencaoRN = new CondicaoManutencaoRN();
        UploadedFile uploadedFile = event.getFile();
        
        formularioAluno.getCondicaoManutencao().setArquivoRendaMae(uploadedFile.getContents());
        formularioAluno.getCondicaoManutencao().setArquivoRendaMaeNome(uploadedFile.getFileName());
        
        condicaoManutencaoRN.salvar(formularioAluno.getCondicaoManutencao());                
    }
    public void removerArquivoRendaMae(){
        CondicaoManutencaoRN condicaoManutencaoRN = new CondicaoManutencaoRN();
        
        formularioAluno.getCondicaoManutencao().setArquivoRendaMae(null);
        formularioAluno.getCondicaoManutencao().setArquivoRendaMaeNome(null);
        
        condicaoManutencaoRN.salvar(formularioAluno.getCondicaoManutencao());                
    }
    
    public void uploadArquivoRendaAvos(FileUploadEvent event){
        CondicaoManutencaoRN condicaoManutencaoRN = new CondicaoManutencaoRN();
        UploadedFile uploadedFile = event.getFile();
        
        formularioAluno.getCondicaoManutencao().setArquivoRendaAvos(uploadedFile.getContents());
        formularioAluno.getCondicaoManutencao().setArquivoRendaAvosNome(uploadedFile.getFileName());

        condicaoManutencaoRN.salvar(formularioAluno.getCondicaoManutencao());                
    }
    public void removerArquivoRendaAvos(){
        CondicaoManutencaoRN condicaoManutencaoRN = new CondicaoManutencaoRN();
        
        formularioAluno.getCondicaoManutencao().setArquivoRendaAvos(null);
        formularioAluno.getCondicaoManutencao().setArquivoRendaAvosNome(null);

        condicaoManutencaoRN.salvar(formularioAluno.getCondicaoManutencao());                
    }
    
    public void uploadArquivoRendaParentes(FileUploadEvent event){
        CondicaoManutencaoRN condicaoManutencaoRN = new CondicaoManutencaoRN();
        UploadedFile uploadedFile = event.getFile();
        
        formularioAluno.getCondicaoManutencao().setArquivoRendaParentes(uploadedFile.getContents());
        formularioAluno.getCondicaoManutencao().setArquivoRendaParentesNome(uploadedFile.getFileName());

        condicaoManutencaoRN.salvar(formularioAluno.getCondicaoManutencao());                
    }
    public void removerArquivoRendaParentes(){
        CondicaoManutencaoRN condicaoManutencaoRN = new CondicaoManutencaoRN();
        
        formularioAluno.getCondicaoManutencao().setArquivoRendaParentes(null);
        formularioAluno.getCondicaoManutencao().setArquivoRendaParentesNome(null);

        condicaoManutencaoRN.salvar(formularioAluno.getCondicaoManutencao());                
    }
    
    public void uploadArquivoRendaOutrosMeios(FileUploadEvent event){
        CondicaoManutencaoRN condicaoManutencaoRN = new CondicaoManutencaoRN();
        UploadedFile uploadedFile = event.getFile();
        
        formularioAluno.getCondicaoManutencao().setArquivoRendaOutrosMeios(uploadedFile.getContents());
        formularioAluno.getCondicaoManutencao().setArquivoRendaOutrosMeiosNome(uploadedFile.getFileName());

        condicaoManutencaoRN.salvar(formularioAluno.getCondicaoManutencao());                
    }
    public void removerArquivoRendaOutrosMeios(){
        CondicaoManutencaoRN condicaoManutencaoRN = new CondicaoManutencaoRN();
        
        formularioAluno.getCondicaoManutencao().setArquivoRendaOutrosMeios(null);
        formularioAluno.getCondicaoManutencao().setArquivoRendaOutrosMeiosNome(null);

        condicaoManutencaoRN.salvar(formularioAluno.getCondicaoManutencao());                
    }
    
    public void uploadArquivoDespesaAgua(FileUploadEvent event){
        DespesaRN despesaRN = new DespesaRN();
        UploadedFile uploadedFile = event.getFile();
        
        formularioAluno.getDespesa().setArquivoDespesaAgua(uploadedFile.getContents());
        formularioAluno.getDespesa().setArquivoDespesaAguaNome(uploadedFile.getFileName());

        despesaRN.salvar(formularioAluno.getDespesa());                
    }
    public void removerArquivoDespesaAgua(){
        DespesaRN despesaRN = new DespesaRN();
        
        formularioAluno.getDespesa().setArquivoDespesaAgua(null);
        formularioAluno.getDespesa().setArquivoDespesaAguaNome(null);

        despesaRN.salvar(formularioAluno.getDespesa());                
    }
    
    public void uploadArquivoDespesaAluguel(FileUploadEvent event){
        DespesaRN despesaRN = new DespesaRN();
        UploadedFile uploadedFile = event.getFile();
        
        formularioAluno.getDespesa().setArquivoDespesaAluguel(uploadedFile.getContents());
        formularioAluno.getDespesa().setArquivoDespesaAluguelNome(uploadedFile.getFileName());

        despesaRN.salvar(formularioAluno.getDespesa());                
    }
    public void removerArquivoDespesaAluguel(){
        DespesaRN despesaRN = new DespesaRN();
        
        formularioAluno.getDespesa().setArquivoDespesaAluguel(null);
        formularioAluno.getDespesa().setArquivoDespesaAluguelNome(null);

        despesaRN.salvar(formularioAluno.getDespesa());                
    }
    
    public void uploadArquivoDespesaEndividamento(FileUploadEvent event){
        DespesaRN despesaRN = new DespesaRN();
        UploadedFile uploadedFile = event.getFile();
        
        formularioAluno.getDespesa().setArquivoDespesaEndividamento(uploadedFile.getContents());
        formularioAluno.getDespesa().setArquivoDespesaEndividamentoNome(uploadedFile.getFileName());

        despesaRN.salvar(formularioAluno.getDespesa());                
    }
    public void removerArquivoDespesaEndividamento(){
        DespesaRN despesaRN = new DespesaRN();
        
        formularioAluno.getDespesa().setArquivoDespesaEndividamento(null);
        formularioAluno.getDespesa().setArquivoDespesaEndividamentoNome(null);

        despesaRN.salvar(formularioAluno.getDespesa());                
    }
    
    public void uploadArquivoDespesaFinanciamentos(FileUploadEvent event){
        DespesaRN despesaRN = new DespesaRN();
        UploadedFile uploadedFile = event.getFile();
        
        formularioAluno.getDespesa().setArquivoDespesaFinanciamentos(uploadedFile.getContents());
        formularioAluno.getDespesa().setArquivoDespesaFinanciamentosNome(uploadedFile.getFileName());

        despesaRN.salvar(formularioAluno.getDespesa());                
    }
    public void removerArquivoDespesaFinanciamentos(){
        DespesaRN despesaRN = new DespesaRN();
        
        formularioAluno.getDespesa().setArquivoDespesaFinanciamentos(null);
        formularioAluno.getDespesa().setArquivoDespesaFinanciamentosNome(null);

        despesaRN.salvar(formularioAluno.getDespesa());                
    }
    
    public void uploadArquivoDespesaInternet(FileUploadEvent event){
        DespesaRN despesaRN = new DespesaRN();
        UploadedFile uploadedFile = event.getFile();
        
        formularioAluno.getDespesa().setArquivoDespesaInternet(uploadedFile.getContents());
        formularioAluno.getDespesa().setArquivoDespesaInternetNome(uploadedFile.getFileName());

        despesaRN.salvar(formularioAluno.getDespesa());                
    }
    public void removerArquivoDespesaInternet(){
        DespesaRN despesaRN = new DespesaRN();
        
        formularioAluno.getDespesa().setArquivoDespesaInternet(null);
        formularioAluno.getDespesa().setArquivoDespesaInternetNome(null);

        despesaRN.salvar(formularioAluno.getDespesa());                
    }
    
    public void uploadArquivoDespesaInvestimentosEducacao(FileUploadEvent event){
        DespesaRN despesaRN = new DespesaRN();
        UploadedFile uploadedFile = event.getFile();
        
        formularioAluno.getDespesa().setArquivoDespesaInvestimentosEducacao(uploadedFile.getContents());
        formularioAluno.getDespesa().setArquivoDespesaInvestimentosEducacaoNome(uploadedFile.getFileName());

        despesaRN.salvar(formularioAluno.getDespesa());                
    }
    public void removerArquivoDespesaInvestimentosEducacao(){
        DespesaRN despesaRN = new DespesaRN();
        
        formularioAluno.getDespesa().setArquivoDespesaInvestimentosEducacao(null);
        formularioAluno.getDespesa().setArquivoDespesaInvestimentosEducacaoNome(null);

        despesaRN.salvar(formularioAluno.getDespesa());                
    }
    
    public void uploadArquivoDespesaLuz(FileUploadEvent event){
        DespesaRN despesaRN = new DespesaRN();
        UploadedFile uploadedFile = event.getFile();
        
        formularioAluno.getDespesa().setArquivoDespesaLuz(uploadedFile.getContents());
        formularioAluno.getDespesa().setArquivoDespesaLuzNome(uploadedFile.getFileName());

        despesaRN.salvar(formularioAluno.getDespesa());                
    }
    public void removerArquivoDespesaLuz(){
        DespesaRN despesaRN = new DespesaRN();
        
        formularioAluno.getDespesa().setArquivoDespesaLuz(null);
        formularioAluno.getDespesa().setArquivoDespesaLuzNome(null);

        despesaRN.salvar(formularioAluno.getDespesa());                
    }
    
    public void uploadArquivoDespesaMedicamentos(FileUploadEvent event){
        DespesaRN despesaRN = new DespesaRN();
        UploadedFile uploadedFile = event.getFile();
        
        formularioAluno.getDespesa().setArquivoDespesaMedicamentos(uploadedFile.getContents());
        formularioAluno.getDespesa().setArquivoDespesaMedicamentosNome(uploadedFile.getFileName());

        despesaRN.salvar(formularioAluno.getDespesa());                
    }
    public void removerArquivoDespesaMedicamentos(){
        DespesaRN despesaRN = new DespesaRN();
        
        formularioAluno.getDespesa().setArquivoDespesaMedicamentos(null);
        formularioAluno.getDespesa().setArquivoDespesaMedicamentosNome(null);

        despesaRN.salvar(formularioAluno.getDespesa());                
    }
    
    public void uploadArquivoDespesaMensalidadeEscolar(FileUploadEvent event){
        DespesaRN despesaRN = new DespesaRN();
        UploadedFile uploadedFile = event.getFile();
        
        formularioAluno.getDespesa().setArquivoDespesaMensalidadeEscolar(uploadedFile.getContents());
        formularioAluno.getDespesa().setArquivoDespesaMensalidadeEscolarNome(uploadedFile.getFileName());

        despesaRN.salvar(formularioAluno.getDespesa());                
    }
    public void removerArquivoDespesaMensalidadeEscolar(){
        DespesaRN despesaRN = new DespesaRN();
        
        formularioAluno.getDespesa().setArquivoDespesaMensalidadeEscolar(null);
        formularioAluno.getDespesa().setArquivoDespesaMensalidadeEscolarNome(null);

        despesaRN.salvar(formularioAluno.getDespesa());                
    }
    
    public void uploadArquivoDespesaOutros(FileUploadEvent event){
        DespesaRN despesaRN = new DespesaRN();
        UploadedFile uploadedFile = event.getFile();
        
        formularioAluno.getDespesa().setArquivoDespesaOutros(uploadedFile.getContents());
        formularioAluno.getDespesa().setArquivoDespesaOutrosNome(uploadedFile.getFileName());

        despesaRN.salvar(formularioAluno.getDespesa());                
    }
    public void removerArquivoDespesaOutros(){
        DespesaRN despesaRN = new DespesaRN();
        
        formularioAluno.getDespesa().setArquivoDespesaOutros(null);
        formularioAluno.getDespesa().setArquivoDespesaOutrosNome(null);

        despesaRN.salvar(formularioAluno.getDespesa());                
    }
    
    public void uploadArquivoDespesaPlanoSaude(FileUploadEvent event){
        DespesaRN despesaRN = new DespesaRN();
        UploadedFile uploadedFile = event.getFile();
        
        formularioAluno.getDespesa().setArquivoDespesaPlanoSaude(uploadedFile.getContents());
        formularioAluno.getDespesa().setArquivoDespesaPlanoSaudeNome(uploadedFile.getFileName());

        despesaRN.salvar(formularioAluno.getDespesa());                
    }
    public void removerArquivoDespesaPlanoSaude(){
        DespesaRN despesaRN = new DespesaRN();
        
        formularioAluno.getDespesa().setArquivoDespesaPlanoSaude(null);
        formularioAluno.getDespesa().setArquivoDespesaPlanoSaudeNome(null);

        despesaRN.salvar(formularioAluno.getDespesa());                
    }
    
    public void uploadArquivoDespesaTelefone(FileUploadEvent event){
        DespesaRN despesaRN = new DespesaRN();
        UploadedFile uploadedFile = event.getFile();
        
        formularioAluno.getDespesa().setArquivoDespesaTelefone(uploadedFile.getContents());
        formularioAluno.getDespesa().setArquivoDespesaTelefoneNome(uploadedFile.getFileName());

        despesaRN.salvar(formularioAluno.getDespesa());                
    }
    public void removerArquivoDespesaTelefone(){
        DespesaRN despesaRN = new DespesaRN();
        
        formularioAluno.getDespesa().setArquivoDespesaTelefone(null);
        formularioAluno.getDespesa().setArquivoDespesaTelefoneNome(null);

        despesaRN.salvar(formularioAluno.getDespesa());                
    }
    
    public void uploadArquivoDespesaTransporte(FileUploadEvent event){
        DespesaRN despesaRN = new DespesaRN();
        UploadedFile uploadedFile = event.getFile();
        
        formularioAluno.getDespesa().setArquivoDespesaTransporte(uploadedFile.getContents());
        formularioAluno.getDespesa().setArquivoDespesaTransporteNome(uploadedFile.getFileName());

        despesaRN.salvar(formularioAluno.getDespesa());                
    }
    public void removerArquivoDespesaTransporte(){
        DespesaRN despesaRN = new DespesaRN();
        
        formularioAluno.getDespesa().setArquivoDespesaTransporte(null);
        formularioAluno.getDespesa().setArquivoDespesaTransporteNome(null);

        despesaRN.salvar(formularioAluno.getDespesa());                
    }
    
    public void uploadArquivoMembroFamiliar1(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar1().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar1().setArquivoRendaNome(uploadedFile.getFileName());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar1());                
    }
    public void removerArquivoMembroFamiliar1(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar1().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar1().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar1());                
    }
    
    public void uploadArquivoMembroFamiliar2(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar2().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar2().setArquivoRenda(uploadedFile.getContents());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar2());                
    }
    public void removerArquivoMembroFamiliar2(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar2().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar2().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar2());                
    }
    
    
    public void uploadArquivoMembroFamiliar3(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar3().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar3().setArquivoRendaNome(uploadedFile.getFileName());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar3());                
    }
    public void removerArquivoMembroFamiliar3(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar3().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar3().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar3());                
    }
    
    
    public void uploadArquivoMembroFamiliar4(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar4().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar4().setArquivoRendaNome(uploadedFile.getFileName());
 
        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar4());                
    }
    public void removerArquivoMembroFamiliar4(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar4().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar4().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar4());                
    }
    
    
    public void uploadArquivoMembroFamiliar5(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar5().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar5().setArquivoRendaNome(uploadedFile.getFileName());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar5());                
    }
    public void removerArquivoMembroFamiliar5(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar5().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar5().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar5());                
    }
    
    
    public void uploadArquivoMembroFamiliar6(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar6().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar6().setArquivoRendaNome(uploadedFile.getFileName());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar6());                
    }
    public void removerArquivoMembroFamiliar6(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar6().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar6().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar6());                
    }
    
    
    public void uploadArquivoMembroFamiliar7(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar7().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar7().setArquivoRendaNome(uploadedFile.getFileName());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar7());                
    }
    public void removerArquivoMembroFamiliar7(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar7().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar7().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar7());                
    }
    
    
    public void uploadArquivoMembroFamiliar8(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar8().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar8().setArquivoRendaNome(uploadedFile.getFileName());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar8());                
    }
    public void removerArquivoMembroFamiliar8(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar8().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar8().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar8());                
    }
    
    
    public void uploadArquivoMembroFamiliar9(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar9().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar9().setArquivoRendaNome(uploadedFile.getFileName());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar9());                
    }
    public void removerArquivoMembroFamiliar9(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar9().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar9().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar9());                
    }
    
    
    public void uploadArquivoMembroFamiliar10(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar10().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar10().setArquivoRendaNome(uploadedFile.getFileName());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar10());                
    }
    public void removerArquivoMembroFamiliar10(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar10().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar10().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar10());                
    }
    
    
    public void uploadArquivoMembroFamiliar11(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar11().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar11().setArquivoRendaNome(uploadedFile.getFileName());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar11());                
    }
    public void removerArquivoMembroFamiliar11(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar11().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar11().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar11());                
    }
    
    
    public void uploadArquivoMembroFamiliar12(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar12().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar12().setArquivoRendaNome(uploadedFile.getFileName());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar12());                
    }
    public void removerArquivoMembroFamiliar12(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar12().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar12().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar12());                
    }
    
    
    public void uploadArquivoMembroFamiliar13(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar13().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar13().setArquivoRendaNome(uploadedFile.getFileName());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar13());                
    }
    public void removerArquivoMembroFamiliar13(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar13().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar13().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar13());                
    }
    
    
    public void uploadArquivoMembroFamiliar14(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar14().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar14().setArquivoRendaNome(uploadedFile.getFileName());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar14());                
    }
    public void removerArquivoMembroFamiliar14(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar14().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar14().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar14());                
    }
    
    
    public void uploadArquivoMembroFamiliar15(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar15().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar15().setArquivoRendaNome(uploadedFile.getFileName());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar15());                
    }
    public void removerArquivoMembroFamiliar15(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar15().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar15().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar15());                
    }
    
    
    public void uploadArquivoMembroFamiliar16(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar16().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar16().setArquivoRendaNome(uploadedFile.getFileName());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar16());                
    }
    public void removerArquivoMembroFamiliar16(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar16().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar16().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar16());                
    }
    
    
    public void uploadArquivoMembroFamiliar17(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar17().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar17().setArquivoRendaNome(uploadedFile.getFileName());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar17());                
    }
    public void removerArquivoMembroFamiliar17(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar17().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar17().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar17());                
    }
    
    
    public void uploadArquivoMembroFamiliar18(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar18().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar18().setArquivoRendaNome(uploadedFile.getFileName());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar18());                
    }
    public void removerArquivoMembroFamiliar18(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar18().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar18().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar18());                
    }
    
    
    public void uploadArquivoMembroFamiliar19(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar19().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar19().setArquivoRendaNome(uploadedFile.getFileName());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar19());                
    }
    public void removerArquivoMembroFamiliar19(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar19().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar19().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar19());                
    }
    
    
    public void uploadArquivoMembroFamiliar20(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar20().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar20().setArquivoRendaNome(uploadedFile.getFileName());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar20());                
    }
    public void removerArquivoMembroFamiliar20(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar20().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar20().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar20());                
    }
    
    
    public void uploadArquivoMembroFamiliar21(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar21().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar21().setArquivoRendaNome(uploadedFile.getFileName());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar21());                
    }
    public void removerArquivoMembroFamiliar21(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar21().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar21().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar21());                
    }
    
    
    public void uploadArquivoMembroFamiliar22(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar22().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar22().setArquivoRendaNome(uploadedFile.getFileName());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar22());                
    }
    public void removerArquivoMembroFamiliar22(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar22().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar22().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar22());                
    }
    
    
    public void uploadArquivoMembroFamiliar23(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar23().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar23().setArquivoRendaNome(uploadedFile.getFileName());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar23());                
    }
    public void removerArquivoMembroFamiliar23(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar23().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar23().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar23());                
    }
    
    
    public void uploadArquivoMembroFamiliar24(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar24().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar24().setArquivoRendaNome(uploadedFile.getFileName());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar24());                
    }
    public void removerArquivoMembroFamiliar24(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar24().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar24().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar24());                
    }
    
    
    public void uploadArquivoMembroFamiliar25(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar25().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar25().setArquivoRendaNome(uploadedFile.getFileName());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar25());                
    }
    public void removerArquivoMembroFamiliar25(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar25().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar25().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar25());                
    }
    
    
    public void uploadArquivoMembroFamiliar26(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar26().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar26().setArquivoRendaNome(uploadedFile.getFileName());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar26());                
    }
    public void removerArquivoMembroFamiliar26(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar26().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar26().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar26());                
    }
    
    
    public void uploadArquivoMembroFamiliar27(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar27().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar27().setArquivoRendaNome(uploadedFile.getFileName());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar27());                
    }
    public void removerArquivoMembroFamiliar27(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar27().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar27().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar27());                
    }
    
    
    public void uploadArquivoMembroFamiliar28(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar28().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar28().setArquivoRendaNome(uploadedFile.getFileName());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar28());                
    }
    public void removerArquivoMembroFamiliar28(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar28().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar28().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar28());                
    }
    
    
    public void uploadArquivoMembroFamiliar29(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar29().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar29().setArquivoRendaNome(uploadedFile.getFileName());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar29());                
    }
    public void removerArquivoMembroFamiliar29(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar29().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar29().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar29());                
    }
    
    
    public void uploadArquivoMembroFamiliar30(FileUploadEvent event){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        UploadedFile uploadedFile = event.getFile();
        
        membrosFamiliares.getMembroFamiliar30().setArquivoRenda(uploadedFile.getContents());
        membrosFamiliares.getMembroFamiliar30().setArquivoRendaNome(uploadedFile.getFileName());

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar30());                
    }
    public void removerArquivoMembroFamiliar30(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        
        membrosFamiliares.getMembroFamiliar30().setArquivoRenda(null);
        membrosFamiliares.getMembroFamiliar30().setArquivoRendaNome(null);

        membroFamiliarRN.salvar(membrosFamiliares.getMembroFamiliar30());                
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

    public PeriodoInscricao getPeriodoInscricao() {
        return periodoInscricao;
    }

    public void setPeriodoInscricao(PeriodoInscricao periodoInscricao) {
        this.periodoInscricao = periodoInscricao;
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
