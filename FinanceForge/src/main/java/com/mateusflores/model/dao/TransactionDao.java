package com.mateusflores.model.dao;

import com.mateusflores.model.entities.Transaction;

public interface TransactionDao {
    Transaction findById(Integer id);

    void create(Transaction transaction);

    Transaction update(Transaction transaction);

    void delete(Transaction transaction);

    void close();
}
