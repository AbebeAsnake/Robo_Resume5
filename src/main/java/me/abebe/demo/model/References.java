package me.abebe.demo.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class References {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @Size(min=3,max = 20)
    private String firstName;
    @NotNull
    @Size(min=3, max = 20)
    private String lastName;
    @Email
    private String email;

    public References() {
        this.isShow = false;
    }

    public References(String firstName, String lastName, String email, boolean isShow, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isShow = isShow;
        this.phoneNumber = phoneNumber;
    }


    public boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(boolean show) {
        isShow = show;
    }

    private boolean isShow;
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;


    }

    private String phoneNumber;

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
