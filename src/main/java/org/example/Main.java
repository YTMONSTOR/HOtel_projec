package org.example;

import org.example.db.Db;
import org.example.service.MainServiceImpl;

public class Main {
    public static MainServiceImpl mainService=new MainServiceImpl();
    public static void main(String[] args) {
        Db.run();
        mainService.kirish();
    }
}