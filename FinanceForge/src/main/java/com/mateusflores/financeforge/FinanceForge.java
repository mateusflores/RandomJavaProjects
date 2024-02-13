

package com.mateusflores.financeforge;

import com.mateusflores.controller.BankAccountController;
import com.mateusflores.controller.TransactionController;
import com.mateusflores.controller.UserController;
import com.mateusflores.model.entities.BankAccount;
import com.mateusflores.model.entities.Transaction;
import com.mateusflores.model.entities.UserAccount;
import com.mateusflores.service.TransactionService;

import java.sql.ClientInfoStatus;
import java.time.LocalDate;

/**
 *
 * @author mateus
 */
public class FinanceForge {

    public static void main(String[] args) {
        BankAccountController bankAccountController = new BankAccountController();
        Transaction transaction = new Transaction(-200.50, bankAccountController.findById(3));

        TransactionService.processBankPayment(transaction);
    }
}
