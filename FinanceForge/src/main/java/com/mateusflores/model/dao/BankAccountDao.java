/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mateusflores.model.dao;

import com.mateusflores.model.entities.BankAccount;

/**
 *
 * @author mateus
 */
public interface BankAccountDao {

    BankAccount findById(Integer bankAccountId);

    void create(BankAccount bankAccount);

    BankAccount update(BankAccount bankAccount);

    void remove(BankAccount bankAccount);

    void close();
}
