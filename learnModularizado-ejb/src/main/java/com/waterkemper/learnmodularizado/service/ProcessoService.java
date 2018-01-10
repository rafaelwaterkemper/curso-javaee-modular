package com.waterkemper.learnmodularizado.service;

import com.waterkemper.learnmodularizado.model.Processo;
import com.waterkemper.learnmodularizado.util.Repository;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

@Stateless
public class ProcessoService {

    @Inject
    private Repository<Processo> repository;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(@Valid Processo processo) {
        repository.persist(processo);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Processo update(@Valid Processo processo) {
        return repository.merge(processo);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remover(Long id) {
        repository.remove(id);
    }

    public Processo findOne(long id) {
        return repository.findOne(id);
    }

    public List<Processo> findAll() {
        return repository.findAll();
    }
}
