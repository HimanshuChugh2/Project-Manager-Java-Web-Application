package com.example.jrp.pma.imtiazUdemy.dataAccessObject;

 import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.jrp.pma.imtiazUdemy.dto.ChartData;
import com.example.jrp.pma.imtiazUdemy.entities.Project;

public interface ProjectRepository extends CrudRepository<Project,Long>{
	@Override
	public List<Project> findAll();
	
	
	  @Query(nativeQuery = true, value = "select stage as label, count(*) as value from project group by stage")
	  public List<ChartData> getProjectStatus();
	 
	
	
}
