package ru.novikova.lesson7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.novikova.lesson7.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
