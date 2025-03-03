/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.user;

import com.JulianGonzalezLopez.Merlin.DbConnector;
import com.JulianGonzalezLopez.Merlin.tableRelationship.TableRelationship;
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
public class UserRepository implements UserRepositoryInterface {
    
    private final DbConnector dbConnector;
    
    @Autowired
    public UserRepository(DbConnector dbConnector){
        this.dbConnector = dbConnector;
    }
    
    @Override
    public ArrayList<User> getAll() throws SQLException {
        String query = "SELECT * FROM MerlinUsers";
        try (PreparedStatement preparedStatement = dbConnector.getConn().prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet==null) return null;
            ArrayList<User> resultSetMapped = new ArrayList();
            while(resultSet.next()){
                User u = new User();
                u.setUsername(resultSet.getString("username"));
                u.setId(resultSet.getInt("id"));
                resultSetMapped.add(u);
            }
            return resultSetMapped;
        }        
    }     

    @Override
    public void create(User user) throws SQLException {
        String query = "INSERT INTO MerlinUsers(username, password) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = dbConnector.getConn().prepareStatement(query)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
        }
    }
    
    @Override
    public void delete(int user_id) throws SQLException {
        String query = "DELETE FROM MerlinUsers WHERE id = ?";
        try (PreparedStatement preparedStatement = dbConnector.getConn().prepareStatement(query)) {
            preparedStatement.setInt(1, user_id);
            preparedStatement.executeUpdate();
        }
    }
}
