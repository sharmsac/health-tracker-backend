package com.sharmsac.hportal.controller;

import com.sharmsac.hportal.entity.Student;
import com.sharmsac.hportal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        return new ResponseEntity<Student>(service.saveStudent(student), HttpStatus.CREATED);
    }

    @PostMapping("/addStudents")
    public ResponseEntity<List<Student>> addStudents(@RequestBody List<Student> students){
        return new ResponseEntity<List<Student>>(service.saveStudents(students), HttpStatus.CREATED);
    }

    @GetMapping("/getStudents")
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<List<Student>>(service.getStudents(), HttpStatus.OK);
    }

    @GetMapping("/getStudent/{id}")
    public ResponseEntity<Student> getStudentByID(@PathVariable int id){
        return new ResponseEntity<Student>(service.getStudentByID(id), HttpStatus.OK);
    }

    @GetMapping("/getStudent")
    public ResponseEntity<Student> findByFirstnameAndLastnameAndDob(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String dob){
        return new ResponseEntity<Student>(service.findByFirstnameAndLastnameAndDob(firstname, lastname, dob), HttpStatus.OK);
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        return new ResponseEntity<Student>(service.updateStudent(student), HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        return new ResponseEntity<String>(service.deleteStudent(id), HttpStatus.OK);
    }

    @DeleteMapping("/deleteAllStudents")
    public ResponseEntity<String> deleteAllStudents(){
        return new ResponseEntity<String>(service.deleteAllStudents(), HttpStatus.OK);
    }
}
