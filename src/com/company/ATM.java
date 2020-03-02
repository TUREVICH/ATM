package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * The type Atm.
 */
class ATM {
    /**
     * The Security.
     */
    Security security = new Security();
    private int cash;
    private int denomination20number;
    private int denomination50number;
    private int denomination100number;
    Scanner scanner = new Scanner(System.in);

    private void balance(int c) {
        System.out.println("Your balance:" + "\n" + c + " $");
    }

    private void replenishment() throws FileNotFoundException {
        System.out.println("How mach do you what to replenish?");
        int plus = scanner.nextInt();
        cash += plus;
        save();
    }

    private void takeOff() throws FileNotFoundException {
        boolean g = false;

        System.out.println("How mach do you want to remove?");
        int minus = scanner.nextInt();
        if (cash >= minus) {
            int temp = minus;
            while (!g) {

                int denomination20 = 20;
                int denomination50 = 50;
                int denomination100 = 100;
                if (temp >= denomination100) {
                    temp -= denomination100;
                    denomination100number++;
                } else if (temp >= denomination50) {
                    temp -= denomination50;
                    denomination50number++;
                } else if (temp >= denomination20) {
                    temp -= denomination20;
                    denomination20number++;
                }

                if (temp < 0) {
                    System.out.println("Inappropriate amount");
                }

                if (temp == 0) {
                    g = true;
                    System.out.println("20 : " + denomination20number + "\n" + " 50 : " + denomination50number + "\n" + " 100 : " + denomination100number);
                    System.out.println("The operation was successful");
                }
            }
        } else {
            System.out.println("Lack of funds");
        }

        cash -= minus;

        save();
    }

    /**
     * Instantiates a new Atm.
     *
     * @param denomination20number  the bill 20 number
     * @param denomination50number  the bill 50 number
     * @param denomination100number the bill 100 number
     */
    ATM(int denomination20number, int denomination50number, int denomination100number) {
        this.denomination20number = denomination20number;
        this.denomination50number = denomination50number;
        this.denomination100number = denomination100number;
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

    /**
     * Menu.
     *
     * @throws FileNotFoundException the file not found exception
     */
    void menu() throws FileNotFoundException {
        start();
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
                takeOff();
                break;
            case 4:
                security.changePassword();
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
            security.security();
        }
    }
}