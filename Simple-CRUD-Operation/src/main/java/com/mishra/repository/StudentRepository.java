package com.mishra.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mishra.entities.Student;
@Repository
public interface StudentRepository extends CrudRepository<Student, String>{

}
