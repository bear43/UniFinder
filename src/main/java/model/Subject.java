package model;

import org.hibernate.mapping.Bag;

import javax.persistence.*;
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
    private List<Condition> conditions;

    protected Subject()
    {}

    public Subject(String title)
    {
        this.title = title;
    }



    @Override
    public String toString()
    {
        return title;
    }
}
