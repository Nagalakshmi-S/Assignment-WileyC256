package com.nagalakshmi.database;

import java.util.HashSet;
import java.util.Set;

import com.nagalakshmi.bean.Project;

public class ProjectDataSource {
	private static Set<Project> projectList=new HashSet<Project>();
	static {
		projectList.add(new Project(1,"proj1"));
		projectList.add(new Project(2,"proj2"));
		projectList.add(new Project(3,"proj3"));
		projectList.add(new Project(4,"proj4"));
		projectList.add(new Project(5,"proj5"));
	}
	public static Set<Project> getProjectList() {
		return projectList;
	}
	public static void setProjectList(Set<Project> projectList) {
		ProjectDataSource.projectList = projectList;
	}

}
