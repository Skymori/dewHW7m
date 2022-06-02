package ua.goit.hibernate.service.services;



import ua.goit.hibernate.dao.entity.CompanyDao;
import ua.goit.hibernate.dao.repositories.one_entity_repositories.Repository;
import ua.goit.hibernate.dto.CompanyTo;
import ua.goit.hibernate.service.converters.CompanyConverter;

import java.util.Set;

public class CompanyService {
    private Repository<CompanyDao> companyRepository;

    public CompanyService(Repository<CompanyDao> companyRepository) {
        this.companyRepository = companyRepository;
    }

    public void create(CompanyTo companyTo) {
        companyRepository.create(CompanyConverter.toCompanyDao(companyTo));
    }

    public CompanyTo findById(int companyId) {
        return CompanyConverter.fromCompanyDao(companyRepository.findById(companyId));
    }

    public void update(CompanyTo companyTo) {
        companyRepository.update(CompanyConverter.toCompanyDao(companyTo));
    }

    public void deleteById(int companyId) {
        companyRepository.deleteById(companyId);
    }

    public Set<CompanyTo> findAll() {
        return CompanyConverter.allFromCompanyDao(companyRepository.findAll());
    }
}
