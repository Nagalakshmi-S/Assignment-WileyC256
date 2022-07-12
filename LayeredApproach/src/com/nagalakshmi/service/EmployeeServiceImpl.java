package com.nagalakshmi.service;

import java.util.Set;

import com.nagalakshmi.bean.Employee;
import com.nagalakshmi.bean.EmployeePayslip;
import com.nagalakshmi.persistence.EmployeeDao;
import com.nagalakshmi.persistence.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao=new EmployeeDaoImpl();
	
	@Override
	public Set<Employee> getAllEmployees() {
		return employeeDao.getAllRecords();
	}

	@Override
	public Employee searchEmployeeById(int employeeId) {
		return employeeDao.searchRecord(employeeId);
	}

	/*
	 * HR= 15% of Basic
	 * DA= 18% of Basic
	 * PF= 12% of Basic
	 */
	@Override
	public EmployeePayslip generatePayslip(int employeeId) {
		Set<Employee> employees=getAllEmployees();
		Employee emp = null;
		for(Employee e:employees) {
			if(e.getEmpId()==employeeId) {
				emp=e;
				break;
			}
		}
		double hr=emp.getEmpSalary()*0.15;
		double da=emp.getEmpSalary()*0.18;
		double pf=emp.getEmpSalary()*0.12;
		double totalSalary=emp.getEmpSalary()+hr+da+pf;
		EmployeePayslip ePayslip=new EmployeePayslip(emp,hr,da,pf,totalSalary);
		
		return ePayslip;
	}

	@Override
	public boolean addEmployeeDetails(Employee employee) {
		
		return employeeDao.addRecord(employee);
	}

	@Override
	public boolean deleteEmployeeDetails(int empId) {
		
		return employeeDao.deleteRecord(empId);
	}

}
