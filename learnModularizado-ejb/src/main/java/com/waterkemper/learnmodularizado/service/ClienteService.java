package com.waterkemper.learnmodularizado.service;

import com.waterkemper.learnmodularizado.model.Cliente;
import com.waterkemper.learnmodularizado.model.Pessoa;
import com.waterkemper.learnmodularizado.util.Repository;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

@Stateless
public class ClienteService {

    @Inject
    private Repository<Cliente> repository;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(@Valid Cliente cliente) {
        repository.persist(cliente);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Cliente update(@Valid Cliente cliente) {
        return repository.merge(cliente);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remover(Long id) {
        repository.remove(id);
    }

    public Cliente findOne(long id) {
        return repository.findOne(id);
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

}
