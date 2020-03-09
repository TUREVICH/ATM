package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadWrite implements Persistable {

    @Override
    public int getCash()  {
        File file = new File("Cash");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("sorry reading error");
        }
        int cash = scanner.nextInt();
        scanner.close();
        return cash;
    }

    @Override
    public void save(int cash)  {
        File file = new File("Cash");
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            System.out.println("sorry reading error");
        }
        pw.println(cash);
        pw.close();
    }
}
