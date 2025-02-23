/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.tableRelationship;

import com.JulianGonzalezLopez.Merlin.DbConnector;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Julian
 */
@Repository
public class TableRelationshipRepository implements TableRelationshipRepositoryInterface {
    
    private final DbConnector dbConnector;
    
    @Autowired
    public TableRelationshipRepository(DbConnector dbConnector){
        this.dbConnector = dbConnector;
    }
    
    @Override
    public void create(TableRelationship tableRelationship) throws SQLException {
        String query = "INSERT INTO MerlinTablesRelationships(parent_id, child_id) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = dbConnector.getConn().prepareStatement(query)) {
            preparedStatement.setInt(1, tableRelationship.getParent_id());
            preparedStatement.setInt(2, tableRelationship.getChild_id());
            preparedStatement.executeUpdate();
        }
    }
    
    @Override
    public void delete(TableRelationship tableRelationship) throws SQLException {
        String query = "DELETE FROM MerlinTablesRelationships WHERE (parent_id = ?) AND (child_id = ?)";
        try (PreparedStatement preparedStatement = dbConnector.getConn().prepareStatement(query)) {
            preparedStatement.setInt(1, tableRelationship.getParent_id());
            preparedStatement.setInt(2, tableRelationship.getChild_id());
            preparedStatement.executeUpdate();
        }
    }
   
}
