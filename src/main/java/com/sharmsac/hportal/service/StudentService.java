package com.sharmsac.hportal.service;

import java.util.List;

import com.sharmsac.hportal.entity.Student;
import com.sharmsac.hportal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student saveStudent(Student student){
        return repository.save(student);
    }

    public List<Student> saveStudents(List<Student> students){
        return repository.saveAll(students);
    }

    public List<Student> getStudents(){
        return repository.findAll();
    }

    public Student getStudentByID(int id){
        return repository.findById(id).orElse(null);
    }

    public Student findByFirstnameAndLastnameAndDob(String firstname, String lastname, String dob){
        return repository.findByFirstnameAndLastnameAndDob(firstname, lastname, dob);
    }

    public String deleteStudent(int id){
        repository.deleteById(id);
        return "student removed: " + id;
    }

    public String deleteAllStudents(){
        repository.deleteAll();
        return "All Students Removed!";
    }

    public Student updateStudent(Student student){
        Student existingStudent = repository.findById(student.getId()).orElse(null);
        existingStudent.setFirstname(student.getFirstname());
        existingStudent.setLastname((student.getLastname()));
        existingStudent.setDob(student.getDob());
        existingStudent.setIsRecordSubmitted(student.getIsRecordSubmitted());
        existingStudent.setIsRecordApproved(student.getIsRecordApproved());
        return repository.save(existingStudent);
    }
}
