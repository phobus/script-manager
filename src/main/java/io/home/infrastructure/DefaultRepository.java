package io.home.infrastructure;

import io.home.model.Node;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class DefaultRepository<ID, E> {

    private EntityManager entityManager;

    public E save(E entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    public List<Node> findAll() {
        TypedQuery<Node> query = entityManager.createQuery("SELECT n FROM Node n", Node.class);
        return query.getResultList();
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
