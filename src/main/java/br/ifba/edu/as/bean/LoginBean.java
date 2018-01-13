package br.ifba.edu.as.bean;

import br.edu.ifba.as.entidades.formulario.Aluno;
import br.edu.ifba.as.entidades.usuario.Usuario;
import br.edu.ifba.as.rn.AlunoRN;
import br.edu.ifba.as.rn.UsuarioRN;
import br.edu.ifba.as.rn.analise.*;
import java.io.Serializable;
import javax.annotation.PostConstruct;
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

    @PostConstruct
    public void init(){
        System.out.println("\n\tEntrou em init\n");
        inicializar();
    }
    
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

// Esse método deve sair daqui e entrar em um inicializador    
    public void inicializar(){
        BolsaRN bolsaRN = new BolsaRN();
        ComposicaoFamiliarRN composicaoFamiliarRN = new ComposicaoFamiliarRN();
        CondicaoEconomicaEstudanteRN condicaoEconomicaEstudanteRN = new CondicaoEconomicaEstudanteRN();
        DespesaAnaliseRN despesaAnaliseRN = new DespesaAnaliseRN();
        EscolaOrigemRN escolaOrigemRN = new EscolaOrigemRN();
        EtniaRN etniaRN = new EtniaRN();
        GeneroRN generoRN = new GeneroRN();
        LocalResidenciaFamiliaRN localResidenciaFamiliaRN = new LocalResidenciaFamiliaRN();
        MoradiaEstudanteRN moradiaEstudanteRN = new MoradiaEstudanteRN();
        MoradiaFamiliaRN moradiaFamiliaRN = new MoradiaFamiliaRN();
        ProgramaSocialRN programaSocialRN = new ProgramaSocialRN();
        RendaPerCapitaRN rendaPerCapitaRN = new RendaPerCapitaRN();
        RendaPrincipalOrigemRN rendaPrincipalOrigemRN = new RendaPrincipalOrigemRN();
        SaudeRN saudeRN = new SaudeRN();
        SituacaoOcupacionalRN situacaoOcupacionalRN = new SituacaoOcupacionalRN();
        UsuarioRN usuarioRN = new UsuarioRN();

        if(usuarioRN.listar() == null || usuarioRN.listar().isEmpty()){
            System.out.println("Cadastrou usuario");
            usuarioRN.criarADM();
        }
        if(bolsaRN.listar() == null || bolsaRN.listar().isEmpty()){
            System.out.println("\n\tEntrou no if de bolsa\n");
            bolsaRN.definirPadroes();
        }
        if(composicaoFamiliarRN.listar() == null || composicaoFamiliarRN.listar().isEmpty()){
            composicaoFamiliarRN.definirPadroes();
        }
        if(condicaoEconomicaEstudanteRN.listar() == null || condicaoEconomicaEstudanteRN.listar().isEmpty()){
            condicaoEconomicaEstudanteRN.definirPadroes();
        }
        if(despesaAnaliseRN.listar() == null || despesaAnaliseRN.listar().isEmpty()){
            despesaAnaliseRN.definirPadroes();
        }
        if(escolaOrigemRN.listar() == null || escolaOrigemRN.listar().isEmpty()){
            escolaOrigemRN.definirPadroes();
        }
        if(etniaRN.listar() == null || etniaRN.listar().isEmpty()){
            etniaRN.definirPadroes();
        }
        if(generoRN.listar() == null || generoRN.listar().isEmpty()){
            generoRN.definirPadroes();
        }
        if(localResidenciaFamiliaRN.listar() == null || localResidenciaFamiliaRN.listar().isEmpty()){
            localResidenciaFamiliaRN.definirPadroes();
        }
        if(moradiaEstudanteRN.listar() == null || moradiaEstudanteRN.listar().isEmpty()){
            moradiaEstudanteRN.definirPadroes();
        }
        if(moradiaFamiliaRN.listar() == null || moradiaFamiliaRN.listar().isEmpty()){
            moradiaFamiliaRN.definirPadroes();
        }
        if(programaSocialRN.listar() == null || programaSocialRN.listar().isEmpty()){
            programaSocialRN.definirPadroes();
        }
        if(rendaPerCapitaRN.listar() == null || rendaPerCapitaRN.listar().isEmpty()){
            rendaPerCapitaRN.definirPadroes();
        }
        if(rendaPrincipalOrigemRN.listar() == null || rendaPrincipalOrigemRN.listar().isEmpty()){
            rendaPrincipalOrigemRN.definirPadroes();
        }
        if(saudeRN.listar() == null || saudeRN.listar().isEmpty()){
            saudeRN.definirPadroes();
        }
        if(situacaoOcupacionalRN.listar() == null || situacaoOcupacionalRN.listar().isEmpty()){
            situacaoOcupacionalRN.definirPadroes();
        }
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
