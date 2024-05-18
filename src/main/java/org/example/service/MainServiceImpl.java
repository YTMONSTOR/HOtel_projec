package org.example.service;

import org.example.db.Db;
import org.example.model.User;
import org.example.scaner.Scaner;

import java.util.Random;
import java.util.Scanner;

public class MainServiceImpl implements MainService{
     public static  UserServiceImpl userService=new UserServiceImpl();
     public static EmployeeService adminService=new EmployeeService();
     @Override
     public void kirish() {
          int select;
          while (true){
               System.out.println("1.Employeee\n2.User\n0.Orqaga");
               try{
                    select= Scaner.getInt();
                    if (select==0){
                         System.out.println("Bay bay");
                         return;
                    }
                    if (select==1){
                        adminService.kirish();
                    }
                    if (select==2){
                         lol1();
                    }
                    else {
                         System.out.println("Qayta urinib kuring");
                    }
               }catch (Exception e){
                    throw new RuntimeException();
               }

          }
     }

     private void lol1() {
          Scanner scanner=new Scanner(System.in);
          System.out.println("1.Sing Up\n2.Sing In");
          while (true){
               int select=scanner.nextInt();
               switch (select){
                    case 1:
                       Singup();
                    case 2:
                      Singin();
                    }

          }
     }

     private void Singin() {
          UserServiceImpl userService2= new UserServiceImpl();
          userService2.entred();
     }

     private void Singup() {
          Scanner scanner=new Scanner(System.in);
          System.out.println("enter email");
          String lol=scanner.nextLine();
          System.out.println("enter phone number");
          String lol1=scanner.nextLine();
          User user=new User(new Random().nextInt(100),null,10000,lol1,lol,false);
          System.out.println("added");
          Db.userList.add(user);
          lol1();
     }

}
