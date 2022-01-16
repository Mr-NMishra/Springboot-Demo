package com.mishra.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mishra.entities.Student;

public interface StudentRepo extends CrudRepository<Student, String> {

	// here in interface we are creating our own custom methods
	// this method only returns those entites whose address is matching
	// to our parameter
	public List<Student> findByAddress(String address);

	// method whose name starts with letter R and ending with i
	public List<Student> findByNameLike(String letter);
}
