package com.project.dailypgt.repository;

import com.project.dailypgt.model.SleepEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SleepEntryRepository extends JpaRepository<SleepEntry, Long> {
}
