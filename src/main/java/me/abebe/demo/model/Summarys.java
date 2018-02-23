package me.abebe.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Summarys {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String summary;

    public Summarys(String summary) {
        this.summary = summary;
    }

    public Summarys() {
    }

    public long getId() {
        return id;

    }


    public void setId(long id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
