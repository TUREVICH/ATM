package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadWrite implements Persistable {

    @Override
    public int getCash() throws FileNotFoundException {
        File file = new File("Cash");
        Scanner scanner = new Scanner(file);
        int cash = scanner.nextInt();
        scanner.close();
        return cash;
    }

    @Override
    public void save(int cash) throws FileNotFoundException {
        File file = new File("Cash");
        PrintWriter pw = new PrintWriter(file);
        pw.println(cash);
        pw.close();
    }
}
