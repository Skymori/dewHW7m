package ua.goit.hibernate.dao.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "skills")
public class SkillDao implements Comparable<SkillDao>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "language")
    private String language;

    @Column(name = "level")
    private String level;

    @ManyToMany(fetch = FetchType.EAGER,
            targetEntity = ua.goit.hibernate.dao.entity.DeveloperDao.class)
    @JoinTable(name = "developers_skills",
            joinColumns = @JoinColumn(name = "id_skill"),
            inverseJoinColumns = @JoinColumn(name = "id_developer"))
    private Set<DeveloperDao> developers = new TreeSet<>();

    public Set<DeveloperDao> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<DeveloperDao> developers) {
        this.developers = developers;
    }

    public SkillDao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int idSkill) {
        this.id = idSkill;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return language + " " + level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillDao skillDao = (SkillDao) o;
        return Objects.equals(language, skillDao.language) && Objects.equals(level, skillDao.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(language, level);
    }

    @Override
    public int compareTo(SkillDao skillDao) {
        return Integer.compare(this.getId(), skillDao.getId());
    }
}
