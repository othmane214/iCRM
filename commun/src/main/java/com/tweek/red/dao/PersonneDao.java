package com.tweek.red.dao;

/**
 * Created by tweek on 18/12/16.
 */

import com.tweek.red.commun.Personne;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonneDao {


    // An EntityManager will be automatically injected from entityManagerFactory
    // setup on DatabaseConfig class.
    @PersistenceContext
    private EntityManager entityManager;

    public void create(Personne user) {
        entityManager.persist(user);
        return;
    }

    /**
     * Delete the user from the database.
     */
    public void delete(Personne user) {
        if (entityManager.contains(user))
            entityManager.remove(user);
        else
            entityManager.remove(entityManager.merge(user));
        return;
    }

    /**
     * Return all the users stored in the database.
     */
    @SuppressWarnings("unchecked")
    public List<Personne> getAll() {
        return entityManager.createQuery("from Personne").getResultList();
    }

    /**
     * Return the user having the passed email.
     */
    public Personne getByEmail(String email) {
        return (Personne) entityManager.createQuery(
                "from Personne where email = :email")
                .setParameter("email", email)
                .getSingleResult();
    }

    /**
     * Return the user having the passed id.
     */
    public Personne getById(long id) {
        return entityManager.find(Personne.class, id);
    }

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    /**
     * Update the passed user in the database.
     */
    public void update(Personne user) {
        entityManager.merge(user);
        return;
    }

} // class UserDao
