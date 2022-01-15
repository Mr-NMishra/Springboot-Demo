package com.mishra.dao;

import org.springframework.data.repository.CrudRepository;

import com.mishra.entities.Employee;

public interface EmployeeRepo  extends CrudRepository<Employee, Integer>{

}
