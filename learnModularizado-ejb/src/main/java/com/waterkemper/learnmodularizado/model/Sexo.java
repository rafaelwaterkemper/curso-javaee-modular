package com.waterkemper.learnmodularizado.model;

public enum Sexo {

    MASCULINO(1, "MASCULINO"),
    FEMININO(2, "Feminino");

    private int value;
    private String description;

    Sexo(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue(){
        return value;
    }

    public String getDescription(){
        return description;
    }
}
