package ua.goit.hibernate.dao.repositories.one_entity_repositories;

import org.hibernate.SessionFactory;
import ua.goit.hibernate.dao.entity.ProjectDao;


public class ProjectRepository extends UniversalRepository<ProjectDao> {

    public ProjectRepository(SessionFactory sessionFactory) {
        super(sessionFactory, ProjectDao.class);
    }
}
