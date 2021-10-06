package com.example.ecommerceApp.service;

import com.example.ecommerceApp.dao.StudentRepository;
import com.example.ecommerceApp.mongoEntity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student) {
        studentRepository.insert(student);
    }

    public void updateStudent(Student student) {
        Student savedExpense = studentRepository.findById(student.getId()).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense by ID %s", student.getId())));
        savedExpense.setFirstName(student.getFirstName());
        savedExpense.setLastName(student.getLastName());

        studentRepository.save(savedExpense);
    }

    public Student getStudent(String name) {
        return studentRepository.findByFirstName(name)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find Student by Name - %s", name)));
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }
}
