/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.service;

import com.JulianGonzalezLopez.Merlin.model.User;
import com.JulianGonzalezLopez.Merlin.model.UserPrincipal;
import com.JulianGonzalezLopez.Merlin.repository.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Julian
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    
    private final UserRepositoryInterface userRepository;
    
    @Autowired
    public MyUserDetailsService(UserRepositoryInterface userRepository){
        this.userRepository = userRepository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userRepository.getUserByUsername(username);
        
        if(u == null){
            throw new UsernameNotFoundException("User not found");
        }
        
        return new UserPrincipal(u);
        
    }  
}
