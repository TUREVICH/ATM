package com.company;


import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        ATM atm = new ATM(0,0,0);
        atm.security();

    }


}