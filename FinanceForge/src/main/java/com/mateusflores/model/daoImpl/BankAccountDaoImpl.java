package com.mateusflores.model.daoImpl;

import com.mateusflores.model.dao.BankAccountDao;
import com.mateusflores.model.entities.BankAccount;
import com.mateusflores.util.dataAccess.GenerateEntityManagerFactory;
import jakarta.persistence.EntityManager;

public class BankAccountDaoImpl implements BankAccountDao {
    private final EntityManager em;

    public BankAccountDaoImpl() {
        em = GenerateEntityManagerFactory.generateEntityManager();
    }

    @Override
    public BankAccount findById(Integer bankAccountId) {
        return em.find(BankAccount.class, bankAccountId);
    }

    @Override
    public void create(BankAccount user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public BankAccount update(BankAccount bankAccount) {
        em.getTransaction().begin();
        BankAccount bk = em.merge(bankAccount);
        em.getTransaction().commit();
        return bk;
    }

    @Override
    public void remove(BankAccount user) {
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }

    @Override
    public void close() {
        em.close();
    }
}
