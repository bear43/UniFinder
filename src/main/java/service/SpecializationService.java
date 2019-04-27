package service;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SpecializationRepository;

import java.util.List;

@Service
public class SpecializationService
{
    private final SpecializationRepository specializationRepository;

    private final ConditionService conditionService;

    @Autowired
    public SpecializationService(SpecializationRepository specializationRepository, ConditionService conditionService)
    {
        this.specializationRepository = specializationRepository;
        this.conditionService = conditionService;
    }

    public void createSpecialization(Specialization specialization)
    {
        specializationRepository.saveAndFlush(specialization);
    }

    public void deleteSpecialization(Specialization specialization)
    {
        specializationRepository.delete(specialization);
    }

    public Specialization createFromJSONSpecializationToSpecialization(String title, List<ConditionJSON> conditions, University university) throws Exception
    {
        Specialization specialization = new Specialization(title, university);
        Condition condition;
        for(ConditionJSON con : conditions)
        {
            condition = conditionService.fromJSONConditiontoCondition(con);
            condition.setSpecialization(specialization);
            specialization.getConditions().add(condition);
        }
        createSpecialization(specialization);
        return specialization;
    }

    public Specialization createFromJSONSpecializationToSpecialization(ConditionJSONList list, University university) throws Exception
    {
        return createFromJSONSpecializationToSpecialization(list.getTitle(), list.getConditions(), university);
    }

    public SpecializationRepository getSpecializationRepository()
    {
        return specializationRepository;
    }
}
