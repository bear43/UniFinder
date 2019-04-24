package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Specialization
{
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @OneToMany(mappedBy = "specialization")
    private Set<Condition> conditions;

    @ManyToOne
    private University university;

    protected Specialization()
    {}

    public Specialization(String title, Set<Condition> conditions, University university)
    {
        this.title = title;
        this.conditions = conditions;
        this.university = university;
    }

    public Specialization(String title, University university)
    {
        this(title, new HashSet<>(), university);
    }

    public Specialization(University university)
    {
        this(String.format("Специальность №%d", university.getSpecializations().size()), university);
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Set<Condition> getConditions()
    {
        return conditions;
    }

    public void setConditions(Set<Condition> conditions)
    {
        this.conditions = conditions;
    }

    public University getUniversity()
    {
        return university;
    }

    public void setUniversity(University university)
    {
        this.university = university;
    }

    @Override
    public String toString()
    {
        return title;
    }
}
