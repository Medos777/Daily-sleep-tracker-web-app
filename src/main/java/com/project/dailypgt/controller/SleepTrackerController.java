package com.project.dailypgt.controller;

import com.project.dailypgt.model.SleepTracker;
import com.project.dailypgt.service.SleepTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class SleepTrackerController {
    @Autowired
    private SleepTrackerService sleepTrackerService;

    @PostMapping("/tracker/{userId}")
    public SleepTracker create(@Validated @RequestBody SleepTracker sleepTracker, @PathVariable(value = "userId") long userId){
return sleepTrackerService.create(sleepTracker , userId);

    }

    @GetMapping("/tracker/{user_id}")
    public SleepTracker findByUser(@PathVariable(value = "user_id") long user_id){
        return sleepTrackerService.findByUserId(user_id);
    }

    @GetMapping("/tracker")
    public List<SleepTracker> findAllSleepTracker(){
        return sleepTrackerService.findAllSleepTracker();
    }

    @DeleteMapping("/tracker/{sleep_id}")
    public void deleteById(@PathVariable(value = "sleep_id") long sleep_id){
        sleepTrackerService.deleteSleepTrackerById(sleep_id);
    }
    @DeleteMapping("/tracker")
    public void deleteAll(){
        sleepTrackerService.deleteAllSleepTracker();
    }
    @PutMapping("/tracker/{sleep_id}")
    public SleepTracker update(@Validated @RequestBody SleepTracker sleepTracke ,@PathVariable(value = "sleep_id") long sleep_id){
        return sleepTrackerService.update(sleepTracke ,sleep_id);
    }
}
