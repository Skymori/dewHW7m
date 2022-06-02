package ua.goit.hibernate.dao.repositories.one_entity_repositories;

import org.hibernate.SessionFactory;
import ua.goit.hibernate.dao.entity.CustomerDao;


public class CustomerRepository extends UniversalRepository<CustomerDao> {

    public CustomerRepository(SessionFactory sessionFactory) {
        super(sessionFactory, CustomerDao.class);
    }
}
