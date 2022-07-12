package com.nagalakshmi.database;

import java.util.HashSet;
import java.util.Set;

import com.nagalakshmi.bean.Employee;

public class EmployeeDataSource {

	private static Set<Employee> employeeList=new HashSet<Employee>();
	static {
		employeeList.add(new Employee(101, "AAAA", "Associate", "IT", 35000));
		employeeList.add(new Employee(102, "BBBBB", "Executive", "Sales", 15000));
		employeeList.add(new Employee(103, "CCCC", "Manager", "Sales", 95000));
		employeeList.add(new Employee(104, "DDDD", "Sr. Manager", "IT", 175000));
		employeeList.add(new Employee(105, "EEEE", "Asst. Manager", "HR", 190000));
		employeeList.add(new Employee(106, "FFFF", "General Manager", "Admin", 230000));
		employeeList.add(new Employee(107, "GGGG", "Asst. Director", "Admin", 225000));
		employeeList.add(new Employee(108, "HHHH", "Director", "Accounts", 250000));
		employeeList.add(new Employee(109, "IIII", "CFO", "Accounts", 275000));
		employeeList.add(new Employee(110, "JJJJ", "CEO", "IT", 300000));
		employeeList.add(new Employee(111, "KKKK", "Manager", "IT", 200000));
		employeeList.add(new Employee(112, "LLLL", "Sr. Manager", "Sales", 175000));
	}
	public static Set<Employee> getEmployeeList() {
		return employeeList;
	}
	public static void setEmployeeList(Set<Employee> employeeList) {
		EmployeeDataSource.employeeList = employeeList;
	}

	
	
}
