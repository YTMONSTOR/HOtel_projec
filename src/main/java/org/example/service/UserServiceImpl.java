package org.example.service;

import org.example.db.Db;
import org.example.scaner.Scaner;

import java.util.EventListener;

public class UserServiceImpl {
    public static XonaService xonaService=new XonaService();
    public static RestoranService restoranService=new RestoranService();
    public void entred(){
        int select;
        while (true){
            for (int i = 0; i < Db.userList.size(); i++) {
                System.out.println(i+1+". "+Db.userList.get(i));
            }
            System.out.println("0.orqaga");
            try{
                select= Scaner.getInt();
                if (select==0){
                    System.out.println("<<<<<<");
                    return;
                }
                if (select>0&&select<Db.userList.size()+1){
                    xizmatlar(select-1);
                }
                else {
                    System.out.println("Xato menu tanladingiz");
                }
            }catch (Exception e){
                System.out.println("Matn kiritildi qayta urinib kuring");
            }
        }


    }

    private void xizmatlar(int i) {
        System.out.println("==========Mehmonxonamizga Xush kelibsiz========");
        int select;
        while (true){
            System.out.println("1.Xona xizmatlari\n2.Restoran xizmatlari\n0.orqaga");
            try {
                select=Scaner.getInt();
                switch (select){
                    case 1:
                        xonaService.tanlov(Db.userList.get(i));
                        break;
                    case 2:
                       restoranService.tanlov(Db.userList.get(i));
                        break;
                    default:
                        System.out.println("<<<<<<<<<");
                        return;
                }
            }
            catch (Exception e){
                System.out.println("Qayta urinib kuring");
            }

        }
    }
}
