package com.task.heistback.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name= "heists")
public class Heist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name ="status")
    private String status;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Heist_Member",
            joinColumns = @JoinColumn(name = "heist_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private Set<Member> members;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Heist_Skill",
            joinColumns = @JoinColumn(name = "heist_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> requiredSkills;

    public Heist(){}

    public Heist(Long id, String name, String status, String location, Set<Skill> requiredSkills) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.requiredSkills = requiredSkills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

    public Set<Skill> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(Set<Skill> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }
}
