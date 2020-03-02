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
    private Security security = new Security();
    private int cash;
    final private int denomination20 = 20;
    final private int denomination50 = 50;
    final private int denomination100 = 100;
    private int denomination20number;
    private int denomination50number;
    private int denomination100number;


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

    private void takeOff() throws FileNotFoundException {

        boolean g = false;

        Scanner scanner = new Scanner(System.in);
        System.out.println("How mach do you want to remove?");
        int minus = scanner.nextInt();
        if (cash >= minus) {
            int temp = minus;
            while (!g) {

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
     * @param bill20number  the bill 20 number
     * @param bill50number  the bill 50 number
     * @param bill100number the bill 100 number
     */
    ATM(int bill20number, int bill50number, int bill100number) {
        this.denomination20number = bill20number;
        this.denomination50number = bill50number;
        this.denomination100number = bill100number;
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