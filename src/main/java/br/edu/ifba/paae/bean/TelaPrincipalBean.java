package br.edu.ifba.paae.bean;

import br.edu.ifba.paae.entidades.inscricao.Inscricao;
import br.edu.ifba.paae.entidades.usuario.Usuario;
import br.edu.ifba.paae.rn.formulario.AlunoRN;
import br.edu.ifba.paae.rn.inscricao.InscricaoRN;
import br.edu.ifba.paae.rn.usuario.UsuarioRN;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name = "telaPrincipalBean")
@ViewScoped
public class TelaPrincipalBean implements Serializable{
    private Inscricao inscricao;
    private Usuario usuario;
    private Integer alunosCadastrados = 0;
    private Integer alunosInscritos = 0;
    private Integer entrevistas = 0;
    
    @PostConstruct
    public void init(){
        InscricaoRN inscricaoRN = new InscricaoRN();
        UsuarioRN usuarioRN = new UsuarioRN();
        inscricao = inscricaoRN.carregar();
        AlunoRN alunoRN = new AlunoRN();
        
        if(alunoRN.alunosCadastrados() != null)
            alunosCadastrados = alunoRN.alunosCadastrados().size();
        
        if(alunoRN.alunosInscritos() != null)
            alunosInscritos = alunoRN.alunosInscritos().size();
        
        if(alunoRN.alunosEntrevistados() != null){
            entrevistas = alunoRN.alunosEntrevistados().size();
        }
        
        
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext external = context.getExternalContext();
        String cpf = external.getRemoteUser();
        usuario = usuarioRN.buscarPorLogin(cpf);
        
        if(usuario == null){
            usuario = new Usuario();
            usuario.setNome("Ninguém está logado");
        }        
    }

    public void ativarDesativar(){
        InscricaoRN inscricaoRN = new InscricaoRN();
        
        if(inscricao != null){
            if(inscricao.getPeriodoInscricao()){
                inscricao.setPeriodoInscricao(Boolean.FALSE);
                inscricaoRN.atualizar(Boolean.FALSE);
            }else{
                inscricao.setPeriodoInscricao(Boolean.TRUE);
                inscricaoRN.atualizar(Boolean.TRUE);
            }            
        }
        
    }
    
    public Inscricao getInscricao() {
        return inscricao;
    }

    public void setInscricao(Inscricao inscricao) {
        this.inscricao = inscricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getAlunosCadastrados() {
        return alunosCadastrados;
    }

    public void setAlunosCadastrados(Integer alunosCadastrados) {
        this.alunosCadastrados = alunosCadastrados;
    }

    public Integer getAlunosInscritos() {
        return alunosInscritos;
    }

    public void setAlunosInscritos(Integer alunosInscritos) {
        this.alunosInscritos = alunosInscritos;
    }

    public Integer getEntrevistas() {
        return entrevistas;
    }

    public void setEntrevistas(Integer entrevistas) {
        this.entrevistas = entrevistas;
    }
    
    
}
