package me.abebe.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ApplicantSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long appSkillId;

    public ApplicantSkill() {
    }

    private String rating;
    private String personId;
    private String skills;

    public ApplicantSkill(String rating, String personId, String skills) {
        this.rating = rating;
        this.personId = personId;
        this.skills = skills;
    }

    public long getAppSkillId() {
        return appSkillId;
    }

    public void setAppSkillId(long appSkillId) {
        this.appSkillId = appSkillId;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }



}
