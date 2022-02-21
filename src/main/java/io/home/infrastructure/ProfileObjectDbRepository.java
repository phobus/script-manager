package io.home.infrastructure;

import io.home.model.Node;
import io.home.model.Profile;
import io.home.model.ProfileRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Optional;

public class ProfileObjectDbRepository implements ProfileRepository {

    private EntityManager entityManager;

    @Override
    public Profile save(Profile entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public Optional<Profile> findById(Long id) {
        TypedQuery<Profile> query = entityManager.createQuery("SELECT p FROM Profile p WHERE p.id = :id", Profile.class);
        query.setParameter("id", id);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public void remove(Node node) {
        entityManager.getTransaction().begin();
        entityManager.remove(node);
        entityManager.getTransaction().commit();
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}