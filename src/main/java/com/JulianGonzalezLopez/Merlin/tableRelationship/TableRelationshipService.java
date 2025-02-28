/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.tableRelationship;

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
    public ArrayList<TableRelationship> getAll() throws SQLException {
        return tableRelationshipRepository.getAll();
    }
    
    @Override
    public void create(TableRelationship tableRelationship) throws SQLException {
        tableRelationshipRepository.create(tableRelationship);
    }
    
    @Override
    public void delete(TableRelationship tableRelationship) throws SQLException {
        tableRelationshipRepository.delete(tableRelationship);
    }
}
