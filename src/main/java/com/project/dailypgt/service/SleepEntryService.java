package com.project.dailypgt.service;

import com.project.dailypgt.model.SleepEntry;
import com.project.dailypgt.model.SleepTracker;
import com.project.dailypgt.repository.SleepEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SleepEntryService {
    @Autowired
    private SleepEntryRepository sleepEntryRepository;
    @Autowired
    private SleepTrackerService sleepTrackerService;
    public SleepEntry create(SleepEntry sleepEntry, long tracker_id){
        SleepTracker sleepTracker=sleepTrackerService.findById(tracker_id);
        sleepEntry.setSleepTracker(sleepTracker);
        System.out.println(sleepTracker);
        return sleepEntryRepository.save(sleepEntry);
    }
    public List<SleepEntry> findAll(){
        return sleepEntryRepository.findAll();
    }
    public SleepEntry findById(long id){
        return sleepEntryRepository.findById(id).get();
    }
}
