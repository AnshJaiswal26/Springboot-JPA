package com.example.Springboot_JPA.Services;

import com.example.Springboot_JPA.Repositories.StudentRepository;
import com.example.Springboot_JPA.TablePrinter.Table;
import com.example.Springboot_JPA.TablePrinter.TableHeader;
import com.example.Springboot_JPA.TablePrinter.TableLiner;
import com.example.Springboot_JPA.askDetails;
import com.example.Springboot_JPA.entites.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class StudentService implements Operations{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void insertData(Student student) {
        System.out.println();
        studentRepository.save(student);
        askDetails.loading();
        System.out.println("Details Inserted");
        System.out.println();
    }

    @Override
    public void deleteData() {
        System.out.println();
        Scanner Sc = new Scanner(System.in);
        int option = -1;
        System.out.println(" -> 1. Remove Details By ID");
        System.out.println(" -> 2. Remove All Data");
        System.out.print("    Choose an Option: ");
        option = Sc.nextInt();
        switch (option){
            case 1:
                studentRepository.deleteById(askDetails.id());
                askDetails.loading();
                System.out.println("Details Deleted");
                break;
            case 2:
                studentRepository.deleteAll();
                askDetails.loading();
                System.out.println("Data Deleted");
                break;
            default:
                System.out.println("Invalid Choice!!");
                break;
        }
        System.out.println();
    }

    @Override
    public void updateData(Student student) {
        System.out.println();
        Optional<Student> std = studentRepository.findById(student.getId());
        if(std.isEmpty()){
            askDetails.loading();
            System.out.println("Details Not Found Invalid ID!");
            return;
        }
        studentRepository.save(student);
        askDetails.loading();
        System.out.println("Details Updated");
        System.out.println();
    }

    @Override
    public void getData() {
        Scanner Sc = new Scanner(System.in);
        int option = -1;
        System.out.println(" -> 1. Find Details By ID");
        System.out.println(" -> 2. Find All Data");
        System.out.print("    Choose an Option: ");
        option = Sc.nextInt();
        switch (option) {
            case 1:
                Optional<Student> std = studentRepository.findById(askDetails.id());
                askDetails.loading();
                if(std.isEmpty()){
                    System.out.println("Details Not Found!");
                    break;
                }
                System.out.println();
                TableHeader.print(8,"id",12, "age",16, "marks",20, "name");
                Table.print(8, std.get().getId(),12, std.get().getAge(),16, std.get().getMarks(),20,std.get().getName());
                TableLiner.print(8,12,16,20);
                System.out.println();
                break;
            case 2:
                List<Student> stdList = studentRepository.findAll();
                askDetails.loading();
                System.out.println();
                TableHeader.print(8,"id",12, "age",16, "marks",20, "name");
                for(Student s: stdList){
                    Table.print(8, s.getId(),12, s.getAge(),16, s.getMarks(),20,s.getName());
                }
                TableLiner.print(8,12,16,20);
                System.out.println();
                break;
            default:
                System.out.println("Invalid Choice!!");
                System.out.println();
                break;
        }

    }
}
