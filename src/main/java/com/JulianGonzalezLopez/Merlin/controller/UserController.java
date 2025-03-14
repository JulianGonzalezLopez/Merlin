/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.controller;

import com.JulianGonzalezLopez.Merlin.model.User;
import com.JulianGonzalezLopez.Merlin.exceptions.InvalidInputValueException;
import com.JulianGonzalezLopez.Merlin.service.UserServiceInterface;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author julian.gonzalez
 */
@RestController
@RequestMapping("/user")
public class UserController {
    
    private final UserServiceInterface userService;
    
    @Autowired
    public UserController(UserServiceInterface userService){
        this.userService = userService;
    }
    
    @GetMapping("/all")
    public ResponseEntity<ArrayList<User>> getAll(){
        ArrayList<User> all = userService.getAll();
        return new ResponseEntity<>(all, null, HttpStatus.ACCEPTED);
    }

    @PostMapping("/")
    public ResponseEntity<String> create(
    @RequestBody User user){  
        
        if(!(user.getUsername() instanceof String) && !(user.getPassword() instanceof String)){
            throw new InvalidInputValueException("username and password must be of type String");
        }
        if(!(user.getUsername() instanceof String)){
            throw new InvalidInputValueException("username must be of type String");
        }
        if(!(user.getPassword() instanceof String)){
            throw new InvalidInputValueException("password must be of type String");
        }
        if(user.getUsername().length() < 1 && user.getPassword().length() < 8){
            throw new InvalidInputValueException("username must be at least 1 character long and password must be at least 8 characters long");
        }
        if(user.getUsername().length() < 1){
            throw new InvalidInputValueException("username must be at least 1 character long");
        }
        if(user.getUsername().length() > 50){
            throw new InvalidInputValueException("username must be less than 50 characters long");
        }
        if(user.getPassword().length() < 8){
            throw new InvalidInputValueException("password must be at least 8 characters long");
        }
        if(user.getPassword().length() > 50){
            throw new InvalidInputValueException("password must be less than 50 characters long");
        }
            
        userService.create(user);
        return new ResponseEntity("CREATED", null, HttpStatus.BAD_REQUEST);
    }
    
    @DeleteMapping("/")
    public ResponseEntity<String> delete(
    @RequestParam int user_id){
        
        if(user_id < 1){
            throw new InvalidInputValueException("user_id can't be 0 or negative");
        }
            
        userService.delete(user_id);
        return new ResponseEntity("DELETED", null, HttpStatus.ACCEPTED);
    }
    
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        System.out.println("OAAA");
        return userService.verify(user);
    }
}
