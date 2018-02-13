package br.edu.ifba.paae.bean;

import br.edu.ifba.paae.logica.ArquivoUtil;
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
    
    private List<File> arquivos = new ArrayList<>();
    private StreamedContent streamedContent;
    
    @PostConstruct
    public void postConstruct() {
        arquivos = new ArrayList<>(ArquivoUtil.listar());
    }
    
    public void upload(FileUploadEvent event) {
        UploadedFile uploadedFile = event.getFile();
        
        try {
            File arquivo = ArquivoUtil.escrever(uploadedFile.getFileName(), uploadedFile.getContents());
            
            arquivos.add(arquivo);
            
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage("Upload completo", "O arquivo " + arquivo.getName() + " foi salvo!"));            
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
    

    public StreamedContent getStreamedContent() {
        return streamedContent;
    }
    
    public List<File> getArquivos() {
        return arquivos;
    }
}
