/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.entry;

import com.JulianGonzalezLopez.Merlin.DbConnector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author julian.gonzalez
 */
@Repository
public class EntryRepository implements EntryRepositoryInterface {
        
    private final DbConnector dbConnector;
    
    @Autowired
    public EntryRepository(DbConnector dbConnector){
        this.dbConnector = dbConnector;
    }
    
    @Override
    public ArrayList<Entry> getAll(String tableName) throws SQLException {
        String query = "SELECT * FROM " + tableName; // No me dejó usar preparedStatements con el nombre de la tabla :/
        
        try (PreparedStatement preparedStatement = dbConnector.getConn().prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery(); 
            ArrayList<Entry> resultSetMapped = new ArrayList<>();
        
            if(resultSet == null){
                return null; //Se retorna null 
            }

            while(resultSet.next()){
                Entry e = new Entry();
                e.setTitle(resultSet.getString("title"));
                e.setBody(resultSet.getString("body"));
                e.setCreator_id(resultSet.getInt("creator_id"));
                e.setLast_editor_id(resultSet.getInt("last_editor_id"));
                resultSetMapped.add(e);
            }
            
            return resultSetMapped;
            
        }        
    }

    @Override
    public void create(CreateEntryRequest createEntryRequest) throws SQLException {
        String query = "INSERT INTO " + createEntryRequest.getTableName() + " (title, body) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = dbConnector.getConn().prepareStatement(query)) {
            preparedStatement.setString(1, createEntryRequest.getEntry().getTitle());
            preparedStatement.setString(2, createEntryRequest.getEntry().getBody());
            preparedStatement.executeUpdate();
        }
    }
    @Override
    public void delete(int id, String tableName) throws SQLException {
        String query = "DELETE FROM " + tableName + " WHERE id = ?";
        try (PreparedStatement preparedStatement = dbConnector.getConn().prepareStatement(query)) {
            System.out.println(preparedStatement.toString());
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement.toString());            
            preparedStatement.executeUpdate();
        }
    }
}
 