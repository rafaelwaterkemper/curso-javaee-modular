package com.waterkemper.learnmodularizado.service;

import com.waterkemper.learnmodularizado.model.Pessoa;
import com.waterkemper.learnmodularizado.util.AbstractService;
import com.waterkemper.learnmodularizado.util.Repository;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PessoaService extends AbstractService<Pessoa> {

    @Inject
    private Repository<Pessoa> repository;

    @Override
    public Repository<Pessoa> getRepository() {
        return repository;
    }
}
