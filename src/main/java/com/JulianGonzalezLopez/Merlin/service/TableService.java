/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.service;

import com.JulianGonzalezLopez.Merlin.repository.TableRepositoryInterface;
import com.JulianGonzalezLopez.Merlin.repository.TableRepository;
import com.JulianGonzalezLopez.Merlin.exceptions.InvalidTableNameException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
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
    public ArrayList<String> getAll(){
        Set<String> forbiddenTables = Set.of("merlinusers", "merlintables", "merlinrelationships", "merlinpermissions");
        return new ArrayList<>(tableRepository.getAll().stream()
            .filter(x -> !forbiddenTables.contains(x.toLowerCase()))
            .collect(Collectors.toList())); 
    }
    
    @Override
    public void createTable(String name){
        if(name.toLowerCase().equals("merlinusers") || name.toLowerCase().equals("merlintables") || name.toLowerCase().equals("merlintablesrelationships") || name.toLowerCase().equals("merlinpermissions")){
            throw new InvalidTableNameException("Invalid table name");
        }
        tableRepository.createTable(name);
    }
    
    @Override
    public void deleteTable(String name){
        if(name.toLowerCase().equals("merlinusers") || name.toLowerCase().equals("merlintables") || name.toLowerCase().equals("merlintablesrelationships") || name.toLowerCase().equals("merlinpermissions")){
            throw new InvalidTableNameException("Invalid table name");
        }        
        tableRepository.deleteTable(name);
    }
    
}
