package com.sharmsac.hportal.service;

import com.sharmsac.hportal.entity.User;
import com.sharmsac.hportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User addUser(User user){
        return repository.save(user);
    }

    public User authUser(String username, String password){
        return repository.findByUsernameAndPassword(username, password);
    }

    public String deleteUser(int id){
        repository.deleteById(id);
        return "user removed: " + id;
    }
}
