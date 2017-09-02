package com.waterkemper.learnmodularizado.util;

public abstract class AbstractEntityBuilder<T, B extends AbstractEntityBuilder> {

    protected T entity;

    public AbstractEntityBuilder(T entity) {
        this.entity = entity;
    }

    protected void beforeValidate(){
    }

    protected void afterValidate(){
    }

    protected void validate(){
        //Implementar validação
    }

    public T build(){
        beforeValidate();
        validate();
        afterValidate();
        return entity;
    }
}