package com.project.dailypgt.service;

import com.project.dailypgt.model.User;
import com.project.dailypgt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public long create(User user){

        return userRepository.save(user).getId();
    }
    public User findById(long id){
        return userRepository.findById(id).get();
    }
}
