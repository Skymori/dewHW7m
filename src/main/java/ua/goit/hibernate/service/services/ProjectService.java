package ua.goit.hibernate.service.services;

import ua.goit.hibernate.dao.entity.ProjectDao;
import ua.goit.hibernate.dao.repositories.one_entity_repositories.Repository;
import ua.goit.hibernate.dto.ProjectTo;
import ua.goit.hibernate.service.converters.ProjectConverter;

import java.util.Set;

public class ProjectService {
    private Repository<ProjectDao> projectRepository;

    public ProjectService(Repository<ProjectDao> projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void create(ProjectTo projectTo) {
        projectRepository.create( ProjectConverter.toProjectDao(projectTo));
    }

    public ProjectTo findById(int projectId) {
        return ProjectConverter.fromProjectDao(projectRepository.findById(projectId));
    }

    public void update(ProjectTo projectTo) {

        projectRepository.update(ProjectConverter.toProjectDao(projectTo));
    }

    public void deletedById(int projectId) {
       projectRepository.deleteById(projectId);
    }

    public Set<ProjectTo> findAll() {
        return ProjectConverter.allFromProjectDao(projectRepository.findAll());
    }

}
