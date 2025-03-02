package com.example.Springboot_JPA.Repositories;

import com.example.Springboot_JPA.entites.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface StudentRepository extends JpaRepository<Student, Long> {
}
