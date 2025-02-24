/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.user;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author julian.gonzalez
 */
@Service
public class UserService implements UserServiceInterface {
    UserRepositoryInterface userRepository;
    
    @Autowired
    public UserService(UserRepositoryInterface userRepository){
        this.userRepository = userRepository;
    }
    
    @Override
    public void create(User user) throws SQLException {
        userRepository.create(user);
    }
    
    @Override
    public void delete(int user_id)throws SQLException {
        userRepository.delete(user_id);
    }
}
