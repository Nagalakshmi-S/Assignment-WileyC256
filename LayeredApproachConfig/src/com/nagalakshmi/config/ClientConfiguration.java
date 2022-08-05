package com.nagalakshmi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nagalakshmi.persistence.EmployeeDaoImpl;
import com.nagalakshmi.persistence.EmployeeInProjectDaoImpl;
import com.nagalakshmi.persistence.ProjectAllocationDaoImpl;
import com.nagalakshmi.persistence.ProjectDaoImpl;
import com.nagalakshmi.presentation.EmployeePresentationImpl;
import com.nagalakshmi.service.EmployeeServiceImpl;
import com.nagalakshmi.service.ProjectAllocationServiceImpl;

@Configuration
public class ClientConfiguration {
	
	@Bean
	public EmployeeDaoImpl EmpDao() {
		return new EmployeeDaoImpl();
	}
	
	@Bean
	public EmployeeInProjectDaoImpl EmpInProjDao() {
		return new EmployeeInProjectDaoImpl();
		
	}
	
	@Bean
	public ProjectAllocationDaoImpl ProjectAllocDao() {
		return new ProjectAllocationDaoImpl();
	}
	
	@Bean
	public ProjectDaoImpl ProjectDao() {
		return new ProjectDaoImpl();
	}
	
	@Bean
	public EmployeeServiceImpl EmpService() {
		
		EmployeeServiceImpl emp =new EmployeeServiceImpl();
		emp.setEmployeeDao(EmpDao());
		
		return emp;
	}
	
	@Bean
	public ProjectAllocationServiceImpl ProjectService() {
		ProjectAllocationServiceImpl projectAlloc=new ProjectAllocationServiceImpl();
		projectAlloc.setEmpInProj(EmpInProjDao());
		projectAlloc.setProjAllocDao(ProjectAllocDao());
		projectAlloc.setProjectDao(ProjectDao());
		return projectAlloc;
	
	}
	
	@Bean(name="EmpPresentation")
	public EmployeePresentationImpl empPresentation() {
		return new EmployeePresentationImpl(EmpService(),ProjectService());
	}	
	


}
