/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.table;


import com.JulianGonzalezLopez.Merlin.DbConnector;
import com.JulianGonzalezLopez.Merlin.permissions.CreatePermissionRequest;
import com.JulianGonzalezLopez.Merlin.permissions.Permission;
import org.springframework.stereotype.Repository;
//import com.mysql.jdbc.Driver;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
    public ArrayList<String> getAll() throws SQLException {
        String query = "SHOW TABLES";
        try {
            ResultSet resultSet = dbConnector.getConn().prepareStatement(query).executeQuery();
            System.out.println(resultSet);
            ArrayList<String> resultSetMapped = new ArrayList();
            while(resultSet.next()){
                resultSetMapped.add(resultSet.getString(1));
            }
            return resultSetMapped;
        }  
        catch(Error e){
            System.out.println(e);
            throw new SQLException(e.getMessage());
        }
    }    
    
    @Override
    public void createTable(String name) throws SQLException{
        try{
            String query = "CREATE TABLE `" + name + "` (id int AUTO_INCREMENT, title varchar(255), body varchar(255),creator_id int,last_editor_id int, PRIMARY KEY(id))";
            System.out.println(query);
            Statement statement = dbConnector.getConn().createStatement();
            statement.execute(query);
        }
        catch(SQLException e){
            throw e;
        }

    }
    @Override
    public void deleteTable(String name) throws SQLException{
        try{
            String query = "DROP TABLE `" + name + "`";
            Statement statement = dbConnector.getConn().createStatement();
            statement.execute(query);
        }
        catch(SQLException e){
            throw e;
        }
    }    
    
}
