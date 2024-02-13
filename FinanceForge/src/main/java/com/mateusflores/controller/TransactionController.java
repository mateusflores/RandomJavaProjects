package com.mateusflores.controller;

import com.mateusflores.model.dao.TransactionDao;
import com.mateusflores.model.daoImpl.TransactionDaoImpl;
import com.mateusflores.model.entities.Transaction;

public class TransactionController {
    private final TransactionDao dao;

    public TransactionController() {
        dao = new TransactionDaoImpl();
    }

    public Transaction findById(Integer id) {
        return dao.findById(id);
    }

    public void createTransaction(Transaction transaction) {
        dao.create(transaction);
    }

    public Transaction updateTransaction(Transaction transaction) {
        return dao.update(transaction);
    }

    public void deleteTransaction(Transaction transaction) {
        dao.delete(transaction);
    }

    public void releaseResources() {
        dao.close();
    }
}
