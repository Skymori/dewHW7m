package ua.goit.hibernate.service.converters;


import ua.goit.hibernate.dao.entity.DeveloperDao;
import ua.goit.hibernate.dto.DeveloperTo;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class DeveloperConverter {

    public static DeveloperDao toDeveloperDao(DeveloperTo developerTo) {
        DeveloperDao developerDao = new DeveloperDao();
        developerDao.setId(developerTo.getIdDeveloper());
        developerDao.setName(developerTo.getName());
        developerDao.setAge(developerTo.getAge());
        developerDao.setSex(developerTo.getSex());
        developerDao.setSalary(developerTo.getSalary());
        developerDao.setCompany(developerTo.getCompany());
        developerDao.setProjects(developerTo.getProjects());
        developerDao.setSkills(developerTo.getSkills());
        return developerDao;
    }

    public static DeveloperTo fromDeveloperDao(DeveloperDao developerDao) {
        DeveloperTo developerTo = new DeveloperTo();
        developerTo.setIdDeveloper(developerDao.getId());
        developerTo.setName(developerDao.getName());
        developerTo.setAge(developerDao.getAge());
        developerTo.setSex(developerDao.getSex());
        developerTo.setSalary(developerDao.getSalary());
        developerTo.setCompany(developerDao.getCompany());
        developerTo.setProjects(developerDao.getProjects());
        developerTo.setSkills(developerDao.getSkills());
        return developerTo;
    }

    public static Set<DeveloperTo> allFromDeveloperDao(Set<DeveloperDao> developers) {
        return developers.stream()
                .map(DeveloperConverter::fromDeveloperDao)
                .collect(Collectors.toCollection(TreeSet::new));
    }
}
