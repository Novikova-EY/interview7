package ru.novikova.lesson7.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.novikova.lesson7.models.Student;
import ru.novikova.lesson7.repositories.StudentRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student findById(Long id) {
        Student student = studentRepository.findById(id).get();
        return student;
    }

    public List<Student> showAll() {
        return new ArrayList<>(studentRepository.findAll());
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public Student saveOrUpdate(Student student) {
        Student entity = null;
        if (student.getId() != null) {
            entity = studentRepository.findById(student.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Student with id " + student.getId() + " doesn't exist!"));
        } else {
            entity = studentRepository.save(new Student(student.getName(), student.getAge()));
        }
        return entity;
    }

}
