/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.service;

import com.JulianGonzalezLopez.Merlin.repository.UserRepositoryInterface;
import com.JulianGonzalezLopez.Merlin.model.User;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author julian.gonzalez
 */
@Service
public class UserService implements UserServiceInterface {
    
    private final UserRepositoryInterface userRepository;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    
    
    @Autowired
    public UserService(UserRepositoryInterface userRepository, AuthenticationManager authenticationManager, JWTService jwtService){
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }
    
    @Override
    public ArrayList<User> getAll(){
        return userRepository.getAll();
    }

    @Override
    public void create(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.create(user);
    }
    
    @Override
    public void delete(int user_id){
        userRepository.delete(user_id);
    }
    
    @Override
    public String verify(User u){
        Authentication authentication = authenticationManager
                .authenticate( new UsernamePasswordAuthenticationToken(u.getUsername(), u.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(u.getUsername());
        }
        return "fail";
    }

}
