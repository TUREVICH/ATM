package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ATM implements Persistable, Payable{
    private Scanner scanner = new Scanner(System.in);
    private int cash;
    private boolean opportunity;

    @Override
    public int getCash() throws FileNotFoundException {
        File file = new File("Cash");
        Scanner scanner = new Scanner(file);
        cash = scanner.nextInt();
        scanner.close();
        return cash;
    }

    @Override
    public void getBalance(int cash) {
        System.out.println("Your balance:" + "\n" + cash + " $");
    }

    @Override
    public void save(int cash) throws FileNotFoundException {
        File file = new File("Cash");
        PrintWriter pw = new PrintWriter(file);
        pw.println(cash);
        pw.close();
    }

    @Override
    public void replenishment(int cash) throws FileNotFoundException {
        System.out.println("How mach do you what to replenish?");
        int plus = scanner.nextInt();
        cash += plus;
        save(cash);
    }

    private boolean checkDenomination(int temp){

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
            }else if (temp <= denomination20){
                opportunity = false;
                break;
            }
            if (temp == 0){
                opportunity = true;
            }
        }

        return opportunity;
    }

    @Override
    public void takeOff(int cash) throws FileNotFoundException {

        System.out.println("How mach do you want to remove?");
        int minus = scanner.nextInt();
        if (getCash() >= minus && minus >= 20 ) {
            checkDenomination(minus);
            if (opportunity == true){
                System.out.println("The operation was successful");
            }else {
                System.out.println("Lack of funds");
            }
        } else {
            System.out.println("Lack of funds");
        }

        cash -= minus;
        save(cash);
    }

}

