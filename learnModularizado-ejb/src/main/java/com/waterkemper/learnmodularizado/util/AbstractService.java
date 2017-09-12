package com.waterkemper.learnmodularizado.util;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class AbstractService<T> {

    @Inject
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void persist(T t) {
        em.persist(t);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public T merge(T t) {
        return em.merge(t);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remove(T t) {
        em.remove(em.contains(t)? t: em.merge(t));
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
