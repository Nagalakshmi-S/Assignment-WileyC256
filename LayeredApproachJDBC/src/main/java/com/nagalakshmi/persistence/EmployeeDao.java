package com.nagalakshmi.persistence;

import java.util.List;

import com.nagalakshmi.bean.Employee;

public interface EmployeeDao {

	int addRecord(Employee employee);
	int deleteRecord(int empId);
	Employee searchRecord(int empId);
	List<Employee> getAllRecords();
	List<Employee> getEmpByDepartment(String empDepartment);
	
}
