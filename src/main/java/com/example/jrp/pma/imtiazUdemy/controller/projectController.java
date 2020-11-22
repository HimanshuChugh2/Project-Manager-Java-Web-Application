package com.example.jrp.pma.imtiazUdemy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.jrp.pma.imtiazUdemy.dataAccessObject.EmployeeRepository;
import com.example.jrp.pma.imtiazUdemy.dataAccessObject.ProjectRepository;
import com.example.jrp.pma.imtiazUdemy.entities.Employee;
import com.example.jrp.pma.imtiazUdemy.entities.Project;

@Controller
@RequestMapping("/projects")
public class projectController {
	
	@Autowired
	ProjectRepository prorepo;
	
	@Autowired
	EmployeeRepository emprepo;
	
	@GetMapping
	public String displayproject(Model model)
	{
		List<Project> list= prorepo.findAll();
	
		model.addAttribute("proObj", list);
		
		return "project/project-home";	
	}
	
	
	@GetMapping("/new")
	public String displayProjectForms(Model model)
	{
 		Project aProject=new Project();
		List<Employee> employees=emprepo.findAll();

		model.addAttribute("project",aProject);
		model.addAttribute("allEmployees",employees);
		
		return "project/new-project";
	}
	
	 
	
	@PostMapping(value="/save")
	public String projectSave(Project project, Model model/*@RequestParam List<Long> employeees*/)
	{
	prorepo.save(project);
	
		/*
		 * Iterable<Employee> chosenEmp=emprepo.findAllById(employeees);
		 * 
		 * for(Employee emp: chosenEmp) { emp.setTheProject(project); emprepo.save(emp);
		 * }
		 */
	
 	//use a redirect to prevent duplicate submission, so always use redirect after save
	return "redirect:/projects";
	}

}