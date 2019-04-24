package model;

import javax.persistence.*;

@Entity
@Table(name = "cond")
public class Condition
{
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Subject subject;

    private int pointsCount;

    @ManyToOne
    private Specialization specialization;

    protected Condition()
    { }

    public Condition(Subject subject, int pointsCount) throws Exception
    {
        this.subject = subject;
        this.pointsCount = pointsCount;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Subject getSubject()
    {
        return subject;
    }

    public void setSubject(Subject subject)
    {
        this.subject = subject;
    }

    public int getPointsCount()
    {
        return pointsCount;
    }

    public void setPointsCount(int pointsCount)
    {
        this.pointsCount = pointsCount;
    }

    @Override
    public String toString()
    {
        return subject.toString() + " " + pointsCount;
    }
}
