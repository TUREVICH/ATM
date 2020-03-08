package com.company;


import java.io.FileNotFoundException;
import java.util.Scanner;

public class ATM implements Payable {
    private Persistable ReadWritePersistable = new ReadWrite();
    private Scanner scanner = new Scanner(System.in);
    private boolean opportunity;

    @Override
    public void getBalance(int cash) {
        System.out.println("Your balance:" + "\n" + cash + " $");
    }

    @Override
    public void replenishment(int cash) throws FileNotFoundException {
        System.out.println("How mach do you what to replenish?");
        int plus = scanner.nextInt();
        cash += plus;
        ReadWritePersistable.save(cash);
    }

    private boolean checkDenomination(int temp) {

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
            } else if (temp < denomination20) {
                opportunity = false;
                break;
            }
            if (temp == 0) {
                opportunity = true;
            }
        }

        return opportunity;
    }

    @Override
    public void takeOff(int cash) throws FileNotFoundException {

        System.out.println("How mach do you want to remove?");
        int minus = scanner.nextInt();
        if (ReadWritePersistable.getCash() >= minus && minus >= 20) {
            checkDenomination(minus);
            if (opportunity == true) {
                System.out.println("The operation was successful");
            } else {
                System.out.println("Lack of funds");
            }
        } else {
            System.out.println("Lack of funds");
        }

        cash -= minus;
        ReadWritePersistable.save(cash);
    }


     boolean rePlay() {
        System.out.println("Exit ?");
        int rePlay = scanner.nextInt();
        if (rePlay == 1) {
            return false;
        } else{
            return true;
        }
    }
}