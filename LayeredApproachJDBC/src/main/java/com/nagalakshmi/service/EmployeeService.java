package com.nagalakshmi.service;

import java.util.List;

import com.nagalakshmi.bean.Employee;
import com.nagalakshmi.bean.EmployeePayslip;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	List<Employee> getEmployeeByDepartment(String department);
	Employee searchEmployeeById(int employeeId);
	EmployeePayslip generatePayslip(int employeeId);
	boolean addEmployee(Employee employee);
}
