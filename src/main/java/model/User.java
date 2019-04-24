package model;

import repository.UserRepository;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usr")
public class User
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private String password;

    private boolean active;

    private int authority;

    private String firstname;

    private String secondname;

    private String patronymic;

    @OneToOne(cascade = CascadeType.PERSIST)
    private University university;

    protected User()
    {
    }

    public User(String name, String password, boolean active, int authority, String firstname, String secondname, String patronymic, University university)
    {
        this.name = name;
        this.password = password;
        this.active = active;
        this.authority = authority;
        this.firstname = firstname;
        this.secondname = secondname;
        this.patronymic = patronymic;
        this.university = university;
    }

    public User(String name, String password, int authority, String firstname, String secondname, String patronymic)
    {
        this(name, password, true, authority, firstname, secondname, patronymic, null);
    }

    public User(String name, String password, int authority)
    {
        this(name, password, authority, "", "", "");
    }

    public User(User user, UserRepository userRepository)
    {
        regInRepo(user, userRepository);
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public int getAuthority()
    {
        return authority;
    }

    public void setAuthority(int authority)
    {
        this.authority = authority;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getSecondname()
    {
        return secondname;
    }

    public void setSecondname(String secondname)
    {
        this.secondname = secondname;
    }

    public String getPatronymic()
    {
        return patronymic;
    }

    public void setPatronymic(String patronymic)
    {
        this.patronymic = patronymic;
    }

    public static void regInRepo(User user, UserRepository userRepository)
    {
        userRepository.saveAndFlush(user);
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
        return String.format("Имя: %s %s %s", firstname, secondname, patronymic);
    }
}
