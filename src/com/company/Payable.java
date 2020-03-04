package com.company;

import java.io.FileNotFoundException;

public interface Payable {
    void takeOff(int cash) throws FileNotFoundException;
    void replenishment(int cash) throws FileNotFoundException;
    void getBalance(int cash);
}
