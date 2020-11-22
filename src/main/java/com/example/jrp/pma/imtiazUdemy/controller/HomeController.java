package com.example.jrp.pma.imtiazUdemy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.jrp.pma.imtiazUdemy.dataAccessObject.EmployeeRepository;
import com.example.jrp.pma.imtiazUdemy.dataAccessObject.ProjectRepository;
import com.example.jrp.pma.imtiazUdemy.dto.ChartData;
import com.example.jrp.pma.imtiazUdemy.dto.EmployeeProject;
 import com.example.jrp.pma.imtiazUdemy.entities.Project;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeController {

	@Autowired	
	ProjectRepository  prorepo;
	
	@Autowired	
	EmployeeRepository emprepo;
	
	@GetMapping("/")
	public String display(Model model) throws JsonProcessingException
	{
		
		Map<String, Object> map=new HashMap<>();
		
		List<Project> list=prorepo.findAll();
		model.addAttribute("list",list);
		
		
		List<ChartData> list3= prorepo.getProjectStatus();
		ObjectMapper oMapper=new ObjectMapper();
		String jsonString=oMapper.writeValueAsString(list3);
		
		model.addAttribute("convertedJson", jsonString);
		
		List<EmployeeProject> list1=emprepo.employeeProjects();
		model.addAttribute("listEmpProjectsCount",list1);
		
		
		return "main/home";
	}
	@GetMapping("/home")
	public String display1()
	{
		return "main/home";
	}
	
}
