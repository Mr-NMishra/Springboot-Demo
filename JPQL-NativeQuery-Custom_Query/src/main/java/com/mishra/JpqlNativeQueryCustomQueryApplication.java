package com.mishra;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mishra.dao.StudentRepository;
import com.mishra.entities.Student;

@SpringBootApplication
public class JpqlNativeQueryCustomQueryApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(JpqlNativeQueryCustomQueryApplication.class, args);
		StudentRepository repository= context.getBean(StudentRepository.class);
		List<Student> allStudent= repository.getAllStudent();
		allStudent.forEach(student->{System.out.println(student);});
		System.out.println("-----------------------------------------------------");
		
		List<Student> matchStudent= repository.getMatchStudent("r%");
		matchStudent.forEach(student->{System.out.println(student);});
		
		System.out.println("-----------------------------------------------------");
		
		List<Student> studentByCity= repository.getStudentByCity("indore");
		studentByCity.forEach(student->{System.out.println(student);});
		

		System.out.println("-----------------------------------------------------");
		
		List<Student> nativeQuery= repository.nativeList("Narendra");
		nativeQuery.forEach(student->{System.out.println(student);});
	}

}
