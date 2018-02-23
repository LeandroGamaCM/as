package br.edu.ifba.paae.bean.aluno;

import br.edu.ifba.paae.entidades.formulario.Aluno;
import br.edu.ifba.paae.rn.arquivo.ArquivoRN;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "anexosBean")
@ViewScoped
public class AnexosBean implements Serializable{
    private static final long serialVersionUID = 7475879667730605467L;
    
    Aluno aluno = new Aluno();
    
    private List<File> arquivos = new ArrayList<>();
    private StreamedContent streamedContent;
    private UploadedFile uploadedFile;
    
    @PostConstruct
    public void init() {
        arquivos = new ArrayList<>(ArquivoRN.listarFiles());
        aluno.setAluno(9);
        buscarArquivo("docId");
    }
    
    public void upload(FileUploadEvent event) {
        uploadedFile = event.getFile();
        salvarFile(uploadedFile, uploadedFile.getFileName());
    }
    public void salvarFile(UploadedFile uploadedFile, String nome){
        try {
            File file = ArquivoRN.escrever(nome, uploadedFile.getContents());
            
            arquivos.add(file);
            
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage("Upload completo", "O arquivo " + file.getName() + " foi salvo!"));            
        } catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", e.getMessage()));
        }
    }
        
    public void descarregar(File file) throws IOException {
        InputStream inputStream = new FileInputStream(file);
        
        streamedContent = new DefaultStreamedContent(inputStream, 
                Files.probeContentType(file.toPath()), file.getName());
    }
   
    
//    public void atribuirDono(String dono){
//        if(uploadedFile != null){
//            if(dono.equals("aluno")){
//                ArquivoRN arquivoRN = new ArquivoRN();
//                File file = arquivoRN.buscarFile(uploadedFile.getFileName());
//                file.delete();
//
//                salvarFile(uploadedFile, dono);
//            }
//            
//        }
//    }
//    
    public void buscarArquivo(String chave){
        int i;
        for(i=0; i<arquivos.size(); i++){
            if(arquivos.get(i).getName().equals(chave)){
                System.out.println("\tAchou!");
            }
        }
    }

    public StreamedContent getStreamedContent() {
        return streamedContent;
    }
    
    public List<File> getArquivos() {
        return arquivos;
    }
    
    
}
