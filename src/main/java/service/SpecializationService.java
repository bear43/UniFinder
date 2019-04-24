package service;

import model.Specialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SpecializationRepository;

@Service
public class SpecializationService
{
    private final SpecializationRepository specializationRepository;

    @Autowired
    public SpecializationService(SpecializationRepository specializationRepository)
    {
        this.specializationRepository = specializationRepository;
    }

    public void createSpecialization(Specialization specialization)
    {
        specializationRepository.saveAndFlush(specialization);
    }

    public void deleteSpecialization(Specialization specialization)
    {
        specializationRepository.saveAndFlush(specialization);
    }

    public SpecializationRepository getSpecializationRepository()
    {
        return specializationRepository;
    }
}
