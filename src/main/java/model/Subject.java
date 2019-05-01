package model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.mapping.Bag;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "subj")
public class Subject
{
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @OneToMany(mappedBy = "subject")
    @JsonManagedReference
    private List<Condition> conditions = new ArrayList<>();

    protected Subject()
    {}

    public Subject(String title)
    {
        this.title = title;
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

    public List<Condition> getConditions()
    {
        return conditions;
    }

    public void setConditions(List<Condition> conditions)
    {
        this.conditions = conditions;
    }

    @Override
    public String toString()
    {
        return title;
    }
}
