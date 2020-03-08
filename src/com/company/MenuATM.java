package com.company;

import java.io.FileNotFoundException;
import java.util.Scanner;

class MenuATM {
    private Payable atmPayable = new ATM();
    private Persistable ReadWritePersistable = new ReadWrite();
    private Scanner scanner = new Scanner(System.in);


    void menu() throws FileNotFoundException {

        System.out.println("Choose action : " + "\n" + "1. Replenishment" + "\n" + "2. Balance" + "\n" + "3. Take off cash" + "\n" + "0. Exit");
        int option = scanner.nextInt();

            switch (option) {
                case 1:
                    atmPayable.replenishment(ReadWritePersistable.getCash());
                    break;
                case 2:
                    atmPayable.getBalance(ReadWritePersistable.getCash());
                    break;
                case 3:
                    atmPayable.takeOff(ReadWritePersistable.getCash());
                    break;
                case 0:
                    break;
                default:
                    System.out.println("There is no such operation, try again");
                    break;
            }
            ReadWritePersistable.save(ReadWritePersistable.getCash());
    }

//    void rePlay() throws FileNotFoundException {
//        System.out.println("Exit ?");
//        int rePlay = scanner.nextInt();
//        if (rePlay == 1) {
//            menu();
//        } else if (rePlay == 0) {
//            menu = false;
//        }
//    }

}
