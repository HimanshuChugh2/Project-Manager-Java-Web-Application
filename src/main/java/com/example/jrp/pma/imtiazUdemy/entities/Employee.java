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
  
 
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "employee_seq")
	private long employeeId;
	private String firstName;
	private String lastName;
	private String email;
    
	
	
	/*
	 * @ManyToOne(cascade=
	 * {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
	 * }, fetch=FetchType.LAZY)
	 * 
	 * @JoinColumn(name="project_id") private Project theProject;
	 */
	
	/*
	 * @ManyToMany(cascade=
	 * {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
	 * }, fetch=FetchType.LAZY)
	 */
	
	
	/*
	 * @JoinColumn(name="project_id")
	 */
	
	/*@JoinTable(name = "Project_Employee", joinColumns = @JoinColumn(name="employee_id"),
	inverseJoinColumns =@JoinColumn(name="project_id"))
	*/
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
	   fetch = FetchType.LAZY)
@JoinTable(name="project_employee",
joinColumns=@JoinColumn(name="employee_idd"),
inverseJoinColumns= @JoinColumn(name="project_idd"))
	private List<Project> theProject;
	
	public long getEmployeeId() {
			return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public Employee()
	{}
	
	 

	public List<Project> getTheProject() {
		return theProject;
	}

	public void setTheProject(List<Project> theProject) {
		this.theProject = theProject;
	}

	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	} 
	
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	} 

}
