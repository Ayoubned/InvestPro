package com.example.investpro.Controller;

import com.example.investpro.Module.Project;
import com.example.investpro.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("{id}")
    public Project getProjectById(@PathVariable long id) {
        return projectService.getProjectById(id);
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.saveProject(project);
    }

    @DeleteMapping("{recipeId}")
    public String deleteProject(@PathVariable long recipeId) {
        projectService.deleteProject(recipeId);
        return "Project deleted";
    }

    @PutMapping("{id}")
    public Project updateProject(@RequestBody Project project,@PathVariable long id) {
        return projectService.updateProject(id, project);
    }
}
