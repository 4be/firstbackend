package com.example.firstbackend.student;

import java.time.LocalDate;
import java.util.List;

public class StudentService {
    public List<Student> getStudents(){
        return List.of(
                new Student(
                        1L,
                        "Ewe",
                        "Bash@gmail.com",
                        LocalDate.of(2000,01,5),
                        25
                )
        );
    }
}
