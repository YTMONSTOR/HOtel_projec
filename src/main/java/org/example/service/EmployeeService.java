package org.example.service;

import org.example.scaner.Scaner;

public class EmployeeService {
    public static AdminService adminService=new AdminService();
    public void kirish(){
        int select;
        while (true){
            System.out.println("1.Admin\n2.Derictor\n0.Orqaga");
            try{
                select= Scaner.getInt();
                 switch (select){
                     case 1:
                           adminService.login();
                         break;
                     case 2:

                         break;
                     case 0:
                         System.out.println("<<<<<<<");
                         return;
                     default:
                         System.out.println("Qayta urinib kuring");
                         break;
                 }
            }catch (Exception e){
                System.out.println("Matn kiritildi Qayta urinib kuring");
            }

        }
    }
}
