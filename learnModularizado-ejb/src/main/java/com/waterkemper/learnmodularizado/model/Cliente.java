package com.waterkemper.learnmodularizado.model;

import com.waterkemper.learnmodularizado.util.AbstractEntityBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "CLIENTE")
@SequenceGenerator(name = "SEQ_CLIENTE", sequenceName = "SEQ_CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CLIENTE")
    private long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "id_pessoa", nullable = false,
            foreignKey = @ForeignKey(name = "FK_CLIENTE_PESSOA"))
    private Pessoa pessoa;

    @OneToMany(mappedBy = "cliente")
    private List<Processo> processos;

    @Size(max = 2000)
    @Column(name = "OBSERVACAO")
    private String observacao;


    protected Cliente() {
    }

    public long getId() {
        return id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public static class Builder extends AbstractEntityBuilder<Cliente, Builder>{

        public Builder(Cliente entity) {
            super(entity);
        }

        public static Builder create(){
            return new Builder(new Cliente());
        }

        public static Builder from(Cliente cliente){
            return new Builder(cliente);
        }

        public Builder cliente(Pessoa pessoa){
            entity.pessoa = pessoa;
            return this;
        }
    }
}
