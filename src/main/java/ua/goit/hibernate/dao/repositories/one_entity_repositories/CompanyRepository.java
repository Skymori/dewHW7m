package ua.goit.hibernate.dao.repositories.one_entity_repositories;

import org.hibernate.SessionFactory;
import ua.goit.hibernate.dao.entity.CompanyDao;


public class CompanyRepository extends UniversalRepository<CompanyDao> {

    public CompanyRepository(SessionFactory sessionFactory) {
        super(sessionFactory, CompanyDao.class);
    }
}
