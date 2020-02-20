package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ATM {
    private int cash;

    public void security() throws FileNotFoundException {
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
                menu();
                break;
            } else {
                System.out.println("Wrong password");
            }
        }
    }

    private void change_password() throws FileNotFoundException {
        File file = new File("Password");
        PrintWriter pw = new PrintWriter(file);

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter new password:");
        int new_password = scan.nextInt();

        pw.println(new_password);
        pw.close();
    }

    private void balance(int c) {
        System.out.println("Your balance:" + "\n" + c + " $");
    }

    private void replenishment() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How mach do you what to replenish?");
        int plus = scanner.nextInt();
        cash += plus;
        save();
    }

    private void take_off() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How mach do you want to remove?");
        int minus = scanner.nextInt();
        cash -= minus;
        save();
    }

    private void start() throws FileNotFoundException {
        File file = new File("Cash");
        Scanner scanner = new Scanner(file);
        cash = scanner.nextInt();
        scanner.close();
    }

    private void save() throws FileNotFoundException {
        File file = new File("Cash");
        PrintWriter pw = new PrintWriter(file);

        pw.println(cash);
        pw.close();
    }

    private void exit() {
        System.out.println("Exit");
    }

    private void menu() throws FileNotFoundException {
        start();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose action : " + "\n" + "1. Replenishment" + "\n" + "2. Balance" + "\n" + "3. Take off cash" + "\n" + "4. Change" + "\n" + "0. Exit");
        int option = scanner.nextInt();
        switch (option) {

            case 1:
                replenishment();
                break;
            case 2:
                balance(cash);
                break;
            case 3:
                take_off();
                break;
            case 4:
                change_password();
                break;
            case 0:
                exit();
                break;
            default:
                System.out.println("There is no such operation, try again");
                break;
        }
        save();

        System.out.println("Continue work ?");

        Scanner scan = new Scanner(System.in);
        int rePlay = scan.nextInt();

        if (rePlay == 0) {
            security();
        }
    }
}
