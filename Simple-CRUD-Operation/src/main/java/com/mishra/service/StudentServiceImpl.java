package com.mishra.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mishra.entities.Student;
import com.mishra.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
@Autowired	
private StudentRepository studentRepository;
	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student findStudent(String rno) {
		Optional<Student> containerObject=studentRepository.findById(rno);
		if(containerObject.isPresent()) {
			return containerObject.get();
		}else {
			return null;
		}
	}

}
