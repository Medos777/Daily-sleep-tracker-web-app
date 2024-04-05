package com.project.dailypgt.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sleeptracker")
public class SleepTracker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "sleepTracker", cascade = CascadeType.ALL)
    private List<SleepEntry> sleepEntries;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /*public SleepTracker(long id, long userId) {
        this.id = id;
        this.user = new User(userId,"","","");
    }*/
    public SleepTracker(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        this.user = user;
    }

    public List<SleepEntry> getSleepEntries() {
        return sleepEntries;
    }

    public void setSleepEntries(List<SleepEntry> sleepEntries) {
        this.sleepEntries = sleepEntries;
    }

    public SleepTracker() {
    }
}
