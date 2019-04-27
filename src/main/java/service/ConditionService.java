package service;

import model.Condition;
import model.ConditionJSON;
import model.ConditionJSONList;
import model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ConditionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConditionService
{
    private final ConditionRepository conditionRepository;

    private final SubjectService subjectService;

    @Autowired
    public ConditionService(ConditionRepository conditionRepository, SubjectService subjectService)
    {
        this.conditionRepository = conditionRepository;
        this.subjectService = subjectService;
    }

    public void createCondition(Condition condition)
    {
        conditionRepository.saveAndFlush(condition);
    }

    public void deleteCondition(Condition condition)
    {
        conditionRepository.delete(condition);
    }

    public Condition fromJSONConditiontoCondition(ConditionJSON conditionJSON) throws Exception
    {
        Subject subject = subjectService.getSubjectRepository().findByTitle(conditionJSON.subject);
        if(subject == null) throw new Exception("No such subject: " + conditionJSON.subject);
        return new Condition(subject, Integer.parseInt(conditionJSON.value));
    }

    public ConditionRepository getConditionRepository()
    {
        return conditionRepository;
    }
}
