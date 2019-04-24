package service;

import model.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ConditionRepository;

@Service
public class ConditionService
{
    private final ConditionRepository conditionRepository;

    @Autowired
    public ConditionService(ConditionRepository conditionRepository)
    {
        this.conditionRepository = conditionRepository;
    }

    public void createCondition(Condition condition)
    {
        conditionRepository.saveAndFlush(condition);
    }

    public void deleteCondition(Condition condition)
    {
        conditionRepository.delete(condition);
    }

    public ConditionRepository getConditionRepository()
    {
        return conditionRepository;
    }
}
