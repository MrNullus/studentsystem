# Model

Para começar o Model vai servir como intermediario entre nosso banco de dados e o controller (que vai executar as regras de negócio).

Para isso dentro do model `Student` vamos definir que ela é uma entidade com a annotation `@Entity`. 
```java
@Entity
public class Student {}
```

Só que ao definir a entidade precisamos também definir um Id e para isso criamos uma variavel chamda `id` e também para que ela seja vista como um Id precisamos definir uma annotation chamdada `@Id` e podemos também definir como será gerado o valor com a annotation `@GeneratedValue(strategy = GenerationType.IDENTITY)` que nesse caso foi definido como `IDENTIFY`:
```java
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
```
Agora podemos definir os outros atributos e em seguida criarmos o constructor e os getters e setters:

```java
package org.punkdomus.studentsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String address;

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
```
Com o código já criado da model `Student` podemos ir para a outra parte da criação de uma model que é a definição do repository, já que o model só definira o que a entidade vai ter, agora o repository que tera as devidas funções de manipulação do banco:
```java
package org.punkdomus.studentsystem.repository;

import org.punkdomus.studentsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
```