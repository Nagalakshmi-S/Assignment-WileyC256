package com.nagalakshmi.persistence;

import java.util.Set;

import com.nagalakshmi.bean.Project;
import com.nagalakshmi.database.ProjectDataSource;

public class ProjectDaoImpl implements ProjectDao {

	@Override
	public boolean addProject(Project project) {
		Set<Project> projects=ProjectDataSource.getProjectList();
		projects.add(project);
		ProjectDataSource.setProjectList(projects);
		return true;
	}

	@Override
	public boolean deleteProject(int projectId) {
		if(searchProject(projectId)!=null) {
			Set<Project> projects=ProjectDataSource.getProjectList();
			for(Project p:projects) {
				if(p.getProjectId()==projectId)
					{
					projects.remove(p);
					ProjectDataSource.setProjectList(projects);
					break;
				
			}}
			return true;
		}
		return false;
	}

	@Override
	public Project searchProject(int projectId) {
		Set<Project> projects=ProjectDataSource.getProjectList();
		for(Project p:projects) {
			if(p.getProjectId()==projectId)
				return p;
		}
		return null;
	}

	@Override
	public Set<Project> getAllProjects() {
		
		return ProjectDataSource.getProjectList();
	}

}
