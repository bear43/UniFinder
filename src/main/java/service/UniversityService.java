package service;

import model.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UniversityRepository;

@Service
public class UniversityService
{
    private final UniversityRepository universityRepository;

    @Autowired
    public UniversityService(UniversityRepository universityRepository)
    {
        this.universityRepository = universityRepository;
    }

    public void createUniversity(University university)
    {
        universityRepository.saveAndFlush(university);
    }

    public void deleteUniversity(University university)
    {
        universityRepository.delete(university);
    }

    public UniversityRepository getUniversityRepository()
    {
        return universityRepository;
    }
}
