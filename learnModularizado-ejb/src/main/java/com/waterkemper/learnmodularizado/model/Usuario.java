package com.waterkemper.learnmodularizado.model;

import com.waterkemper.learnmodularizado.util.AbstractEntityBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "LOGIN")
    @Size(max = 100)
    private String login;

    @NotNull
    @Column(name = "SENHA")
    @Size(max = 100, message = "Limite máximo e {max}")
    private String senha;

    protected Usuario() {
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public static class Builder extends AbstractEntityBuilder<Usuario, Builder> {

        private Builder(Usuario interessado) {
            super(interessado);
        }

        public static Builder create() {
            return new Builder(new Usuario());
        }

        public static Builder from(Usuario usuario) {
            return new Builder(usuario);
        }

        public Builder login(String login) {
            entity.login = login;
            return this;
        }

        public Builder senha(String senha) {
            entity.senha = senha;
            return this;
        }

    }
}