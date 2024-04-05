package com.project.dailypgt.controller;

import com.project.dailypgt.model.SleepEntry;
import com.project.dailypgt.service.SleepEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(value = "*")
@RestController
@RequestMapping("/api")
public class SleepEntryController {
    @Autowired
    private SleepEntryService sleepEntryService;

    @PostMapping("/entry/{tracker_id}")
    public SleepEntry create(@Validated @RequestBody SleepEntry sleepEntry, @PathVariable(value = "tracker_id") long tracker_id ) {
        return  sleepEntryService.create(sleepEntry,tracker_id);
    }
    @GetMapping("/entry")
    public List<SleepEntry> getAll(){
        return sleepEntryService.findAll();
    }
    @GetMapping("/entry/{entry_id}")
    public SleepEntry getEntryById(@PathVariable(value = "entry_id") long entry_id){
        return sleepEntryService.findById(entry_id);
    }
}
