package model;

import java.util.List;

public class ConditionJSONList
{
    private Long id;

    private String title;

    private List<ConditionJSON> conditions;

    public ConditionJSONList(Long id, String title, List<ConditionJSON> conditions)
    {
        this.id = id;
        this.title = title;
        this.conditions = conditions;
    }

    protected ConditionJSONList()
    {}

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

    public List<ConditionJSON> getConditions()
    {
        return conditions;
    }

    public void setConditions(List<ConditionJSON> conditions)
    {
        this.conditions = conditions;
    }
}
