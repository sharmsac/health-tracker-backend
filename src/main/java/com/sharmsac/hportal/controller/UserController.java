package com.sharmsac.hportal.controller;

import com.sharmsac.hportal.entity.User;
import com.sharmsac.hportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return new ResponseEntity<User>(service.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/getUser")
    public ResponseEntity<User> authUser(@RequestParam String username, @RequestParam String password){
        return new ResponseEntity<User>(service.authUser(username, password), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        return new ResponseEntity<String>(service.deleteUser(id), HttpStatus.OK);
    }
}
