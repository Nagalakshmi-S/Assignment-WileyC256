package com.nagalakshmi.persistence;

import com.nagalakshmi.bean.Employee;
import com.nagalakshmi.bean.Project;

public class ProjectAllocationDaoImpl implements ProjectAllocationDao {

	EmployeeDaoImpl empDaoImpl=new EmployeeDaoImpl();
	ProjectDaoImpl projDaoImpl=new ProjectDaoImpl();
	EmployeeInProjectDaoImpl empInProjectDaoImpl=new EmployeeInProjectDaoImpl();
	@Override
	public boolean allocateProject(int empId, int projID) {
		Employee emp=empDaoImpl.searchRecord(empId);
		Project proj=projDaoImpl.searchProject(projID);
		if(emp!=null && proj!=null) {
			return empInProjectDaoImpl.addEmpToProject(proj, emp);
		}
		return false;
	}

	@Override
	public boolean deAllocateProject(int empId, int projID) {
		Employee emp=empDaoImpl.searchRecord(empId);
		Project proj=projDaoImpl.searchProject(projID);
		if(emp!=null && proj!=null) {
			return empInProjectDaoImpl.removeEmpFromProject(proj, emp);
		}
		return false;
	}

	@Override
	public boolean shiftToAProject(int empId, int projID) {
		Employee emp=empDaoImpl.searchRecord(empId);
		Project proj=projDaoImpl.searchProject(projID);
		if(emp!=null && proj!=null) {
			return empInProjectDaoImpl.shiftEmpToDiffProject(proj, emp);
		}
		return false;
	}

}
