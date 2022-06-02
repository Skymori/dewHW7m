package ua.goit.hibernate.dao.repositories.one_entity_repositories;

import org.hibernate.SessionFactory;
import ua.goit.hibernate.dao.entity.SkillDao;


public class SkillRepository extends UniversalRepository<SkillDao> {

    public SkillRepository(SessionFactory sessionFactory) {
        super(sessionFactory, SkillDao.class);
    }
}
