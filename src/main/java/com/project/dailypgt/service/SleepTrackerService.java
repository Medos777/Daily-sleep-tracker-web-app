package com.project.dailypgt.service;


import com.project.dailypgt.model.SleepTracker;
import com.project.dailypgt.model.User;
import com.project.dailypgt.repository.SleepTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SleepTrackerService {
    @Autowired
    private SleepTrackerRepository sleepTrackerRepository;
    @Autowired
    private UserService userService;

    public SleepTracker create(SleepTracker sleepTracker ,long useId )

    {
        /*
        sleepTracker.setUser(new User(useId,null,null,null));
        System.out.println(sleepTracker);
        */

        User user = userService.findById(useId);
        sleepTracker.setUser(user);
        System.out.println(sleepTracker);
    return sleepTrackerRepository.save(sleepTracker);
    }

    public SleepTracker findById(long id){
try {
    return sleepTrackerRepository.findById(id).get();

}catch (Exception e){
    return null;
}
    }
    public SleepTracker findByUserId(long user_id){
        System.out.println("user Id is : "+ user_id);
        return sleepTrackerRepository.findTopByUserId(user_id);

    }
    public List<SleepTracker> findAllSleepTracker(){
        return sleepTrackerRepository.findAll();
    }

    public void deleteSleepTrackerById(long id){
         sleepTrackerRepository.deleteById(id);
        System.out.println("the SleepTracker with Id"+id+ "deleted");
    }

public void deleteAllSleepTracker(){
        sleepTrackerRepository.deleteAll();
    System.out.println("All sleepTracker deleted");
}
public SleepTracker update(SleepTracker sleepTracker, long id){

          SleepTracker s= sleepTrackerRepository.findById(id).get();
         return sleepTrackerRepository.save(sleepTracker);
}


}


