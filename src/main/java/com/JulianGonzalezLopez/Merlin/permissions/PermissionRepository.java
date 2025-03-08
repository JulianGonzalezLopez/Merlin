/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.permissions;

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
public class PermissionRepository implements PermissionRepositoryInterface {
    
    private final DbConnector dbConnector;
    
    @Autowired
    public PermissionRepository(DbConnector dbConnector){
        this.dbConnector = dbConnector;
    }
    
    @Override
    public ArrayList<CreatePermissionRequest> getAll(){
        String query = "SELECT * FROM MerlinPermissions";
        try{
            PreparedStatement preparedStatement = dbConnector.getConn().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet == null){
                return null;
            }
            ArrayList<CreatePermissionRequest> resultSetMapped = new ArrayList();            
            while(resultSet.next()){
                CreatePermissionRequest p = new CreatePermissionRequest();
                p.setUser_id(resultSet.getInt("user_id"));
                p.setTable_name(resultSet.getString("table_name"));
                Permission permission = Permission.valueOf(resultSet.getString("permission_type"));
                p.setPermission(permission);
                resultSetMapped.add(p);
            }
            return resultSetMapped;
        }
        catch(SQLException e){
            throw new SQLExceptionWrapper(e.getMessage(), "Failed to fetch permissions");
        }
    }    
    
    @Override
    public void create(CreatePermissionRequest createPermissionRequest){
        String query = "INSERT INTO MerlinPermissions(user_id, table_name, permission_type) VALUES (?, ?, ?)";
        try{
            PreparedStatement preparedStatement = dbConnector.getConn().prepareStatement(query);
            preparedStatement.setInt(1, createPermissionRequest.getUser_id());
            preparedStatement.setString(2, createPermissionRequest.getTable_name());
            preparedStatement.setString(3, createPermissionRequest.getPermission().toString());
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            throw new SQLExceptionWrapper(e.getMessage(), "Failed to create a permission");
        }
    }
    
    @Override
    //TIRAR ERROR AL ELIMINAR PERMISOS INEXISTENTES
    public void delete(CreatePermissionRequest createPermissionRequest){
        String query = "DELETE FROM MerlinPermissions WHERE (user_id = ?) AND (table_name = ?)";
        try{
            PreparedStatement preparedStatement = dbConnector.getConn().prepareStatement(query);
            preparedStatement.setInt(1, createPermissionRequest.getUser_id());
            preparedStatement.setString(2, createPermissionRequest.getTable_name());
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            throw new SQLExceptionWrapper(e.getMessage(), "Failed to delete permissions");
        }
    }
}