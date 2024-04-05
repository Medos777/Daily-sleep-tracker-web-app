package com.project.dailypgt.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String email;
    private String password;
    private LocalDate dateOfBirth;
    private String gender;
    private double weight;
    private double height;
    @Transient
    private Integer age;
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public Integer getAge() {
        return age;
    }


    public User() {
    }

    public User(String username, String email, String password, LocalDate dateOfBirth, String gender, double weight, double height, Integer age) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.age = calculateAge(dateOfBirth);
    }

    private Integer calculateAge(LocalDate birthDate) {
        if (birthDate != null) {
            LocalDate now = LocalDate.now();
            return Period.between(birthDate, now).getYears();
        } else {
            return null; // Handle the case where birthDate is null
        }
    }


}
