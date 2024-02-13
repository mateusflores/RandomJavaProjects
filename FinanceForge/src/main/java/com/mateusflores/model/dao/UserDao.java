/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mateusflores.model.dao;

import com.mateusflores.model.entities.UserAccount;

/**
 *
 * @author mateus
 */
public interface UserDao {
    UserAccount findById(Integer userId);
    void create(UserAccount user);
    UserAccount update(UserAccount user);
    void remove(UserAccount user);
    void close();
}
