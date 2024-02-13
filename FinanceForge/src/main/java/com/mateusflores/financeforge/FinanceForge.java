

package com.mateusflores.financeforge;

import com.mateusflores.controller.BankAccountController;
import com.mateusflores.controller.UserController;
import com.mateusflores.model.entities.BankAccount;
import com.mateusflores.model.entities.UserAccount;

import java.time.LocalDate;

/**
 *
 * @author mateus
 */
public class FinanceForge {

    public static void main(String[] args) {
        UserAccount user = new UserAccount("Mateus", "mateus@gmail.com");
        BankAccount bankAccount = new BankAccount(user, LocalDate.now());

        UserController userController = new UserController();
        userController.insertUser(user);

        BankAccountController bankAccountController = new BankAccountController();
        bankAccountController.createBankAccount(bankAccount);
    }
}
