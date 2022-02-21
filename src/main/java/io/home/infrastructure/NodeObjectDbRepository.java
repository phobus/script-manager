package io.home.infrastructure;

import io.home.model.Node;
import io.home.model.NodeRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class NodeObjectDbRepository implements NodeRepository {

    private EntityManager entityManager;

    @Override
    public Node save(Node entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public List<Node> findAll() {
        TypedQuery<Node> query = entityManager.createQuery("SELECT n FROM Node n", Node.class);
        return query.getResultList();
    }

    @Override
    public Optional<Node> findById(Long id) {
        TypedQuery<Node> query = entityManager.createQuery("SELECT n FROM Node n WHERE n.id = :id", Node.class);
        query.setParameter("id", id);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public List<Node> findByIdIn(List<Long> collect) {
        TypedQuery<Node> query = entityManager.createQuery("SELECT n FROM Node n WHERE n.id in :ids", Node.class);
        query.setParameter("ids", collect);
        return query.getResultList();
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}