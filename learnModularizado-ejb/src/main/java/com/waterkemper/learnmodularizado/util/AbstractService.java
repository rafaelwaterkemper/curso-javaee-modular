package com.waterkemper.learnmodularizado.util;

import com.waterkemper.learnmodularizado.model.Usuario;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.validation.Valid;
import java.util.List;

public abstract class AbstractService<T> {

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void saveUser(@Valid T t) {
        getRepository().persist(t);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public T update(@Valid T t) {
        return getRepository().merge(t);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remover(Long id) {
        getRepository().remove(id);
    }

    public T findOne(long id) {
        return getRepository().findOne(id);
    }

    public List<T> findAll() {
        return getRepository().findAll();
    }

    public abstract Repository<T> getRepository();
}
