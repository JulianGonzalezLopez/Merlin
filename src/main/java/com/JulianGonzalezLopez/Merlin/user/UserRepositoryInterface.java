/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.user;

import java.sql.SQLException;

/**
 *
 * @author julian.gonzalez
 */
public interface UserRepositoryInterface {
    
    public void create(User user) throws SQLException ;
    public void delete(int user_id) throws SQLException ;
}
