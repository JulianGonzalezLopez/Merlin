/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.table;

import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author julian.gonzalez
 */
@Service
public class TableService implements TableServiceInterface {
    
    private final TableRepositoryInterface tableRepository;
    
    @Autowired
    public TableService(TableRepository tableRepository){
        this.tableRepository = tableRepository;
    }
    
    @Override
    public ArrayList<String> getAll() throws SQLException {
        return tableRepository.getAll();
    }
    
    @Override
    public void createTable(String name){
        tableRepository.createTable(name);
    }
    
    @Override
    public void deleteTable(String name){
        tableRepository.deleteTable(name);
    }
    
}
