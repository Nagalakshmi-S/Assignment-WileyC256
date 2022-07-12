package com.nagalakshmi.hashmap;
import java.util.Objects;

import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Employee {

	private int empId;
	private String empName;
	private int yrsOfExp;

	@Override
	public int hashCode() {
		
		return Objects.hash(empId,empName,yrsOfExp);
		
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(obj==null)
			return false;
	    if(getClass()!=obj.getClass())
	    	return false;
	    Employee emp=(Employee) obj;
	    return Objects.equals(empName,emp.empName) && empId==emp.empId 
	    		&& yrsOfExp==emp.yrsOfExp;
	}
}
