package com.nagalakshmi.persistence;

import java.util.Map;
import java.util.Set;

import com.nagalakshmi.bean.Employee;
import com.nagalakshmi.bean.Project;

public interface EmployeeInProjectDao {

	Map<Project,Set<Employee>> getAllEmpInProjects();
	boolean addEmpToProject(Project proj,Employee emp);
	boolean removeEmpFromProject(Project proj, Employee emp);
	boolean shiftEmpToDiffProject(Project destProj, Employee emp);
	Set<Employee> getEmployeesInProject(int projId);
	Project getProjAllotedToEmployee(Employee emp);


}
