package com.nagalakshmi.hashmap;

import java.util.Comparator;

public class SortEmployeeByYrsOfExp implements Comparator<Employee> {

	@Override
	public int compare(Employee emp1, Employee emp2) {
		if(emp1.getYrsOfExp()>emp2.getYrsOfExp())
			return 1;
		else if(emp1.getYrsOfExp()<emp2.getYrsOfExp())
			return -1;
		else if(emp1.equals(emp2))
			return 0;
		return 1;
	}

}
