package org.example.service;

import org.example.db.Db;
import org.example.model.User;
import org.example.scaner.Scaner;

public class RestoranService {
    public void tanlov(User user) {
        if (user.isBant()) {
            System.out.println("==========Restaranimizga xush kelibsiz=========");
            menyu(user);
        } else {
            System.out.println("Avval xona band qiling");
        }
    }
    private void menyu(User user) {
        int tanlov;
        while (true) {
            for (int i = 0; i < Db.productList.size(); i++) {
                System.out.println(i + 1 + ". " + Db.productList.get(i));
            }
            System.out.println("0.Orqaga");
            try {
                tanlov = Scaner.getInt();
                if (tanlov==0){
                    System.out.println("<<<<<<<<<<<<<<<<<<<<");
                    return;
                }
                if (tanlov >0&&tanlov<Db.productList.size()+1){
                    user.setBalance(user.getBalance()-Db.productList.get(tanlov-1).getPrice());
                    System.out.println("Yoqimli ishtaha");

                }else {
                    System.out.println("Hato menyu tanladingiz");
                }
            } catch (Exception e) {
                System.out.println("Hato menyu tanladingiz");
            }
        }

    }
    }
