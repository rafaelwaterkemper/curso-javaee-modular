package com.waterkemper.learnmodularizado.service;

import com.waterkemper.learnmodularizado.model.Pessoa;
import com.waterkemper.learnmodularizado.model.Usuario;
import com.waterkemper.learnmodularizado.util.Repository;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

@Stateless
public class PessoaService {

    @Inject
    private Repository<Pessoa> repository;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(@Valid Pessoa pessoa) {
        repository.persist(pessoa);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Pessoa update(@Valid Pessoa pessoa) {
        return repository.merge(pessoa);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remover(Long id) {
        repository.remove(id);
    }

    public Pessoa findOne(long id) {
        return repository.findOne(id);
    }

    public List<Pessoa> findAll() {
        return repository.findAll();
    }
}
