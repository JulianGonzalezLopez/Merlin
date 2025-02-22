/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.tableRelationship;

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
    
    public void create(TableRelationship tableRelationship){
        
    }
    public void delete(TableRelationship tableRelationship){
        
    }
}
