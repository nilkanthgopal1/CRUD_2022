package com.HT.crud.service;

import java.util.List;
import java.util.Optional;

import com.HT.crud.model.Employee;

public interface Service {

	public Employee createEmployee(Employee emp);
	public Employee getEmployee(int eid);
	public List<Employee> listEmployees();
	public boolean updateEmployee(Employee emp);
	public boolean deleteEmployee(Employee emp);
}
