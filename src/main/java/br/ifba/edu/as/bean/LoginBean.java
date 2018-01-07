package br.ifba.edu.as.bean;

import br.edu.ifba.as.entidades.formulario.Aluno;
import br.edu.ifba.as.entidades.usuario.Usuario;
import br.edu.ifba.as.rn.AlunoRN;
import br.edu.ifba.as.rn.UsuarioRN;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "loginBean")
@ViewScoped
public class LoginBean implements Serializable{
    private Usuario usuario = new Usuario();
    private Aluno aluno = new Aluno();
    private Integer cpfPagina;
    private String nomePagina;
//    private String emailPagina;
    private String senhaPagina;

    public String verificaExistencia(){
        UsuarioRN usuarioRN = new UsuarioRN();
        AlunoRN alunoRN = new AlunoRN();
        aluno = alunoRN.buscarPorCPF(cpfPagina);
        System.out.println("\nCPF: " + aluno.getCpf() + "\nID: " + aluno.getAluno());
        if(aluno == null){
// Exibir mensagem
            System.out.println("\n\tAluno Nulo\n");
        }else{
            usuario = usuarioRN.buscarPorAluno(aluno.getAluno());
            if(usuario == null){
// Exibir mensagem
                System.out.println("\n\tUsuario Nulo\n");
            }else{
                if(usuario.getAtivo()){
                    System.out.println("\n\tEste usuario já está cadastrado!\n");
                }else{
                    salvar();
                }
            }
        }
        return "loginEntrar.jsf";
    }
    public void salvar(){
// Exibir mensagem e voltar pra tela de Login
        atribuirProperties();
        UsuarioRN usuarioRN = new UsuarioRN();
        AlunoRN alunoRN = new AlunoRN();
                
        usuarioRN.salvar(usuario);

        aluno.setUsuario(usuario);
        aluno.setNome(nomePagina);

        alunoRN.salvar(aluno);
        System.out.println("\n\tSalvo com Sucesso!\n");
        System.out.println("\nCPF: " + aluno.getCpf() + "\nID: " + aluno.getAluno());
        
    }
    
    public void atribuirProperties(){
        this.usuario.setAtivo(Boolean.TRUE);
        this.usuario.setLogin(cpfPagina.toString());
        this.usuario.setSenha(senhaPagina);
        
        this.aluno.setNome(nomePagina);
// Esse email deve ser uma variavel diferente do formulario? Porque ele é pra recuperação e lá pra contato
//        aluno.setEmail(emailPagina);
    }


// Getters e Setters
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Integer getCpfPagina() {
        return cpfPagina;
    }

    public void setCpfPagina(Integer cpfPagina) {
        this.cpfPagina = cpfPagina;
    }

    public String getNomePagina() {
        return nomePagina;
    }

    public void setNomePagina(String nomePagina) {
        this.nomePagina = nomePagina;
    }

    public String getSenhaPagina() {
        return senhaPagina;
    }

    public void setSenhaPagina(String senhaPagina) {
        this.senhaPagina = senhaPagina;
    }
    
}
