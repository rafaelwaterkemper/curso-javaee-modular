package com.waterkemper.learnmodularizado.service;

import com.waterkemper.learnmodularizado.model.Processo;
import com.waterkemper.learnmodularizado.util.AbstractService;
import com.waterkemper.learnmodularizado.util.Repository;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ProcessoService extends AbstractService<Processo> {

    @Inject
    private Repository<Processo> repository;

    @Override
    public Repository<Processo> getRepository() {
        return repository;
    }
}
