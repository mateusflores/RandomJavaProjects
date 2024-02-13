package com.mateusflores.model.daoImpl;

import com.mateusflores.model.dao.TransactionDao;
import com.mateusflores.model.entities.Transaction;
import com.mateusflores.util.dataAccess.GenerateEntityManagerFactory;
import jakarta.persistence.EntityManager;

public class TransactionDaoImpl implements TransactionDao {
    private final EntityManager em;
    public TransactionDaoImpl() {
        em = GenerateEntityManagerFactory.generateEntityManager();
    }

    @Override
    public Transaction findById(Integer id) {
        return em.find(Transaction.class, id);
    }

    @Override
    public void create(Transaction transaction) {
        em.getTransaction().begin();
        em.persist(transaction);
        em.getTransaction().commit();
    }

    @Override
    public Transaction update(Transaction transaction) {
        em.getTransaction().begin();
        Transaction updatedTransaction = em.merge(transaction);
        em.getTransaction().commit();
        return updatedTransaction;
    }

    @Override
    public void delete(Transaction transaction) {
        em.getTransaction().begin();
        em.remove(transaction);
        em.getTransaction().commit();
    }

    @Override
    public void close() {
        em.close();
    }
}
