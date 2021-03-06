package com.waterkemper.learnmodularizado.model;

import com.waterkemper.learnmodularizado.util.AbstractEntityBuilder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "PESSOA")
@SequenceGenerator(name = "seq_pessoa", sequenceName = "SEQ_PESSOA", allocationSize = 1)
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
    private long id;

    @NotNull
    @Size(min = 1, max = 75)
    @Pattern(regexp = "[^0-9]*", message = "O nome não deve conter números")
    @Column(name = "NOME", nullable = false)
    private String nome;

    @NotNull
    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private LocalDate dataNascimento;

    @NotNull
    @Size(max = 11, message = "O CPF deve conter onze dígitos")
    @Column(name = "CPF", nullable = false)
    private String cpf;

    @Enumerated(EnumType.STRING)
    @Column(name = "SEXO")
    private Sexo sexo;

    @NotNull
    @NotEmpty
    @Email
    @Column(name = "EMAIL")
    private String email;

    public Pessoa() {
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public static class Builder extends AbstractEntityBuilder<Pessoa, Cliente.Builder>{

        public Builder(Pessoa entity) {
            super(entity);
        }

        public Builder create(){
            return new Builder(new Pessoa());
        }

        public Builder from(Pessoa pessoa){
            return new Builder(pessoa);
        }

        public Builder nome(String nome){
            entity.nome = nome;
            return this;
        }

        public Builder email(String email){
            entity.email = email;
            return this;
        }

        public Builder dataNascimento(LocalDate dataNascimento) {
            entity.dataNascimento = dataNascimento;
            return this;
        }

        public Builder cpf(String cpf){
            entity.cpf = cpf;
            return this;
        }

        public Builder sexo(Sexo sexo){
            entity.sexo = sexo;
            return this;
        }
    }


}
