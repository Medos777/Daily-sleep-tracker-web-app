package com.project.dailypgt.repository;

import com.project.dailypgt.model.SleepTracker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SleepTrackerRepository extends JpaRepository<SleepTracker, Long> {

     SleepTracker findTopByUserId(Long user_id);
}
