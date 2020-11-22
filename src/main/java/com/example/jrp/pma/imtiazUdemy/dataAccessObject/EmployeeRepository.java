package com.example.jrp.pma.imtiazUdemy.dataAccessObject;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.jrp.pma.imtiazUdemy.dto.EmployeeProject;
import com.example.jrp.pma.imtiazUdemy.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
	@Override
	public List<Employee> findAll();
	
	  @Query(nativeQuery = true, value="select e.first_name as firstName, e.last_name lastName , count(pe.employee_idd) projectCount from employee e left join project_employee pe ON pe.employee_idd =e.employee_id group by e.first_name, e.last_name") 
	  public List<EmployeeProject> employeeProjects();
	  
 }
