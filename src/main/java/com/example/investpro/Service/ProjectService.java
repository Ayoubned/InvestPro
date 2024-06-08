package com.example.investpro.Service;

import com.example.investpro.Module.Project;
import com.example.investpro.Repository.ProjectRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
    public Project getProjectById(long id) {
        Optional<Project> opt=projectRepository.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        }
        throw new ServiceException("Project not found");
    }
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }
    public void deleteProject(long id) {
        projectRepository.deleteById(id);
    }
    public Project updateProject(long id, Project project) {
        Project oldproject = getProjectById(id);
        if(project.getName()!=null){
            oldproject.setName(project.getName());
        }
        if(project.getDescription()!=null){
            oldproject.setDescription(project.getDescription());
        }
        return projectRepository.save(oldproject);
    }
}
