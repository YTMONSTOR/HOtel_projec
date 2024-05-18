package org.example.scaner;

import java.util.Scanner;

public class Scaner {
    public static int getInt(){
        Scanner scanner=new Scanner(System.in);
        return scanner.nextInt();
    }
    public static String getString(){
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();
    }
    public static double getDouble(){
        Scanner scanner=new Scanner(System.in);
        return scanner.nextDouble();
    }

}
