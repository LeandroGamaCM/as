package br.edu.ifba.paae.logica;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Leandro
 */
public class ArquivoUtil {
    public static File escrever(String name, byte[] contents) throws IOException {
        File file = new File(diretorioRaizParaArquivos(), name);

        OutputStream out = new FileOutputStream(file);
        out.write(contents);
        out.close();

        return file;
    }
    public static List<File> listarFiles() {
        File dir = diretorioRaizParaArquivos();

        return Arrays.asList(dir.listFiles());
    }
    public File buscarFile(Integer idArquivo) throws IOException{
//        Arquivo arquivo = carregar(idArquivo);
//        
//        if(arquivo != null){
//            File file = escrever(arquivo.getNome(), arquivo.getContents());
//            return file;
//        }    
        return null;
    }
    public void deletarFiles(){
       List<File> files = listarFiles();
        int i;
        
        if(files != null){            
            for(i=0; i<files.size(); i++){
                files.get(i).delete();
            }
        }        
    }

    public static java.io.File diretorioRaizParaArquivos() {
        File dir = new File(diretorioRaiz(), "temp");

        if (!dir.exists()) {
            dir.mkdirs();
        }

        return dir;
    }
    public static File diretorioRaiz() {
         File dir = new File(System.getProperty("user.home"), "Arquivos PAAE");

        if (!dir.exists()) {
            dir.mkdirs();
        }

        return dir;
    }
    
}
