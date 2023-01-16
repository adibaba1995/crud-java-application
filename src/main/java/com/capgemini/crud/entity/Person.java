package com.capgemini.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


import java.util.Date;

@Entity
public class Person {

    @Id
    @NotNull(message = "Personal Number is required")
    @Size(min = 12, max = 12, message = "Invalid Personal number")
    @Pattern(regexp = "^[0-9]*$", message = "Invalid Personal number")
    private String pnumber;

    @NotNull(message = "Full Name is required")
    @Size(min = 2, message = "Full name should be minimum 2 characters")
    private String fullName;

    @Email(message = "Email is not valid")
    private String email;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    public Person() {

    }

    public Person(String pnumber, String fullName, String email, Date dateOfBirth) {
        this.pnumber = pnumber;
        this.fullName = fullName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public String getPnumber() {
        return pnumber;
    }

    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
