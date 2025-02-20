/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.table;

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
    
    public void createTable(String name){
        tableRepository.createTable(name);
    }
    
    public void deleteTable(String name){
        tableRepository.deleteTable(name);
    }
    
}
