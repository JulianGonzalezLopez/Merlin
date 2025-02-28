/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.permissions;

import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Julian
 */
@Service
public class PermissionService implements PermissionServiceInterface {
    
    private final PermissionRepositoryInterface permissionRepository;
    
    @Autowired
    public PermissionService(PermissionRepositoryInterface permissionRepository){
        this.permissionRepository = permissionRepository;
    }
    
    public ArrayList<CreatePermissionRequest> getAll() throws SQLException {
        return permissionRepository.getAll();
    }
    

    
    public void create(CreatePermissionRequest createPermissionRequest)throws SQLException {
        permissionRepository.create(createPermissionRequest);
    }
            
    public void delete(CreatePermissionRequest createPermissionRequest)throws SQLException {
        permissionRepository.delete(createPermissionRequest);
    }
    
}
