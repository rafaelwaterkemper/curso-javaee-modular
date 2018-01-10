package com.waterkemper.learnmodularizado.service;

import com.waterkemper.learnmodularizado.model.Cliente;
import com.waterkemper.learnmodularizado.util.AbstractService;
import com.waterkemper.learnmodularizado.util.Repository;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ClienteService extends AbstractService<Cliente> {

    @Inject
    private Repository<Cliente> repository;

    @Override
    public Repository<Cliente> getRepository() {
        return repository;
    }

}
