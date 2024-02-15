/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mateusflores.model.entities;

import com.mateusflores.util.converter.LocalDateAttributeConverter;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mateus
 */
@Entity
@Table(name = "bank_account")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private Double amount = 0D;
    
    private String accountName;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserAccount owner;
    
    @Column
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate creationDate;
    
    @OneToMany(mappedBy = "bankAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions = new ArrayList<>();

    public BankAccount() {
    }

    public BankAccount(String accountName, UserAccount owner, LocalDate creationDate) {
        this.accountName = accountName;
        this.owner = owner;
        this.creationDate = creationDate;
    }

    public Integer getId() {
        return id;
    }

    public void withdraw(Double amountToWithdraw) {
        this.amount += amountToWithdraw < 0 ? amountToWithdraw : (-1 * amountToWithdraw);
    }

    public void deposit(Double amountToDeposit) {
        this.amount += amountToDeposit;
    }

    public double getAmount() {
        return this.amount;
    }

    public UserAccount getOwner() {
        return owner;
    }

    public void setOwner(UserAccount owner) {
        this.owner = owner;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final BankAccount other = (BankAccount) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "BankAccount{" + "id=" + id + ", amount=" + amount + ", owner=" + owner + ", creationDate=" + creationDate + '}';
    }

}
