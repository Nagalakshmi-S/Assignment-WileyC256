package com.nagalakshmi.persistence;

import java.util.Set;

import com.nagalakshmi.bean.Project;

public interface ProjectDao {

	boolean addProject(Project project);
	boolean deleteProject(int projectId);
	Project searchProject(int projectId);
	Set<Project> getAllProjects();
	
}
