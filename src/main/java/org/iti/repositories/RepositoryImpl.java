package org.iti.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.iti.repositories.interfaces.Repository;

import java.util.List;

public class RepositoryImpl<T> implements Repository<T> {

    protected EntityManagerFactory factory;
    protected EntityManager em;
    private Class<T> type;

    public RepositoryImpl(Class<T> t) {
        factory = Persistence.createEntityManagerFactory("sakila");
        em = factory.createEntityManager();
        type = t;
    }

    @Override
    public T create(T t) {
        try {
            em.getTransaction().begin();
            em.persist(t);
            System.out.println("Added to Database");
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return t;
    }

    @Override
    public T findById(int id) {
        return em.find(type, id);
    }

    @Override
    public <K> T find(K k) {
        return em.find(type,k);
    }

    @Override
    public List<T> findAll() {
        return em.createQuery("FROM "+type.getName()+ " ").getResultList();
    }

    @Override
    public T update(T t) {
        try {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();

        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        }
        return t;
    }

    @Override
    public boolean remove(T t) {
        em.remove(t);
        return true;
    }
}
