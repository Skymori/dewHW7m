package ua.goit.hibernate.service.converters;


import ua.goit.hibernate.dao.entity.CustomerDao;
import ua.goit.hibernate.dto.CustomerTo;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CustomerConverter {

    public static CustomerDao toCustomerDao(CustomerTo customerTo) {
        CustomerDao customerDao = new CustomerDao();
        customerDao.setId(customerTo.getIdCustomer());
        customerDao.setName(customerTo.getName());
        customerDao.setCity(customerTo.getCity());
        customerDao.setProjects(customerTo.getProjects());
        return customerDao;
    }

    public static CustomerTo fromCustomerDao(CustomerDao customerDao) {
        CustomerTo customerTo = new CustomerTo();
        customerTo.setIdCustomer(customerDao.getId());
        customerTo.setName(customerDao.getName());
        customerTo.setCity(customerDao.getCity());
        customerTo.setProjects(customerDao.getProjects());
        return customerTo;
    }

    public static Set<CustomerTo> allFromCustomerDao(Set<CustomerDao> customerDaos) {
        return customerDaos.stream()
                .map(CustomerConverter::fromCustomerDao)
                .collect(Collectors.toCollection(TreeSet::new));
    }
}
