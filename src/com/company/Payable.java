package com.company;

public interface Payable {
    void takeOff(int cash);

    void replenishment(int cash);

    void getBalance(int cash);
}
