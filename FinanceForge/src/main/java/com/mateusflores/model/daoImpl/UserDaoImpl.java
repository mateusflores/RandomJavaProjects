/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mateusflores.model.daoImpl;

import com.mateusflores.model.dao.UserDao;
import com.mateusflores.model.entities.UserAccount;
import com.mateusflores.util.dataAccess.GenerateEntityManagerFactory;

import jakarta.persistence.EntityManager;

/**
 *
 * @author mateus
 */
public class UserDaoImpl implements UserDao {
    private final EntityManager em;

    public UserDaoImpl() {
        em = GenerateEntityManagerFactory.generateEntityManager();
    }

    @Override
    public UserAccount findById(Integer userId) {
        return em.find(UserAccount.class, userId);
    }

    @Override
    public void create(UserAccount user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public UserAccount update(UserAccount user) {
        em.getTransaction().begin();
        UserAccount userUpdated = em.merge(user);
        em.getTransaction().commit();
        return userUpdated;
    }

    @Override
    public void remove(UserAccount user) {
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }

    public void close() {
        em.close();
    }
}
