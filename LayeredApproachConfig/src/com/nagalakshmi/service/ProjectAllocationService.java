package com.nagalakshmi.service;

import java.util.Map;
import java.util.Set;

import com.nagalakshmi.bean.Employee;
import com.nagalakshmi.bean.Project;

public interface ProjectAllocationService {

	Set<Project> getAllProjects();
	Project getProjectById(int projId);
	boolean addNewProject(Project project);
	boolean deleteProject(int projId);
	
	//Set<Employee> getAllEmployees();
	//Employee getEmployeeById(int empId);
	
	Map<Project,Set<Employee>> getAllEmpInProject();
	boolean allocateProject(int empId, int projID);
	boolean deAllocateProject(int empId, int projID);
	boolean shiftToAProject(int empId, int projID);
}
