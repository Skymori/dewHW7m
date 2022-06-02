package ua.goit.hibernate.service.services;


import ua.goit.hibernate.dao.entity.SkillDao;
import ua.goit.hibernate.dao.repositories.one_entity_repositories.Repository;
import ua.goit.hibernate.dto.SkillTo;
import ua.goit.hibernate.service.converters.SkillConverter;

import java.util.Set;

public class SkillService {
    private Repository<SkillDao> repository;

    public SkillService(Repository<SkillDao> repository) {
        this.repository = repository;
    }

    public void create(SkillTo skillTo) {
        repository.create(SkillConverter.toSkillDao(skillTo));
    }

    public SkillTo findById(int companyId) {
        return SkillConverter.fromSkillDao(repository.findById(companyId));
    }

    public void update(SkillTo SkillTo) {
        repository.update(SkillConverter.toSkillDao(SkillTo));
    }

    public void deleteById(int companyId) {
        repository.deleteById(companyId);
    }

    public Set<SkillTo> findAll() {
        return SkillConverter.allFromSkillDao(repository.findAll());
    }

}
