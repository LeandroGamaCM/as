package br.edu.ifba.paae.bean.adm;

import br.edu.ifba.paae.entidades.inscricao.PeriodoInscricao;
import br.edu.ifba.paae.entidades.usuario.Usuario;
import br.edu.ifba.paae.rn.formulario.AlunoRN;
import br.edu.ifba.paae.rn.inscricao.PeriodoInscricaoRN;
import br.edu.ifba.paae.rn.usuario.UsuarioRN;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name = "telaPrincipalBean")
@ViewScoped
public class TelaPrincipalBean implements Serializable{
    private PeriodoInscricao periodoInscricao;
    private Usuario usuario;
    private Integer alunosCadastrados = 0;
    private Integer alunosInscritos = 0;
    private Integer entrevistas = 0;
    
    @PostConstruct
    public void init(){
        PeriodoInscricaoRN periodoInscricaoRN = new PeriodoInscricaoRN();
        UsuarioRN usuarioRN = new UsuarioRN();
        
        LocalDateTime now = LocalDateTime.now();
        periodoInscricao = periodoInscricaoRN.buscarPorAno(now.getYear());
        if(periodoInscricao == null){
            periodoInscricao = new PeriodoInscricao();
            periodoInscricao.setAno(now.getYear());
            periodoInscricao.setAtivado(Boolean.FALSE);
            
            periodoInscricaoRN.salvar(periodoInscricao);
        }
        
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
            usuario.setNome("Niguém está logado");
        }        
    }

    public void ativarDesativar(){
        PeriodoInscricaoRN periodoInscricaoRN = new PeriodoInscricaoRN();
        
        if(periodoInscricao != null){
            if(periodoInscricao.getAtivado()){
                periodoInscricao.setAtivado(Boolean.FALSE);
            }else{
                periodoInscricao.setAtivado(Boolean.TRUE);
            }            
                periodoInscricaoRN.salvar(periodoInscricao);
        }
        
    }

    public PeriodoInscricao getPeriodoInscricao() {
        return periodoInscricao;
    }

    public void setPeriodoInscricao(PeriodoInscricao periodoInscricao) {
        this.periodoInscricao = periodoInscricao;
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
