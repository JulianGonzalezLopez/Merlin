/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.user;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    
    @PostMapping("/")
    public ResponseEntity<String> create(
    @RequestBody User user) throws SQLException  {
        userService.create(user);
        
        return ResponseEntity
                .status(201)
                .build();
    }
    
    @DeleteMapping("/")
    public ResponseEntity<String> delete(
    @RequestBody int user_id) throws SQLException {
        userService.delete(user_id);
        
        return ResponseEntity
                .status(200)
                .build();
    }
}
