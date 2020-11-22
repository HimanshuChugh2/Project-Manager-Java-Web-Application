package com.example.jrp.pma.imtiazUdemy.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.jrp.pma.imtiazUdemy.dataAccessObject.EmployeeRepository;
import com.example.jrp.pma.imtiazUdemy.dataAccessObject.ProjectRepository;
import com.example.jrp.pma.imtiazUdemy.entities.Employee;
import com.example.jrp.pma.imtiazUdemy.entities.Project;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired	
	EmployeeRepository emprepo;
	
	@Autowired
	ProjectRepository prorepo;
	
 	@GetMapping 
	public String displayEmployees(Model model)
	{
		List<Employee> list= emprepo.findAll();
		
		model.addAttribute("empObj", list);
		return "employees/employee-home";
	}
	@GetMapping("/new")
	public String displayEmployeeForms(Model model)
	{	
		Employee anEmployee=new Employee();
		List<Project>  list3= prorepo.findAll();
		model.addAttribute("proObj", list3);

		
		model.addAttribute("employee",anEmployee);
		
		return "employees/new-employee";
	}
	@PostMapping("/save")
	public String insertEmployees(Employee employee)
	{
		emprepo.save(employee);
		return "redirect:/employees/new";
	}
	
	
	
	
	
	
	
}

	
	
	
	
	
	
	
	
	