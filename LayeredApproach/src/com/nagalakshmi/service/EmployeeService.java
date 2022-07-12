package com.nagalakshmi.service;

import java.util.Set;

import com.nagalakshmi.bean.Employee;
import com.nagalakshmi.bean.EmployeePayslip;

public interface EmployeeService {

	Set<Employee> getAllEmployees();
	Employee searchEmployeeById(int employeeId);
	boolean addEmployeeDetails(Employee employee);
	boolean deleteEmployeeDetails(int empId);
	EmployeePayslip generatePayslip(int employeeId);
}
