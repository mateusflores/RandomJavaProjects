/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mateusflores.util.dataAccess;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author mateus
 */
public class GenerateEntityManagerFactory {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("financeforge");
    
    public static EntityManager generateEntityManager() {
        return emf.createEntityManager();
    }
}
