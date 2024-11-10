# Save Data

![dog-enforcement-agency-dea.gif](../images/dog-enforcement-agency-dea.gif)

Para salvarmos os dados vamos primeiro criar a interface que conterá os metodos para manipular o banco:
```java
package org.punkdomus.studentsystem.service;

import org.punkdomus.studentsystem.model.Student;
import org.springframework.stereotype.Service;

public interface StudentService {
    public Student saveStudent(Student student);
}
```
Com a interface feita vamos fazer agora a implementação desse service:
```java
package org.punkdomus.studentsystem.service;

import org.punkdomus.studentsystem.model.Student;
import org.punkdomus.studentsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}
```

Com isso podemos criar nosso controller que vai ser responsável por ligar as rotas da API e a implementação do banco:
```java
package org.punkdomus.studentsystem.controller;

import org.punkdomus.studentsystem.model.Student;
import org.punkdomus.studentsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
```

| Annotation           | Significado                                                                                    |
|----------------------|------------------------------------------------------------------------------------------------|
| @RestController      | Serve para definirmos que é um controller do tipo REST e passamos a rota inicial               |
| @Autowired           | Servindo para que o Spring gerencie a criação e a injeção de dependencias                      |
| @PostMapping("/add") | Usado para definir que a rota a ser criada é do metodo POST  e definimos o nome da rota        |
| @Service                  | É usada para que o Spring veja que é uma classe para implementação da lógica de negócio

> A rota que passamos "/add" será colocada após a "/student" que foi definida no `@RequestMapping("/student")`

