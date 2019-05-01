package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @OneToMany(mappedBy = "specialization", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference
    private Set<Condition> conditions = new HashSet<>();

    @ManyToOne
    @JsonBackReference
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

    public void updateConditionsFromJSON(ConditionJSONList list)
    {
        conditions.clear();

    }

    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof Specialization && ((Specialization) obj).title.equals(this.title);
    }

    @Override
    public int hashCode()
    {
        return id.intValue();
    }

    @Override
    public String toString()
    {
        return title;
    }
}
