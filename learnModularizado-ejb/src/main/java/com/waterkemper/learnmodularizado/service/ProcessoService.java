package com.waterkemper.learnmodularizado.service;

import com.mysema.query.types.Predicate;
import com.waterkemper.learnmodularizado.model.Processo;
import com.waterkemper.learnmodularizado.model.QProcesso;
import com.waterkemper.learnmodularizado.util.AbstractService;
import com.waterkemper.learnmodularizado.util.Repository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ProcessoService extends AbstractService<Processo> {

    @Inject
    private Repository<Processo> repository;

    @Override
    public Repository<Processo> getRepository() {
        return repository;
    }

    public List<Processo> findAll(long offset, long limit, String filter) {

        Predicate predicate = null;

        if (!filter.isEmpty()) {
            predicate = QProcesso.processo
                    .cliente()
                    .pessoa()
                    .nome
                    .containsIgnoreCase(filter);
        }

        return getRepository().findAll(offset, limit, predicate);
    }

}
