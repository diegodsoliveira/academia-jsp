package br.com.academiajsp.model;

import java.io.Serializable;
import java.util.Objects;

public class ModelLogin implements Serializable {

    private static final long serialVersionUID = 1L;

    private String login;

    private String senha;
    private String nome;
    private String email;
    private Long id;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModelLogin)) return false;
        ModelLogin that = (ModelLogin) o;
        return login.equals(that.login) && senha.equals(that.senha) && nome.equals(that.nome) && email.equals(that.email) && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, senha, nome, email, id);
    }
}
