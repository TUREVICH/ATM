package com.company;

import java.util.Scanner;

public class ATM implements Payable {
    private Persistable readWritePersistable = new ReadWrite();
    private Scanner scanner = new Scanner(System.in);
    private boolean opportunity;

    @Override
    public void getBalance(int cash) {
        System.out.println("Your balance:" + "\n" + cash + " $");
    }

    @Override
    public void replenishment(int cash) {
        System.out.println("How mach do you what to replenish?");
        int plus = scanner.nextInt();
        cash += plus;
        readWritePersistable.save(cash);
        System.out.println("The operation was successful");
    }

    private void checkDenomination(int temp) {

        int denomination20 = 20;
        int denomination50 = 50;
        int denomination100 = 100;

        while (opportunity == false) {
            if (temp >= denomination100) {
                temp -= denomination100;
            } else if (temp >= denomination50) {
                temp -= denomination50;
            } else if (temp >= denomination20) {
                temp -= denomination20;
            } else if (temp > 0 && temp < denomination20) {
                opportunity = false;
                break;
            } else if (temp == 0) {
                opportunity = true;
            }
        }
    }

    @Override
    public void takeOff(int cash) {

        System.out.println("ATM issues denominations of 20 $, 50 $, 100 $" + "\n" + "How mach do you want to remove?");
        int minus = scanner.nextInt();
        if (readWritePersistable.getCash() >= minus && minus >= 20) {
            checkDenomination(minus);
            if (opportunity == true) {
                System.out.println("The operation was successful");
                cash -= minus;
            } else {
                System.out.println("Lack of funds");
            }
        } else {
            System.out.println("Lack of funds");
        }
        readWritePersistable.save(cash);
    }

    boolean rePlay() {
        System.out.println("To exit press 0" + "\n" + "To continue press any key");
        int rePlay = scanner.nextInt();
        if (rePlay == 0) {
            return false;
        } else {
            return true;
        }
    }
}