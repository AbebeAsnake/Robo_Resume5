package me.abebe.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class WorkExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String companyName;

    private String startDate;

    private String endDate;

    private String position;

    public String getDuties() {
        return duties;
    }

    public void setDuties(String duties) {
        this.duties = duties;
    }

    private String duties;

    public long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getPosition() {
        return position;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
