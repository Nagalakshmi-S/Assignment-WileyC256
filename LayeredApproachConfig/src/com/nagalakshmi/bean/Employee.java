package com.nagalakshmi.bean;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Employee {

	private int empId;
	private String empName;
	private String empDesignation;
	private String empDepartment;
	private double empSalary;
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + "]";
	}
	
}
