package me.abebe.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class DesiredSkills {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long skillId;
    @NotNull
    @Size(min=2, max=20)
    private String skill;

    private int proficiency;
    private long personId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobId")
    private Jobs job;

    public long getSkillId() {
        return skillId;
    }
    public void setSkillId(long skillId) {
        this.skillId = skillId;
    }
    public String getSkill() {
        return skill;
    }
    public void setSkill(String skill) {
        this.skill = skill;
    }
    public int getProficiency() {
        return proficiency;
    }
    public void setProficiency(int proficiency) {
        this.proficiency = proficiency;
    }
    public long getPersonId() {
        return personId;
    }
    public void setPersonId(long personId) {
        this.personId = personId;
    }
    public Jobs getJob() {
        return job;
    }
    public void setJob(Jobs job) {
        this.job = job;
    }



}