package com.mishra;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mishra.dao.StudentRepo;
import com.mishra.entities.Student;

@SpringBootApplication
public class CustomQueryApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(CustomQueryApplication.class, args);
		StudentRepo repo= context.getBean(StudentRepo.class);
		//below is JPA defined methods 
		Iterable<Student> iterable= repo.findAll();
		iterable.forEach(student -> System.out.println(student));
		
		System.out.println("-----------------------------------------------------------------");
		//now we are using our custom method to find
		List<Student> studentByAddress= repo.findByAddress("indore");
		studentByAddress.forEach(student-> System.out.println(student));
		
		System.out.println("-----------------------------------------------------------------");
		//getting entites whose name start with R letter 
		List<Student> studentWithR=repo.findByNameLike("r%");
		studentWithR.forEach(student -> System.out.println(student));
		
		System.out.println("-----------------------------------------------------------------");
		//getting entites whose name start with R letter 
		List<Student> studentWithi=repo.findByNameLike("%i");
		studentWithi.forEach(student -> System.out.println(student));
		
		System.out.println("----------------------DOne----------------------");
	}

}
