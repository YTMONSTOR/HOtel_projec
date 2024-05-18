package org.example.service;

import lombok.Data;
import org.example.db.Db;
import org.example.dto.MexmonxonaDto;
import org.example.enums.RoomType;
import org.example.model.User;
import org.example.scaner.Scaner;

import java.util.Random;

public class XonaService {

    public void tanlov(User user){
          int select;
        while (true){
            System.out.println("1.Xona olish\n2.Xona topshirish\n0.orqaga");
            try{
                select=Scaner.getInt();
                if (select==0){
                    System.out.println("<<<<<<<<<");
                    return;
                }
                if (select==1){
                    menu(user);

                }
                if (select==2){
                 topshirish(user);

                }
                else {
                    System.out.println("Qayta urinib kuring");
                }
            }catch (Exception e){
                System.out.println("Qayta urinib kuring");
            }
        }
    }

    public void menu(User user) {
        int select;
        System.out.println("========Xonalar Ruyxati======");
        while (true){
            for (int i = 0; i < Db.roomTypeList.size(); i++) {
                System.out.println(i+1+". "+Db.roomTypeList.get(i));
            }
            System.out.println("0.orqaga");
            try{
                select= Scaner.getInt();
               switch (select){
                   case 1:
                    biznes(user, RoomType.BIZNES);
                       break;
                   case 2:
                   biznes(user,RoomType.LUCS);
                       break;
                   case 3:
                       biznes(user,RoomType.ODDIY);
                       break;
                   case 4:
                       biznes(user,RoomType.STANDART);
                       break;
                   case 0:
                       System.out.println("<<<<<<<<<");
                       return;
                   default:
                       System.out.println("Qayta urinib kuring");
               }
            }catch (Exception e){
                System.out.println("Qayta urinib kuring");
            }

        }
    }

    private void biznes(User user, RoomType roomType) {
        boolean bor=true;
        for (int i = 0; i < Db.roomList.size(); i++) {
            if (Db.roomList.get(i).getRoomType().equals(roomType)
                    &&Db.roomList.get(i).isBor()==false){
                  bor=false;
                  break;
            }
        }
        if (bor){
            System.out.println("Bizda bu xonalar band");
        }
        else {

            for (int i = 0; i < Db.roomList.size(); i++) {
                if (Db.roomList.get(i).getRoomType().equals(roomType)){
                    if (user.getBalance()>=Db.roomList.get(i).getPrice()) {
                        Db.roomList.get(i).setBor(true);
                        user.setBalance(user.getBalance() - Db.roomList.get(i).getPrice());
                        user.setBant(true);
                        MexmonxonaDto mexmonxonaDto=new MexmonxonaDto(new Random().nextInt(100),
                                Db.roomList.get(i).getId()
                                , user.getFullName());
                        Db.mexmonxonaDtoList.add(mexmonxonaDto);
                        System.out.println(Db.mexmonxonaDtoList.size());
                        System.out.println("Marxamat kalitingiz");
                        break;
                    }
                    else {
                        System.out.println("Mablagingiz yetarli emas");
                        break;
                    }
                }
            }
        }
    }


     public void topshirish(User user){
        Integer id=null;
        boolean bor=false;
         for (int i = 0; i < Db.mexmonxonaDtoList.size(); i++) {
             if (Db.mexmonxonaDtoList.get(i).getFullName().equals(user.getFullName())){
                 id=Db.mexmonxonaDtoList.get(i).getXonaId();
                 bor=true;
                 break;
             }
         }
         if (bor&&id!=null){
             for (int i = 0; i < Db.roomList.size(); i++) {
                 if (Db.roomList.get(i).getId().equals(id)){
                     Db.roomList.get(i).setBor(false);
                     user.setBant(false);
                     System.out.println("Xona topshirildi");
                     break;
                 }
             }
         }
         else {
             System.out.println("Siz hona band qilmagansiz");
         }
     }
}
