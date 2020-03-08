package com.company;


import java.io.FileNotFoundException;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        MenuATM menuATM = new MenuATM();
        ATM atm = new ATM();
        boolean menu = true;
        while (menu == true) {
        menuATM.menu();
        menu = atm.rePlay();
    }

    }
}
