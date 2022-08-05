package com.nagalakshmi.persistence;

import java.util.Set;

import com.nagalakshmi.bean.Employee;
import com.nagalakshmi.database.EmployeeDataSource;

public class EmployeeDaoImpl implements EmployeeDao {

	
	@Override
	public boolean addRecord(Employee employee) {
		Set<Employee> employees=EmployeeDataSource.getEmployeeList();
		employees.add(employee);
		EmployeeDataSource.setEmployeeList(employees);
		return true;
	}

	@Override
	public boolean deleteRecord(int empId) {
		if(searchRecord(empId)!=null) {
			Set<Employee> employees=EmployeeDataSource.getEmployeeList();
//			for(Employee e:employees) {
//				if(e.getEmpId()==empId) {
//					employees.remove(e);
//					EmployeeDataSource.setEmployeeList(employees);
//					break;
//				}
//			}
			employees.remove(searchRecord(empId));
			EmployeeDataSource.setEmployeeList(employees);
			return true;
		}
		return false;
	}

	@Override
	public Employee searchRecord(int empId) {
		Set<Employee> employees=EmployeeDataSource.getEmployeeList();
		for(Employee e:employees) {
			if(e.getEmpId()==empId)
				return e;
		}
		return null;
	}

	@Override
	public Set<Employee> getAllRecords() {
		return EmployeeDataSource.getEmployeeList();
	}

}
