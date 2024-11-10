package org.punkdomus.studentsystem.service;

import org.punkdomus.studentsystem.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);

    List<Student> getAllStudents();
}
