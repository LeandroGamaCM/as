//
//import br.edu.ifba.paae.entidades.formulario.Aluno;
//import java.io.Serializable;
//import java.util.HashSet;
//import java.util.Objects;
//import java.util.Set;
//import javax.persistence.Column;
//import javax.persistence.ElementCollection;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//import javax.persistence.UniqueConstraint;
//
//@Entity
//@Table(name = "usuario")
//public class Usuario implements Serializable{
//    private static final long serialVersionUID = -8730937239625352335L;
//
//    @Id
//    @GeneratedValue
//    private Integer id;
//
//    @Column(unique = true, nullable = false)
//    private String login;
//    private String nome;
//    private String email;
//    private String senha;
//    private Boolean ativo;
//
//    @ElementCollection(targetClass = String.class)
//    @JoinTable(
//        name="usuario_permissao",
//        uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario", "permissao"})},
//        joinColumns = @JoinColumn(name = "usuario"))
//    @Column(name = "permissao")
//    private Set<String> permissao = new HashSet<String>();
//    
//    @OneToOne(mappedBy = "usuario")
//    private br.edu.ifba.paae.entidades.formulario.Aluno aluno;    
//    
//    // Getters and setters, equals and hashCode
//    
//
//    
//    
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 67 * hash + Objects.hashCode(this.id);
//        hash = 67 * hash + Objects.hashCode(this.login);
//        hash = 67 * hash + Objects.hashCode(this.nome);
//        hash = 67 * hash + Objects.hashCode(this.email);
//        hash = 67 * hash + Objects.hashCode(this.senha);
//        hash = 67 * hash + Objects.hashCode(this.ativo);
//        hash = 67 * hash + Objects.hashCode(this.permissao);
//        hash = 67 * hash + Objects.hashCode(this.aluno);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Usuario other = (Usuario) obj;
//        if (!Objects.equals(this.login, other.login)) {
//            return false;
//        }
//        if (!Objects.equals(this.nome, other.nome)) {
//            return false;
//        }
//        if (!Objects.equals(this.email, other.email)) {
//            return false;
//        }
//        if (!Objects.equals(this.senha, other.senha)) {
//            return false;
//        }
//        if (!Objects.equals(this.id, other.id)) {
//            return false;
//        }
//        if (!Objects.equals(this.ativo, other.ativo)) {
//            return false;
//        }
//        if (!Objects.equals(this.permissao, other.permissao)) {
//            return false;
//        }
//        if (!Objects.equals(this.aluno, other.aluno)) {
//            return false;
//        }
//        return true;
//    }
//
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getSenha() {
//        return senha;
//    }
//
//    public void setSenha(String senha) {
//        this.senha = senha;
//    }
//
//    public Boolean getAtivo() {
//        return ativo;
//    }
//
//    public void setAtivo(Boolean ativo) {
//        this.ativo = ativo;
//    }
//
//    public Set<String> getPermissao() {
//        return permissao;
//    }
//
//    public void setPermissao(Set<String> permissao) {
//        this.permissao = permissao;
//    }
//
//    public Aluno getAluno() {
//        return aluno;
//    }
//
//    public void setAluno(Aluno aluno) {
//        this.aluno = aluno;
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//}