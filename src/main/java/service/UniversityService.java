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

    public void deleteUniversity(University university)
    {
        universityRepository.delete(university);
    }

    public UniversityRepository getUniversityRepository()
    {
        return universityRepository;
    }
}
