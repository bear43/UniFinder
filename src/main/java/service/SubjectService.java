package service;

import model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SubjectRepository;

@Service
public class SubjectService
{
    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository)
    {
        this.subjectRepository = subjectRepository;
    }

    public Subject createNewSubject(String title)
    {
        Subject subj = new Subject(title);
        subjectRepository.saveAndFlush(subj);
        return subj;
    }

    public boolean removeSubject(String title)
    {
        Subject subj = subjectRepository.findByTitle(title);
        if(subj != null)
            subjectRepository.delete(subj);
        return subj != null;
    }
}
