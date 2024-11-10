# Get Data from Database

Primeiro devemos criar o metodo para recuperar os dados na interface do service do student:

```java
public interface StudentService {
    public Student saveStudent(Student student);

    List<Student> getAllStudents();
}
```

Agora na implementação do service devo criar o metodo:
```java
package org.punkdomus.studentsystem.service;

import org.punkdomus.studentsystem.model.Student;
import org.punkdomus.studentsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
```

Com isso devo usar o metodo do service no controller:

```java
package org.punkdomus.studentsystem.controller;

import org.punkdomus.studentsystem.model.Student;
import org.punkdomus.studentsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String add(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "Student added successfully";
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}
```

| Annotation         | Significado                                                                           |
|--------------------|---------------------------------------------------------------------------------------|
| @GetMapping("/getAll") | Usado para definir que a rota a ser criada é do metodo GET e definimos o nome da rota |
