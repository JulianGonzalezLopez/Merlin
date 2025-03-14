/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.service;

import com.JulianGonzalezLopez.Merlin.model.User;
import java.util.ArrayList;

/**
 *
 * @author julian.gonzalez
 */
public interface UserServiceInterface {
    public void create(User user);
    public void delete(int user_id);
    public ArrayList<User> getAll();
    public String verify(User u);
}
