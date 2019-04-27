package model;

import java.util.List;

public class ConditionJSONList
{
    private String title;

    private List<ConditionJSON> conditions;

    public ConditionJSONList(String title, List<ConditionJSON> conditions)
    {
        this.title = title;
        this.conditions = conditions;
    }

    protected ConditionJSONList()
    {}

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
