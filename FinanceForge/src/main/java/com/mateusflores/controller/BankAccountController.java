package com.mateusflores.controller;

import com.mateusflores.model.dao.BankAccountDao;
import com.mateusflores.model.daoImpl.BankAccountDaoImpl;
import com.mateusflores.model.entities.BankAccount;

public class BankAccountController {
    private final BankAccountDao dao;

    public BankAccountController() {
        dao = new BankAccountDaoImpl();
    }

    public BankAccount findById(Integer id) {
        return dao.findById(id);
    }

    public void createBankAccount(BankAccount bankAccount) {
        dao.create(bankAccount);
    }

    public BankAccount updateBankAccount(BankAccount bankAccount) {
        return dao.update(bankAccount);
    }

    public void deleteBankAccount(BankAccount bankAccount) {
        dao.remove(bankAccount);
    }

    public void releaseResources() {
        dao.close();
    }
}
