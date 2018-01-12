package com.waterkemper.learnmodularizado.model;

import com.waterkemper.learnmodularizado.util.AbstractEntityBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PROCESSO")
@SequenceGenerator(name = "seq_processos", sequenceName = "SEQ_PROCESSOS", allocationSize = 1)
public class Processo {

    @Id
    @GeneratedValue(generator = "seq_processos")
    private long id;

    @NotNull
    @Size(max = 2000)
    @Column(name = "ASSUNTO")
    private String assunto;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CLIENTE", nullable = false,
            foreignKey = @ForeignKey(name = "FK_PROCESSO_CLIENTE"))
    private Cliente cliente;

    public Processo() {
    }

    public long getId() {
        return id;
    }

    public String getAssunto() {
        return assunto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public static class Builder extends AbstractEntityBuilder<Processo, Cliente.Builder>{
        public Builder(Processo entity) {
            super(entity);
        }

        public Builder create(){
            return new Builder(new Processo());
        }

        public Builder from(Processo processo){
            return new Builder(processo);
        }

        public Builder assunto(String assunto){
           entity.assunto = assunto;
           return this;
        }

        public Builder cliente(Cliente cliente){
            entity.cliente = cliente;
            return this;
        }
    }
}
