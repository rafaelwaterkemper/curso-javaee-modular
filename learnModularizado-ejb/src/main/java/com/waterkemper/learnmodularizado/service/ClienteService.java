package com.waterkemper.learnmodularizado.service;

import com.mysema.query.types.Predicate;
import com.waterkemper.learnmodularizado.model.Cliente;
import com.waterkemper.learnmodularizado.model.QCliente;
import com.waterkemper.learnmodularizado.util.AbstractService;
import com.waterkemper.learnmodularizado.util.Repository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ClienteService extends AbstractService<Cliente> {

    @Inject
    private Repository<Cliente> repository;

    @Override
    public Repository<Cliente> getRepository() {
        return repository;
    }

    public List<Cliente> findAll(long offset, long limit, String filter) {

        Predicate predicate = null;

        if (!filter.isEmpty()) {
            predicate = QCliente.cliente
                    .pessoa()
                    .nome
                    .containsIgnoreCase(filter);
        }

        return getRepository().findAll(offset, limit, predicate);
    }


}
