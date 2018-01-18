package com.waterkemper.learnmodularizado.model;

public enum Status {

    EM_ANDAMENTO(1, "Em andamento"),
    CONCLUIDO(2, "Concluído");

    private int value;
    private String description;

    Status(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

}
