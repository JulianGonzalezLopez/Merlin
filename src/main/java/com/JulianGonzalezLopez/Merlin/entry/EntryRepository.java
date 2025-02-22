/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.entry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author julian.gonzalez
 */
@Repository
public class EntryRepository implements EntryRepositoryInterface {
        
    private Connection conn;
    
    public EntryRepository(){
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost/MerlinDB?" + "user=root&password=root");
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    @Override
    public void create(CreateEntryRequest createEntryRequest) throws SQLException {
        String query = "INSERT INTO " + createEntryRequest.getTableName() + " (title, body) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, createEntryRequest.getEntry().getTitle());
            preparedStatement.setString(2, createEntryRequest.getEntry().getBody());
            preparedStatement.executeUpdate();
        }
    }
    @Override
    public void delete(int id, String tableName) throws SQLException {
        String query = "DELETE FROM " + tableName + "WHERE id = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}
 