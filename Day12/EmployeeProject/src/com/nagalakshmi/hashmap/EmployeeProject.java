package com.nagalakshmi.hashmap;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class EmployeeProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Employee,Project> empProj=new TreeMap<Employee,Project>(new SortEmployeeByYrsOfExp());
		empProj.put(new Employee(101,"AA",3), new Project(1,"A1"));
		empProj.put(new Employee(102,"BB",4), new Project(2,"A2"));
		empProj.put(new Employee(101,"AA",3), new Project(2,"A2"));
		empProj.put(new Employee(103,"CC",2), new Project(3,"A3"));
		
		System.out.println(empProj);
		System.out.println();
		Set<Employee> emp=empProj.keySet();
		for(Employee e:emp) {
			System.out.println(e+" assigned to "+empProj.get(e));
		}
		System.out.println();
	
		
	}

}
