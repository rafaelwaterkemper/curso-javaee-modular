package com.waterkemper.learnmodularizado.model;

import com.waterkemper.learnmodularizado.util.AbstractEntityBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CLIENTE")
@SequenceGenerator(name = "seq_cliente", sequenceName = "SEQ_CLIENTE", allocationSize = 1)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cliente")
    private long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "id_pessoa", nullable = false,
            foreignKey = @ForeignKey(name = "FK_CLIENTE_PESSOA"))
    private Pessoa pessoa;

    //    Questionar a maneira correta para não entrar em dependência cíclica
//    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Processo> processos = new ArrayList<>();

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

    public String getObservacao() {
        return observacao;
    }
//    Questionar a maneira correta para não entrar em dependência cíclica
//    public List<Processo> getProcessos() {
//        return processos;
//    }

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

        public Builder observacao(String observacao){
            entity.observacao = observacao;
            return this;
        }

    }
}
