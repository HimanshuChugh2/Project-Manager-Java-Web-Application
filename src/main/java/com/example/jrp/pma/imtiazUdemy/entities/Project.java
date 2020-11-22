package com.example.jrp.pma.imtiazUdemy.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Project {

@Id
@GeneratedValue(strategy=GenerationType.AUTO, generator = "employee_seq")
private long projectId;
private String name;
private String	stage;
private String	description;


	/*
	 * @OneToMany(mappedBy="theProject") private List<Employee> employeees;
	 */


	/*
	 * @ManyToMany(cascade=
	 * {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
	 * }, fetch=FetchType.LAZY) // this will define the join table
	 * 
	 * @JoinTable(name = "Project_Employee", joinColumns
	 * = @JoinColumn(name="project_id"), inverseJoinColumns
	 * =@JoinColumn(name="employee_id") )
	 */



@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
fetch = FetchType.LAZY)
@JoinTable(name="project_employee",
	joinColumns=@JoinColumn(name="project_idd"), 
	inverseJoinColumns= @JoinColumn(name="employee_idd"))
public List<Employee> employeees;

public long getProjectId() {
	return projectId;
}

public void setProjectId(long projectId) {
	this.projectId = projectId;
}

public void setEmployeees(List<Employee> employeees) {
	this.employeees = employeees;
}

public List<Employee> getEmployeees() {
	return employeees;
}

public void setEmployees(List<Employee> employees) {
	this.employeees = employees;
}

public Project()
{}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getStage() {
	return stage;
}
public void setStage(String stage) {
	this.stage = stage;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}  
} 