package com.company;

public class Main {

    public static void main(String[] args) {
        MenuATM menuATM = new MenuATM();
        ATM atm = new ATM();
        boolean menu = true;
        while (menu == true) {
            menuATM.menu();
            menu = atm.rePlay();
        }
    }
}
