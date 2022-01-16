package com.mishra.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mishra.entities.Student;

public interface StudentRepository extends CrudRepository<Student, String>{
	//JPQL/HQL for getting all students 
	@Query("from Student")
	public List<Student> getAllStudent();
	
	@Query("From Student Where name Like :n" )
	public List<Student> getMatchStudent(@Param("n") String match);
	
	@Query("From Student Where address=:city")
	public List<Student> getStudentByCity(@Param("city") String city);
	
	//using native Query language
	@Query(value = "select * from student where name=:name", nativeQuery = true)
	public List<Student> nativeList(@Param("name") String name);
}
