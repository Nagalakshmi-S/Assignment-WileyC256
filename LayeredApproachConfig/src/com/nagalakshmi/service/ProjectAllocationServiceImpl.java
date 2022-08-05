package com.nagalakshmi.service;

import java.util.Map;
import java.util.Set;

import com.nagalakshmi.bean.Employee;
import com.nagalakshmi.bean.Project;
import com.nagalakshmi.persistence.EmployeeInProjectDao;
import com.nagalakshmi.persistence.EmployeeInProjectDaoImpl;
import com.nagalakshmi.persistence.ProjectAllocationDao;
import com.nagalakshmi.persistence.ProjectAllocationDaoImpl;
import com.nagalakshmi.persistence.ProjectDao;
import com.nagalakshmi.persistence.ProjectDaoImpl;

public class ProjectAllocationServiceImpl implements ProjectAllocationService {

	ProjectAllocationDao projAllocDao;
	ProjectDao projectDao;
	EmployeeInProjectDao empInProj;
	
	//EmployeeDao employeeDao=new EmployeeDaoImpl();
	 
	public void setProjAllocDao(ProjectAllocationDao projAllocDao) {
		this.projAllocDao = projAllocDao;
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	public void setEmpInProj(EmployeeInProjectDao empInProj) {
		this.empInProj = empInProj;
	}

	@Override
	public Set<Project> getAllProjects() {
		return projectDao.getAllProjects();
	}

	@Override
	public Project getProjectById(int projId) {
		return projectDao.searchProject(projId);
		
	}

	@Override
	public boolean addNewProject(Project project) {
		
		return projectDao.addProject(project);
	}

	@Override
	public boolean deleteProject(int projId) {
		
		return projectDao.deleteProject(projId);
	}

	@Override
	public Map<Project, Set<Employee>> getAllEmpInProject() {
		return empInProj.getAllEmpInProjects();
	}

	@Override
	public boolean allocateProject(int empId, int projID) {
		return projAllocDao.allocateProject(empId, projID);
	}

	@Override
	public boolean deAllocateProject(int empId, int projID) {
		return projAllocDao.deAllocateProject(empId, projID);
	}

	@Override
	public boolean shiftToAProject(int empId, int projID) {
		return projAllocDao.shiftToAProject(empId, projID);
	}

}
