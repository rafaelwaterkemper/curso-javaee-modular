package com.waterkemper.learnmodularizado.service;

import com.mysema.query.types.Predicate;
import com.waterkemper.learnmodularizado.model.Pessoa;
import com.waterkemper.learnmodularizado.model.QPessoa;
import com.waterkemper.learnmodularizado.util.AbstractService;
import com.waterkemper.learnmodularizado.util.Repository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class PessoaService extends AbstractService<Pessoa> {

    @Inject
    private Repository<Pessoa> repository;

    @Override
    public Repository<Pessoa> getRepository() {
        return repository;
    }

    public List<Pessoa> findAll(long offset, long limit, String filter) {

        Predicate predicate = null;

        if (!filter.isEmpty()) {
            predicate = QPessoa.pessoa.nome.containsIgnoreCase(filter);
        }

        return getRepository().findAll(offset, limit, predicate);
    }
}
