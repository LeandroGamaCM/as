package br.edu.ifba.as.entidades.usuario;

import br.edu.ifba.as.entidades.formulario.Aluno;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
    private static final long serialVersionUID = -8730937239625352335L;

    @Id
    @GeneratedValue
    @Column(name = "cod_usuario")
    private Integer usuario;
    
    @OneToOne
    @JoinColumn(name = "cod_usuario")
    private Aluno aluno;
    
    @Column(length = 45)
    private String nome;
    
    @Column(length = 45, unique = true)
    private String login;
    
    private String senha;
    private Boolean ativo;

    @ElementCollection(targetClass = String.class)
    @JoinTable(
        name="usuario_permissao",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario", "permissao"})},
        joinColumns = @JoinColumn(name = "usuario"))
    @Column(name = "permissao")
    private Set<String> permissao = new HashSet<String>();

    public Set<String> getPermissao() {
        return permissao;
    }

    public void setPermissao(Set<String> permissao) {
        this.permissao = permissao;
    }
    
    
    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.usuario);
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + Objects.hashCode(this.login);
        hash = 37 * hash + Objects.hashCode(this.senha);
        hash = 37 * hash + Objects.hashCode(this.ativo);
        hash = 37 * hash + Objects.hashCode(this.permissao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.ativo, other.ativo)) {
            return false;
        }
        if (!Objects.equals(this.permissao, other.permissao)) {
            return false;
        }
        return true;
    }

    
}
