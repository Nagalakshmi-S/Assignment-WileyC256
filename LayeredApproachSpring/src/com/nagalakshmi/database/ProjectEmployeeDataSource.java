package com.nagalakshmi.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.nagalakshmi.bean.Employee;
import com.nagalakshmi.bean.Project;

public class ProjectEmployeeDataSource {

	private static Map<Project,Set<Employee>> projectEmployee=new HashMap<Project,Set<Employee>>();
	
	static Set<Project> proj=ProjectDataSource.getProjectList();
	static List<Project> projectList=new ArrayList<Project>(proj);
	
	
	static Set<Employee> emp=EmployeeDataSource.getEmployeeList();
	static List<Employee> employeeList=new ArrayList<Employee>(emp);
	
	static {
		Set<Employee> emp=new HashSet<Employee>();
		emp.add(employeeList.get(0));
		emp.add(employeeList.get(1));
		projectEmployee.put(projectList.get(0),emp);
		
		emp=new HashSet<Employee>();
		emp.add(employeeList.get(2));
		emp.add(employeeList.get(3));
		projectEmployee.put(projectList.get(1),emp);
		
		emp=new HashSet<Employee>();
		emp.add(employeeList.get(4));
		emp.add(employeeList.get(5));
		emp.add(employeeList.get(6));
		projectEmployee.put(projectList.get(2),emp);
		
		emp=new HashSet<Employee>();
		emp.add(employeeList.get(7));
		emp.add(employeeList.get(8));
		emp.add(employeeList.get(9));
		emp.add(employeeList.get(10));
		emp.add(employeeList.get(11));
		projectEmployee.put(projectList.get(3),emp);
		emp=new HashSet<Employee>();
		projectEmployee.put(projectList.get(4),emp);
		
		
	}
	public static Map<Project, Set<Employee>>  getEmplInProject() {
		return projectEmployee;
	}
	public static void setEmpInAProjMap(Map<Project, Set<Employee>>  projectEmployee) {
		ProjectEmployeeDataSource.projectEmployee=projectEmployee;
	}
	
}
