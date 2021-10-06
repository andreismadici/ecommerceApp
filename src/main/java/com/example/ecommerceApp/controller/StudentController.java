package com.example.ecommerceApp.controller;

import com.example.ecommerceApp.mongoEntity.Student;
import com.example.ecommerceApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")

public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity addExpense(@RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity updateExpense(@RequestBody Student student) {
        studentService.updateStudent(student);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllExpenses() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{name}")
    public ResponseEntity getStudentByName(@PathVariable String name) {
        return ResponseEntity.ok(studentService.getStudent(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }


}
