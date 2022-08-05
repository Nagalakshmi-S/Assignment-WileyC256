package com.nagalakshmi.persistence;

import java.util.Map;
import java.util.Set;

import com.nagalakshmi.bean.Employee;
import com.nagalakshmi.bean.Project;
import com.nagalakshmi.database.ProjectEmployeeDataSource;

public class EmployeeInProjectDaoImpl implements EmployeeInProjectDao {

	Map<Project, Set<Employee>> empInProject=ProjectEmployeeDataSource.getEmplInProject();
	@Override
	public Map<Project, Set<Employee>> getAllEmpInProjects() {
		
		return empInProject;
	}

	@Override
	public boolean addEmpToProject(Project proj, Employee emp) {
		Project currentProj=getProjAllotedToEmployee(emp);
		if(currentProj==null) {
			Set<Employee> empSet=empInProject.get(proj);
			if(empSet.size()<10) {
				empSet.add(emp);
				empInProject.put(proj, empSet);
				ProjectEmployeeDataSource.setEmpInAProjMap(empInProject);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removeEmpFromProject(Project proj, Employee emp) {
		Set<Employee> empSet=empInProject.get(proj);
		if(empSet.contains(emp)) {
			empSet.remove(emp);
			empInProject.put(proj,empSet);
			ProjectEmployeeDataSource.setEmpInAProjMap(empInProject);
			return true;
		}
		return false;
	}

	@Override
	public boolean shiftEmpToDiffProject(Project destProj, Employee emp) {
		Project source=getProjAllotedToEmployee(emp);
		if(removeEmpFromProject(source,emp))
		{
			if(addEmpToProject(destProj,emp)) {
				return true;
			}
			else {
				addEmpToProject(source,emp);
				return false;
			}
		}
		return false;
	}

	@Override
	public Set<Employee> getEmployeesInProject(int projId) {
		for(Project proj:empInProject.keySet()) {
			if(proj.getProjectId()==projId) {
				return empInProject.get(proj);
			}
		}
		return null;
	}

	@Override
	public Project getProjAllotedToEmployee(Employee emp) {
		for(Project proj:empInProject.keySet()) {
			if(empInProject.get(proj).contains(emp)) {
				return proj;
			}
		}
		return null;
	}

}
