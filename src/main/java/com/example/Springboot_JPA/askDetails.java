package com.example.Springboot_JPA;

import com.example.Springboot_JPA.entites.Student;

import java.util.Scanner;

public class askDetails {
    static Scanner sc = new Scanner(System.in);

    static Student All(){
        long id = id();
        String name = name();
        int age = age();
        float marks = marks();

        return new Student(name,id,age,marks);
    }

    public static String name(){
        System.out.print("Enter Name: ");
        sc.nextLine();
        String name = sc.nextLine();
        return name;
    }
    public static long id(){
        System.out.print("Enter id: ");
        long id = sc.nextLong();
        return id;
    }
    public static int age(){
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        return age;
    }
    public static float marks(){
        System.out.print("Enter marks: ");
        float marks = sc.nextFloat();
        return marks;
    }

    public static int crud(){
        int option;
        System.out.println("1. Insert Details");
        System.out.println("2. Update Details");
        System.out.println("3. Delete Details");
        System.out.println("4. Get Details");
        System.out.println("To Exit Enter 0");
        System.out.print("Choose an Option: ");
        option = sc.nextInt();

        return option;
    }

    public static void loading(){
        try{
            System.out.print("Performing operation please wait.");
            for(int i=0;i<10;i++){
                Thread.sleep(200);
                System.out.print(".");
            }
            System.out.println();
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

    public static void line(){
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
