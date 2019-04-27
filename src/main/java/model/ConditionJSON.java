package model;

import java.io.Serializable;

public class ConditionJSON implements Serializable
{
    public String subject;
    public String value;

    public ConditionJSON(String subject, String value)
    {
        this.subject = subject;
        this.value = value;
    }

    protected ConditionJSON()
    {}
}
