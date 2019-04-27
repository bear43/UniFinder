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

    public Subject createNewSubject(String title) throws Exception
    {
        Subject subj = new Subject(title);
        Subject copy = subjectRepository.findByTitle(title);
        if(copy != null) throw new Exception("Subject is already defined");
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

    public SubjectRepository getSubjectRepository()
    {
        return subjectRepository;
    }
}
