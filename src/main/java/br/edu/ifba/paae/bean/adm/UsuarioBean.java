package br.edu.ifba.paae.bean.adm;

import br.edu.ifba.paae.entidades.usuario.Usuario;
import br.edu.ifba.paae.logica.Mensagem;
import br.edu.ifba.paae.rn.usuario.UsuarioRN;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name = "usuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable{
    private static final long serialVersionUID = -954377611513886864L;

    private Mensagem mensagem = new Mensagem();
    private Usuario usuario;
    private Usuario usuarioADM = new Usuario();
    
    private String confirmacaoSenha;
    private String novaSenha;
    
    
    @PostConstruct
    public void init(){
        UsuarioRN usuarioRN = new UsuarioRN();

        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext external = context.getExternalContext();
        String cpf = external.getRemoteUser();
        
        usuario = usuarioRN.buscarPorLogin(cpf);
        
    }
    
    public void salvar(){
        Mensagem mensagem = new Mensagem();
        UsuarioRN usuarioRN = new UsuarioRN();
        String senha = usuarioRN.md5(confirmacaoSenha);
        
        if(usuario != null){
            if(usuario.getSenha().equals(senha)){
                usuario.setSenha(novaSenha);
                usuarioRN.atualizar(usuario);
                
                mensagem.addMensagem("Dados atualizados!", FacesMessage.SEVERITY_INFO);
            }
            else{
                mensagem.addMensagem("Senha antiga incorreta!", FacesMessage.SEVERITY_ERROR);
                System.out.println("\tSenha antiga incorreta!");
            }            
        }else{
            System.out.println("Usuario nulo");
        }
    }
    
    public void cadastrarADM(){
        UsuarioRN usuarioRN = new UsuarioRN();
        
        if(usuarioRN.buscarPorLogin(usuarioADM.getLogin()) == null){
            usuarioADM.getPermissao().add("ROLE_ADMINISTRADOR");
            usuarioADM.setAtivo(Boolean.TRUE);            
            usuarioRN.salvar(usuarioADM);
            
            confirmacaoSenha = "";
            usuarioADM = new Usuario();
            mensagem.addMensagem("Novo usuário administrador salvo!", FacesMessage.SEVERITY_INFO);
        }else{
            mensagem.addMensagem("Já existe um usuário cadastrado com esse CPF!", FacesMessage.SEVERITY_ERROR);
        }
    }
    
// Getters e Setters    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getConfirmacaoSenha() {
        return confirmacaoSenha;
    }

    public void setConfirmacaoSenha(String confirmacaoSenha) {
        this.confirmacaoSenha = confirmacaoSenha;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    public Usuario getUsuarioADM() {
        return usuarioADM;
    }

    public void setUsuarioADM(Usuario usuarioADM) {
        this.usuarioADM = usuarioADM;
    }

}
