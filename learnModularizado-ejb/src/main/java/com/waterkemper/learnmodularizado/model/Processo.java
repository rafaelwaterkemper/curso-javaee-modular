package com.waterkemper.learnmodularizado.model;

import com.waterkemper.learnmodularizado.util.AbstractEntityBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "PROCESSO")
@SequenceGenerator(name = "seq_processos", sequenceName = "SEQ_PROCESSOS", allocationSize = 1)
public class Processo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_processos")
    private long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE", nullable = false,
            foreignKey = @ForeignKey(name = "FK_PROCESSO_CLIENTE"))
    private Cliente cliente;

    @NotNull
    @Size(max = 2000)
    @Column(name = "ASSUNTO")
    private String assunto;

    @NotNull
    @Column(name = "HONORARIO", nullable = false, precision = 15, scale = 5)
    private BigDecimal honorario;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private Status status;

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

    public BigDecimal getHonorario() {
        return honorario;
    }

    public Status getStatus() {
        return status;
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

        public Builder honorario(BigDecimal honorario) {
            entity.honorario = honorario;
            return this;
        }

        public Builder status(Status status) {
            entity.status = status;
            return this;
        }
    }
}
