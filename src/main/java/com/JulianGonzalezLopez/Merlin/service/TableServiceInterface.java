/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.service;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author julian.gonzalez
 */
public interface TableServiceInterface {
    
    public void createTable(String name);
    public void deleteTable(String name);
    public ArrayList<String> getAll();
}
