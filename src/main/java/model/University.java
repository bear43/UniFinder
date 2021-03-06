package model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class University
{
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String address;

    private String number;

    private String profile;

    @OneToMany(mappedBy = "university", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JsonManagedReference
    private Set<Specialization> specializations = new HashSet<>();

    protected University()
    {
    }

    public University(String title, String address, String number, String profile, Set<Specialization> specializations)
    {
        this.title = title;
        this.address = address;
        this.number = number;
        this.profile = profile;
        this.specializations = specializations;
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

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getProfile()
    {
        return profile;
    }

    public void setProfile(String profile)
    {
        this.profile = profile;
    }

    public Set<Specialization> getSpecializations()
    {
        return specializations;
    }

    public void setSpecializations(Set<Specialization> specializations)
    {
        this.specializations = specializations;
    }

    public boolean isThisSpecialization(Specialization specialization)
    {
        for(Specialization spec : this.specializations)
        {
            if(spec.equals(specialization)) return true;
        }
        return false;
    }

    public Specialization getSpecializationByTitle(String title)
    {
        for(Specialization spec : specializations)
        {
            if(spec.getTitle().equals(title))
                return spec;
        }
        return null;
    }

    @Override
    public String toString()
    {
        return String.format("Наименование: %s\nАдрес: %s\nТелефон: %s\nПрофиль подготовки: %s",
                title, address, number, profile);
    }
}
