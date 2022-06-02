package ua.goit.hibernate.dao.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name="customers")
public class CustomerDao implements Comparable<CustomerDao>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="city")
    private String city;

    @ManyToMany(fetch = FetchType.EAGER,
            targetEntity = ua.goit.hibernate.dao.entity.ProjectDao.class)
    @JoinTable(name = "customers_projects",
    joinColumns = @JoinColumn(name = "id_customer"),
    inverseJoinColumns = @JoinColumn(name = "id_project"))
    private Set<ProjectDao> projects = new TreeSet<>();

    public int getId() {
        return id;
    }

    public void setId(int idCustomer) {
        this.id = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<ProjectDao> getProjects() {
        return projects;
    }

    public void setProjects(Set<ProjectDao> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDao that = (CustomerDao) o;
        return Objects.equals(name, that.name) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city);
    }

    @Override
    public int compareTo(CustomerDao customerDao) {
        return Integer.compare(this.getId(), customerDao.getId());
    }
}

