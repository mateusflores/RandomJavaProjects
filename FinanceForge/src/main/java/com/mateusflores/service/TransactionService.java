package com.mateusflores.service;

import com.mateusflores.controller.BankAccountController;
import com.mateusflores.controller.TransactionController;
import com.mateusflores.model.entities.BankAccount;
import com.mateusflores.model.entities.Transaction;

public class TransactionService {
    private static boolean isTransactionValid(Transaction transaction) {
        Double actualAmount = transaction.getBankAccount().getAmount();
        Double transactionValue = transaction.getValue();
        return !(actualAmount + transactionValue < 0 && transactionValue < 0);
    }

    public static void processBankPayment(Transaction transaction) {
        if (isTransactionValid(transaction)) {
            TransactionController transactionController = new TransactionController();
            BankAccountController bankAccountController = new BankAccountController();

            BankAccount bankAccount = bankAccountController.findById(transaction.getBankAccount().getId());
            Double transactionValue = transaction.getValue();
            if (transactionValue > 0) {
                bankAccount.deposit(transactionValue);
                System.out.println("Deposit");
            } else {
                bankAccount.withdraw(transactionValue);
                System.out.println("Withdraw");
            }

            transaction.setTransactionCompleted(true);
            bankAccount.addTransaction(transaction);

            transactionController.createTransaction(transaction);
            bankAccountController.updateBankAccount(bankAccount);

            System.out.println("Transaction completed successfully.");
        } else {
            System.out.println("Invalid transaction.");
        }
    }
}
