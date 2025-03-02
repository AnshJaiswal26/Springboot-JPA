package com.example.Springboot_JPA.Services;

import com.example.Springboot_JPA.entites.Student;

public interface Operations {

    void insertData(Student student);
    void deleteData();
    void updateData(Student student);
    void getData();
}
