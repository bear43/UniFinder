package service;

import model.Condition;
import model.Specialization;
import model.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UniversityRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UniversityService
{
    private final UniversityRepository universityRepository;

    private final EntityManager em;

    @Autowired
    public UniversityService(UniversityRepository universityRepository, EntityManager em)
    {
        this.universityRepository = universityRepository;
        this.em = em;
    }

    public boolean doesUniveristyExistsByTitle(String title)
    {
        return universityRepository.findByTitle(title) != null;
    }

    public void createUniversity(University university) throws Exception
    {
        if(doesUniveristyExistsByTitle(university.getTitle()))
            throw new Exception("Server with this name already exists");
        universityRepository.saveAndFlush(university);
    }

    public void addSpecialization(University university, Specialization specialization) throws Exception
    {
        if(university.isThisSpecialization(specialization))
            throw new Exception("Specialization " + specialization.getTitle() + "already exists");
        university.getSpecializations().add(specialization);
    }

    public void deleteUniversity(University university)
    {
        universityRepository.delete(university);
    }

    public void saveAndFlush(University university)
    {
        universityRepository.saveAndFlush(university);
    }

    public UniversityRepository getUniversityRepository()
    {
        return universityRepository;
    }

    public List<University> getUniListBySpecScore(int score)
    {
        Query query = em.createQuery("select uni from University as uni " +
                "inner join Specialization as spec on uni.id = spec.university.id " +
                "inner join Condition as cond on spec.id = cond.specialization.id " +
                "where (select sum(crd.pointsCount) from Condition as crd where crd.specialization.id = cond.specialization.id) <= " + score +
                " group by uni.id");
        List list = query.getResultList();
        return list;
    }
}
