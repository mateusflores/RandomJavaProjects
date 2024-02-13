package com.mateusflores.model.entities;

import com.mateusflores.util.converter.LocalDateAttributeConverter;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author mateus
 */
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private Double value;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_account")
    private BankAccount bankAccount;
    
    @Column
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate transactionDate;

    public Transaction() {
    }

    public Transaction(Double value, BankAccount bankAccount, LocalDate transactionDate) {
        this.value = value;
        this.bankAccount = bankAccount;
        this.transactionDate = transactionDate;
    }

    public Integer getId() {
        return id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Transaction other = (Transaction) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Transaction{" + "id=" + id + ", value=" + value + ", bankAccount=" + bankAccount + ", transactionDate=" + transactionDate + '}';
    }

}
