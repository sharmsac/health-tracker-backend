package com.sharmsac.hportal.repository;

import com.sharmsac.hportal.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByFirstnameAndLastnameAndDob(String firstname, String lastname, String dob);
}
