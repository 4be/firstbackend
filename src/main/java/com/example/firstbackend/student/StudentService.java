package com.example.firstbackend.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents(){
        return List.of(
                new Student(
                        1L,
                        "dan",
                        "Bash@gmail.com",
                        LocalDate.of(2000,01,5),
                        25
                )
        );
    }
}
