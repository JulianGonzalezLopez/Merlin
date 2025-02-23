/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.table;


import com.JulianGonzalezLopez.Merlin.DbConnector;
import org.springframework.stereotype.Repository;
//import com.mysql.jdbc.Driver;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author julian.gonzalez
 */
@Repository
public class TableRepository implements TableRepositoryInterface {
    
    private final DbConnector dbConnector;
    
    @Autowired
    public TableRepository(DbConnector dbConnector){
        this.dbConnector = dbConnector;
    }
    
    @Override
    public void createTable(String name){
        try{

            String query = "CREATE TABLE `" + name + "` (id int AUTO_INCREMENT, title varchar(255), body varchar(255), int creator_id, int last_editor_id, PRIMARY KEY(id))";
            Statement statement = dbConnector.getConn().createStatement();
            statement.execute(query);
            String query2 = "INSERT INTO MerlinTables(name) values(?)";
            PreparedStatement preparedStatement = dbConnector.getConn().prepareStatement(query2);
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

            String query = "DELETE TABLE `" + name + "`";
            Statement statement = dbConnector.getConn().createStatement();
            statement.execute(query);
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }    
    
}
