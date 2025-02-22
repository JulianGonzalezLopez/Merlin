/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.table;


import org.springframework.stereotype.Repository;
//import com.mysql.jdbc.Driver;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
/**
 *
 * @author julian.gonzalez
 */
@Repository
public class TableRepository implements TableRepositoryInterface {
    
    private Connection conn;
    
    public TableRepository(){
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost/MerlinDB?" + "user=root&password=root");
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    @Override
    public void createTable(String name){
        try{
            /*
            String query = "CREATE TABLE ? (id int AUTO_INCREMENT, title varchar(255), body varchar(255))";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.execute();
            */
            String query = "CREATE TABLE `" + name + "` (id int AUTO_INCREMENT, title varchar(255), body varchar(255), int creator_id, int last_editor_id, PRIMARY KEY(id))";
            Statement statement = conn.createStatement();
            statement.execute(query);
            String query2 = "INSERT INTO MerlinTables(name) values(?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query2);
            preparedStatement.setString(1, name);
            preparedStatement.execute();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    @Override
    public void deleteTable(String name){
        try{
            /*
            String query = "CREATE TABLE ? (id int AUTO_INCREMENT, title varchar(255), body varchar(255))";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.execute();
            */
            String query = "DELETE TABLE `" + name + "`";
            Statement statement = conn.createStatement();
            statement.execute(query);
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }    
    
}
