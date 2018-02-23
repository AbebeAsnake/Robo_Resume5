package me.abebe.demo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jobId;
    private String jobTitle;
    private String jobDesc;

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    private String organization;

    public String getPostedBy() {
        return postedBy;
    }

    private String postedBy;
    @ManyToMany()
    private Set<DesiredSkills> skill;
    @JoinTable(name = "desired_skill",
            joinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "job_id", referencedColumnName = "id"))

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Set<DesiredSkills> getSkill() {
        return skill;
    }

    public void setSkill(Set<DesiredSkills> skill) {
        this.skill = skill;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public void setOrganization(String organization) {

        this.organization = organization;
    }

    public String getOrganization() {
        return organization;
    }

    public Jobs(String jobTitle, String jobDesc, String organization, String postedBy) {
        this.jobTitle = jobTitle;
        this.jobDesc = jobDesc;
        this.organization = organization;
        this.postedBy = postedBy;


    }

    public Jobs() {
        this.skill = new HashSet<>();
    }



    public String getJobTitle() {
        return jobTitle;
    }

    public long getJobId() {
        return jobId;
    }

    public void setId(long id) {
        this.jobId = jobId;
    }

    public String getJobTittle() {
        return jobTitle;
    }

    public void setJobTittle(String jobTittle) {
        this.jobTitle = jobTittle;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }




}