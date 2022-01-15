package com.mishra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mishra.dao.EmployeeRepo;
import com.mishra.entities.Employee;

@SpringBootApplication
public class JpaImplementationApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(JpaImplementationApplication.class, args);
		EmployeeRepo employeeRepo= context.getBean(EmployeeRepo.class);
		
		Employee employee= new Employee("Narendra", 15000, "Junior ENgineer");
		Employee savedEmployee= employeeRepo.save(employee);
		System.out.println("Saved--"+savedEmployee);
	}

}
