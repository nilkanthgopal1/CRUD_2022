package com.HT.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HT.crud.model.Employee;
import com.HT.crud.service.Service;

@RestController
public class MainController {
	
	@Autowired
	private Service serviceImpl;
	
	@PostMapping("/create")
	public Employee createEmployee (@RequestBody Employee emp) {
		
	 	
		return serviceImpl.createEmployee(emp);
	}
	
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee emp) {
		
		int eid1=emp.getEid();
		
		Employee e=serviceImpl.getEmployee(eid1);
		e.setEname(emp.getEname());
		e.setMobile(emp.getMobile());
		
		
		return serviceImpl.createEmployee(e);
	}

	@GetMapping("/getEmployee")
	public Employee getEmployee(@RequestParam int eid) {
		
		
		return serviceImpl.getEmployee(eid);
	}
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(){
		
		System.out.println(serviceImpl.listEmployees());
		return serviceImpl.listEmployees();
	}
	
	@DeleteMapping("/delete")
	public Object deleteEmployee(@RequestParam String ename) {
		
		List<Employee> elist=serviceImpl.listEmployees();
		Employee e1=new Employee();
		for (Employee emp : elist) {
			
			if(emp.getEname().equals(ename)) {
				e1=emp;
			}
		}
		
		return serviceImpl.deleteEmployee(e1);
	}
}
