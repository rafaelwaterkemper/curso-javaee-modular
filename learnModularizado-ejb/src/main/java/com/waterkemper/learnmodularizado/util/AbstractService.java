package com.waterkemper.learnmodularizado.util;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class AbstractService<T> {

    @Inject
    private EntityManager em;

    public void persist(T t) {
        em.persist(t);
    }

    public void merge(T t) {
        em.merge(t);
    }

    public void remove(T t) {
        em.remove(t);
    }

    public T find(Class<T> entityClass, long id) {
        return em.find(entityClass, id);
    }

    public List findAll(Class<T> entityClass) {
        CriteriaQuery<Object> criteria = em.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(entityClass));
        return em.createQuery(criteria).getResultList();
    }

}
