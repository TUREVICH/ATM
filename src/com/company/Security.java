package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * The type Security.
 */
class Security {
    /**
     * The Atm.
     */
    private ATM atm = new ATM(1,1,1);

    /**
     * Security.
     *
     * @throws FileNotFoundException the file not found exception
     */
    void security() throws FileNotFoundException {
        for (int i = 0; i < 3; i++) {
            File file = new File("Password");
            Scanner scanner = new Scanner(file);
            int password_true = scanner.nextInt();
            scanner.close();

            Scanner scan = new Scanner(System.in);
            System.out.println("Enter Password:");
            int password_try = scan.nextInt();

            if (password_true == password_try) {
                i = 3;
                atm.menu();
                break;
            } else {
                System.out.println("Wrong password");
            }
        }
    }

    /**
     * Change password.
     *
     * @throws FileNotFoundException the file not found exception
     */
    void changePassword() throws FileNotFoundException {
        File file = new File("Password");
        PrintWriter pw = new PrintWriter(file);

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter new password:");
        int new_password = scan.nextInt();
        pw.println(new_password);
        pw.close();
    }

}
