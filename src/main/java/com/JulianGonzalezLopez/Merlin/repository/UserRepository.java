/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.repository;

import com.JulianGonzalezLopez.Merlin.model.User;
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
    public ArrayList<User> getAll(){
        String query = "SELECT * FROM MerlinUsers";
        try{
            PreparedStatement preparedStatement = dbConnector.getConn().prepareStatement(query);
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
        catch(SQLException e){
            throw new SQLExceptionWrapper(e.getMessage(), "Failed to get all users");
        }
    }     

    @Override
    public ArrayList<User> getAllWithPasswords(){
        String query = "SELECT * FROM MerlinUsers";
        try{
            PreparedStatement preparedStatement = dbConnector.getConn().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet==null) return null;
            ArrayList<User> resultSetMapped = new ArrayList();
            while(resultSet.next()){
                User u = new User();
                u.setUsername(resultSet.getString("username"));
                u.setId(resultSet.getInt("id"));
                u.setPassword(resultSet.getString("password"));
                resultSetMapped.add(u);
            }
            return resultSetMapped;
        }
        catch(SQLException e){
            throw new SQLExceptionWrapper(e.getMessage(), "Failed to get all users");
        }
    }   
    
   @Override
    public User getUserByUsername(String username){
        String query = "SELECT * FROM MerlinUsers WHERE username = ?";
        try{
            PreparedStatement preparedStatement = dbConnector.getConn().prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet==null) return null;
            User u = new User();
            while(resultSet.next()){
                u.setUsername(resultSet.getString("username"));
                u.setId(resultSet.getInt("id"));
                u.setPassword(resultSet.getString("password"));
            }
            return u;
        }
        catch(SQLException e){
            throw new SQLExceptionWrapper(e.getMessage(), "Failed to get all users");
        }
    }      
    
    @Override
    //NO PERMITIR USUARIOS CON EL MISMO USERNAME
    public void create(User user){
        String query = "INSERT INTO MerlinUsers(username, password) VALUES (?, ?)";
        try{
            PreparedStatement preparedStatement = dbConnector.getConn().prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            throw new SQLExceptionWrapper(e.getMessage(), "Failed to create user");
        }
    }
    
    @Override
    //NO PERMITIRA ELIMINAR USUARIOS QUE NO EXISTE O TIRAR ERROR
    public void delete(int user_id){
        String query = "DELETE FROM MerlinUsers WHERE id = ?";
        try{
            PreparedStatement preparedStatement = dbConnector.getConn().prepareStatement(query);
            preparedStatement.setInt(1, user_id);
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            throw new SQLExceptionWrapper(e.getMessage(), "Failed to delete user");
        }
    }
}
