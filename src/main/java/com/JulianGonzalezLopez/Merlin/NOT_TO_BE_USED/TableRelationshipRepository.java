/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.NOT_TO_BE_USED;

import com.JulianGonzalezLopez.Merlin.DbConnector;
import com.JulianGonzalezLopez.Merlin.exceptions.SQLExceptionWrapper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public ArrayList<TableRelationship> getAll(){
        String query = "SELECT * FROM MerlinTablesRelationships";
        try{
            PreparedStatement preparedStatement = dbConnector.getConn().prepareStatement(query);
            ResultSet resultSet = preparedStatement.getResultSet();
            ArrayList<TableRelationship> resultSetMapped = new ArrayList();
            while(resultSet.next()){
                TableRelationship tr = new TableRelationship();
                tr.setChild_id(resultSet.getInt("child_id"));
                tr.setParent_id(resultSet.getInt("parent_id"));
                resultSetMapped.add(tr);
            }
            return resultSetMapped;
        }
        catch(SQLException e){
            throw new SQLExceptionWrapper(e.getMessage(), "Failed to fetch table relationships");
        }
    }      
    
    @Override
    public void create(TableRelationship tableRelationship){
        String query = "INSERT INTO MerlinTablesRelationships(parent_id, child_id) VALUES (?, ?)";
        try{
            PreparedStatement preparedStatement = dbConnector.getConn().prepareStatement(query);
            preparedStatement.setInt(1, tableRelationship.getParent_id());
            preparedStatement.setInt(2, tableRelationship.getChild_id());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            throw new SQLExceptionWrapper(e.getMessage(), "Failed to create a table relationship");
        }
    }
    
    @Override
    public void delete(TableRelationship tableRelationship){
        String query = "DELETE FROM MerlinTablesRelationships WHERE (parent_id = ?) AND (child_id = ?)";
        try{
            PreparedStatement preparedStatement = dbConnector.getConn().prepareStatement(query);
            preparedStatement.setInt(1, tableRelationship.getParent_id());
            preparedStatement.setInt(2, tableRelationship.getChild_id());
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            throw new SQLExceptionWrapper(e.getMessage(), "Failed to delete a table relationship");
        }
    }
   
}
