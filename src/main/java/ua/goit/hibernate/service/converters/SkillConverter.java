package ua.goit.hibernate.service.converters;



import ua.goit.hibernate.dao.entity.SkillDao;
import ua.goit.hibernate.dto.SkillTo;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SkillConverter {
    public static SkillDao toSkillDao(SkillTo skillTo) {
        SkillDao skillDao = new SkillDao();
        skillDao.setId(skillTo.getIdSkill());
        skillDao.setLanguage(skillTo.getLanguage());
        skillDao.setLevel(skillTo.getLevel());
        skillDao.setDevelopers(skillTo.getDevelopers());
        return skillDao;
    }

    public static SkillTo fromSkillDao(SkillDao skillDao) {
        SkillTo skillTo = new SkillTo();
        skillTo.setIdSkill(skillDao.getId());
        skillTo.setLanguage(skillDao.getLanguage());
        skillTo.setLevel(skillDao.getLevel());
        skillTo.setDevelopers(skillDao.getDevelopers());
        return skillTo;
    }

    public static Set<SkillTo> allFromSkillDao(Set<SkillDao> skills) {
        return skills.stream()
                .map(SkillConverter::fromSkillDao)
                .collect(Collectors.toCollection(TreeSet::new));
    }
}
