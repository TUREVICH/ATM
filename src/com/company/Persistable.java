package com.company;

import java.io.FileNotFoundException;

public interface Persistable {
    void save(int cash) throws FileNotFoundException;
    int getCash() throws FileNotFoundException;
}
