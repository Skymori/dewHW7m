package ua.goit.hibernate.dao.repositories.one_entity_repositories;

import org.hibernate.SessionFactory;
import ua.goit.hibernate.dao.entity.DeveloperDao;

public class DeveloperRepository extends UniversalRepository<DeveloperDao> {
    public DeveloperRepository(SessionFactory sessionFactory) {
        super(sessionFactory, DeveloperDao.class);
    }
}
