package com.project.dailypgt.model;

import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "SleepEntry")
public class SleepEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
   // @JoinColumn(name = "SleepTrack_id")
    private SleepTracker sleepTracker;

    private LocalDateTime starTime;
    private LocalDateTime endTime;

    @Transient
    private Duration duration;

    public SleepEntry() {
    }

    public SleepEntry(SleepTracker sleepTracker, LocalDateTime starTime, LocalDateTime endTime) {
        this.sleepTracker = sleepTracker;
        this.starTime = starTime;
        this.endTime = endTime;
        this.duration = calculateDuration();
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    private Duration calculateDuration() {
        if (starTime != null && endTime != null) {
            return Duration.between(starTime, endTime);
        } else {
            return null;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SleepTracker getSleepTracker() {
        return sleepTracker;
    }

    public void setSleepTracker(SleepTracker sleepTracker) {
        this.sleepTracker = sleepTracker;
    }

    public LocalDateTime getStarTime() {
        return starTime;
    }

    public void setStarTime(LocalDateTime starTime) {
        this.starTime = starTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
