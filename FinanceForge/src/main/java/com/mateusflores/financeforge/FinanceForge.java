

package com.mateusflores.financeforge;

import com.mateusflores.controller.BankAccountController;
import com.mateusflores.controller.TransactionController;
import com.mateusflores.controller.UserController;
import com.mateusflores.model.entities.BankAccount;
import com.mateusflores.model.entities.Transaction;
import com.mateusflores.model.entities.UserAccount;
import com.mateusflores.service.TransactionService;
import com.mateusflores.view.MainMenu;

import java.sql.ClientInfoStatus;
import java.time.LocalDate;
import javax.swing.JFrame;

/**
 *
 * @author mateus
 */
public class FinanceForge {

    public static void main(String[] args) {
        MainMenu view = new MainMenu();
        view.setVisible(true);
    }
}
