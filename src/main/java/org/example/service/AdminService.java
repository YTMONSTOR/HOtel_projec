package org.example.service;

import org.example.db.Db;
import org.example.enums.EmployeeType;
import org.example.model.Employeee;
import org.example.model.Room;
import org.example.scaner.Scaner;

import java.util.Random;

public class AdminService {

    public void login() {
        String email;
        String password;
        Employeee employee=new Employeee();
        while (true){
            boolean bor=false;
            System.out.println("O.orqaga");
            System.out.println("Email Entr???");
            email= Scaner.getString();
            if (email.equals("0")){
                System.out.println("<<<<<<<");
                return;
            }
            System.out.println("Password Entr???");
            password=Scaner.getString();
            for (int i = 0; i < Db.userList.size(); i++) {
                if (Db.userList.get(i).getEmail().equals(email)){
                    for (int j = 0; j < Db.employeeeList.size(); j++) {
                        if (Db.userList.get(i).getId().equals(Db.employeeeList.get(j).getUserId())&&
                        Db.employeeeList.get(j).getEmployeeType().equals(EmployeeType.ADMIN)&&
                        password.equals(Db.employeeeList.get(j).getPassword())){
                            employee=Db.employeeeList.get(j);
                          bor=true;
                          break;
                        }
                    }
                }
                if (bor){
                    adminMenu(employee);
                }
                else {

                }
            }


        }
    }

    private void adminMenu(Employeee employee) {
        System.out.println("===========Admin Paneli=======");
        int select;
        while (true){
            System.out.println("1.Xonalar ruyati\n" +
                    "2.Xona qushish\n" +
                    "3.Xona Uzgartirish\n" +
                    "4.Xonani yopish\n" +
                    "0.Orqaga");
            try {
                select=Scaner.getInt();
                switch (select){
                    case 1:
                        read1(employee);
                        break;
                    case 2:
                        add1(employee);
                        break;
                    case 3:
                        edit(employee);
                        break;
                    case 4:
                        deleted(employee);
                        break;
                    case 0:
                        System.out.println("<<<<<<<");
                        return;
                    default:
                        System.out.println("Qayta urinib kuring");
                        break;
                }
            }catch (Exception e){
                System.out.println("Qayta urinib kuring");
            }

        }
    }

    private void read1(Employeee employee) {
        int select;
        while (true) {
            for (Room room : Db.roomList) {
                System.out.println(room);
            }
            System.out.println("1.davom etirish\n0.orqaga");
            try {
                select=Scaner.getInt();
                if (select==0){
                    System.out.println("<<<<<<");
                    return;
                }
                if (select==1){
                    System.out.println(">>>>>>");

                }
                else {
                    System.out.println("Qayta kiriting");
                }
            }catch (Exception e){
                System.out.println("qayta urinib kurib ");
            }
        }
    }

    private void add1(Employeee employee) {
        System.out.println("Xona raqami");
        String name=Scaner.getString();
        System.out.println("Xona turini tanlang???????");
        for (int i = 0; i < Db.roomTypeList.size(); i++) {
            System.out.println(i+1+". "+Db.roomTypeList.get(i));
        }
        int select=Scaner.getInt();
        System.out.println("Xona narxini kiriting???????>>>>>");
        double price=Scaner.getDouble();
        Room room=new Room(new Random().nextInt(100),name,1,price,Db.roomTypeList.get(select-1),false);
        Db.roomList.add(room);
        System.out.println("ADD ROOM");

    }

    private void edit(Employeee employee) {
        for (int i = 0; i < Db.roomList.size(); i++) {
            System.out.println(i+1+". "+Db.roomList.get(i));
        }
        System.out.println("0.Orqaga");
        int select;
        try {
            select=Scaner.getInt();
            if (select==0){
                System.out.println("<<<<<<<<<<<<<<<<<<<<<<");
                return;
            }if (select>0&&select<Db.roomList.size()+1){
                editprduct(select-1,employee);

            }else {
                System.out.println("qAYTA URUNIB KORING");
            }

        }catch (Exception e){
            System.out.println("Qaytadan urunib koring");
        }
    }

    private void editprduct(int i, Employeee employee) {
        System.out.println("Xona raqami");
        String name=Scaner.getString();
        System.out.println("Xona turini tanlang???????");
        for (int j = 0; j < Db.roomTypeList.size(); j++) {
            System.out.println(j+1+". "+Db.roomTypeList.get(j));
        }
        int select=Scaner.getInt();
        System.out.println("Xona narxini kiriting???????>>>>>");
        double price=Scaner.getDouble();
        Room room = Db.roomList.get(i);
        room.setPrice(price);
        room.setRoomType(Db.roomTypeList.get(select-1));
        room.setName(name);
        System.out.println("edit room");
    }

    private void deleted(Employeee employee) {
        while (true){

        for (int i = 0; i < Db.roomList.size(); i++) {
            System.out.println(i + 1 + ". " + Db.roomList.get(i));

        }
        System.out.println("0. orqaga");
        int selct;
        try {
            selct=Scaner.getInt();
            if (selct==0){
                System.out.println("<<<<<<<<<<<<<<<<<<<<<");
                return;

            }
            if (selct>0&&selct<Db.roomList.size()+1){
                Db.roomList.remove(selct-1);
                System.out.println("room delit");
                return;
            }
            else{
                System.out.println("qayta urinib koring");

            }
        }catch (Exception e) {
            System.out.println("qayta urinib koring");
        }

        }
    }
}
