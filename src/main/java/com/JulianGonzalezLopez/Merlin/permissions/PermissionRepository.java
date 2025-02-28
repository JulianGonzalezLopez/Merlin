/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.permissions;

import com.JulianGonzalezLopez.Merlin.DbConnector;
import com.JulianGonzalezLopez.Merlin.entry.Entry;
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
public class PermissionRepository implements PermissionRepositoryInterface {
    
    private final DbConnector dbConnector;
    
    @Autowired
    public PermissionRepository(DbConnector dbConnector){
        this.dbConnector = dbConnector;
    }
    
    @Override
    public ArrayList<CreatePermissionRequest> getAll() throws SQLException {
        String query = "SELECT * FROM MerlinPermissions";
        try (PreparedStatement preparedStatement = dbConnector.getConn().prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.getResultSet();
            
            ArrayList<CreatePermissionRequest> resultSetMapped = new ArrayList();
            
            while(resultSet.next()){
                CreatePermissionRequest p = new CreatePermissionRequest();
                p.setUser_id(resultSet.getInt("user_id"));
                p.setTable_id(resultSet.getInt("table_id"));
                p.setPermission(resultSet.getObject("permission", Permission.class) );
                resultSetMapped.add(p);
            }
            
            return resultSetMapped;
            
        }        
    }    
    
    
    public void create(CreatePermissionRequest createPermissionRequest) throws SQLException {
        String query = "INSERT INTO MerlinPermissions(user_id,table_id, permission) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = dbConnector.getConn().prepareStatement(query)) {
            preparedStatement.setInt(1, createPermissionRequest.getUser_id());
            preparedStatement.setInt(2, createPermissionRequest.getTable_id());
            preparedStatement.setString(3, createPermissionRequest.getPermission().toString());
            preparedStatement.executeUpdate();
        }
    }
    
    public void delete(CreatePermissionRequest createPermissionRequest) throws SQLException {
        String query = "DELETE FROM MerlinPermissions WHERE (user_id = ?) AND (table_id = ?)";
        try (PreparedStatement preparedStatement = dbConnector.getConn().prepareStatement(query)) {
            preparedStatement.setInt(1, createPermissionRequest.getUser_id());
            preparedStatement.setInt(2, createPermissionRequest.getTable_id());
            preparedStatement.executeUpdate();
        }
    }
}
