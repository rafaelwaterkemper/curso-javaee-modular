package com.waterkemper.learnmodularizado.util;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.EntityPath;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.path.PathBuilderFactory;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.util.List;

public class Repository<T> {

    private final Class<T> classe;

    private EntityManager em;

    private PathBuilderFactory pathBuilderFactory;

    public Repository(Class classe, EntityManager em) {
        this.em = em;
        this.classe = classe;
        this.pathBuilderFactory = new PathBuilderFactory();
    }

    public void persist(T t) {
        em.persist(t);
    }

    public T merge(T t) {
        return em.merge(t);
    }

    public void remove(Long id) {
        em.remove(em.getReference(classe, id));
    }

    public T findOne(long id) {
        return em.find(classe, id);
    }

    public List<T> findAll(Predicate... predicates) {
        EntityPath<T> path = pathBuilderFactory.create(classe);
        JPQLQuery query = from(path);

        if (predicates.length > 0) {
            query.where(predicates);
        }

        return query.list(path);
    }

    private JPQLQuery from(EntityPath path) {
        return new JPAQuery(em).from(path);
    }


}
