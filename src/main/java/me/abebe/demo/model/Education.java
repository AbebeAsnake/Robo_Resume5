package me.abebe.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @Size(min=3)
    private String collegeName;
    @NotNull
    @Size(min=3)
    private String educationLevel;
    @NotNull
    @Size(min=3)
    private String graduationDate;
    @NotNull
    @Size(min=3)
    private String fieldOfStudy;

    public long getId() {
        return id;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }
}
