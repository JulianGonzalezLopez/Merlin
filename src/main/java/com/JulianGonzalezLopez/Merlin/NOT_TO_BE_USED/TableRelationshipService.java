/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.NOT_TO_BE_USED;

import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Julian
 */

@Service
public class TableRelationshipService implements TableRelationshipServiceInterface {
    
    private final TableRelationshipRepositoryInterface tableRelationshipRepository;
    
    @Autowired
    public TableRelationshipService(TableRelationshipRepositoryInterface tableRelationshipRepository){        
        this.tableRelationshipRepository = tableRelationshipRepository;
    }
    
    @Override
    public ArrayList<TableRelationship> getAll(){
        return tableRelationshipRepository.getAll();
    }
    
    @Override
    public void create(TableRelationship tableRelationship){
        tableRelationshipRepository.create(tableRelationship);
    }
    
    @Override
    public void delete(TableRelationship tableRelationship){
        tableRelationshipRepository.delete(tableRelationship);
    }
}
