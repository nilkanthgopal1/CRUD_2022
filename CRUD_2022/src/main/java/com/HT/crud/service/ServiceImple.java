package com.HT.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.HT.crud.dao.EmployeeRepository;
import com.HT.crud.model.Employee;

@org.springframework.stereotype.Service
public class ServiceImple implements Service {

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public Employee createEmployee(Employee emp) {
		// TODO Auto-generated method stub
	
		return repo.save(emp);
	}

	@Override
	public Employee getEmployee(int eid) {
		
		return repo.findEmployeeById(eid);
	}

	@Override
	public List<Employee> listEmployees() {
		// TODO Auto-generated method stub
		//System.out.println(repo.findAll());
		Iterable<Employee> emplist=repo.findAll();
		
		for (Employee employee : emplist) {
			
			System.out.println(employee.toString());
		}
		return (List<Employee>)emplist ;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmployee(Employee emp) {
		// TODO Auto-generated method stub
		repo.delete(emp);
		return true;
	}

}
