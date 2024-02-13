package com.mateusflores.controller;

import com.mateusflores.model.dao.UserDao;
import com.mateusflores.model.daoImpl.UserDaoImpl;
import com.mateusflores.model.entities.UserAccount;

public class UserController {
    private final UserDao dao;

    public UserController() {
        this.dao = new UserDaoImpl();
    }

    public UserAccount findById(Integer id) {
        return dao.findById(id);
    }

    public void insertUser(UserAccount user) {
        dao.create(user);
    }

    public UserAccount updateUser(UserAccount user) {
        return dao.update(user);
    }

    public void removeUser(UserAccount user) {
        dao.remove(user);
    }

    public void releaseResources() {
        dao.close();
    }
}
