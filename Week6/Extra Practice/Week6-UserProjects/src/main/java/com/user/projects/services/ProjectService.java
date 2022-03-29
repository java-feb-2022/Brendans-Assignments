package com.user.projects.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.projects.models.Project;
import com.user.projects.models.Rating;
import com.user.projects.models.User;
import com.user.projects.repositories.ProjectRepository;
import com.user.projects.repositories.RatingRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepo;
	
	@Autowired
	private RatingRepository ratingRepo;

	// List all projects
	public List<Project> allProjects() {
		return projectRepo.findAll();
	}
	// Create new project
	public Project createProject(Project project) {
		return projectRepo.save(project);
	}

	// Delete a Project
	public void deleteProject(Long id) {
		projectRepo.deleteById(id);
	}

	// Get One project
	public Project getOneProject(Long id) {
		return projectRepo.findById(id).orElse(null);
	}

	// Update project
	//public Project updateProject(Long id, String name, String description) {
	//	Project project = getOneProject(id);
	//	project.setProjectName(name);
	//	project.setDescription(description);
	//	return projectRepo.save(project);
	
	public Project updateProject(Project project) {
		return projectRepo.save(project);
	}
	
	// Likes
	public void likeProject(Project project, User user) {
		List<User> likers = project.getLikers();
		likers.add(user);
		projectRepo.save(project);
	}
	
	// Unlike
	public void unlikeProject(Project project, User user) {
		List<User> likers = project.getLikers();
		likers.remove(user);
		projectRepo.save(project);
	}
	
	// Rating
	public void createRating(Rating newRating) {
		ratingRepo.save(newRating);
	}
}
