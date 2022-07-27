package com.HT.crud.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.HT.crud.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

	@Query( value = "SELECT * FROM Employee u WHERE u.eid =:eid", 
			  nativeQuery = true)
	public Employee findEmployeeById(@Param("eid")int id);
}
