/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.service;

import com.JulianGonzalezLopez.Merlin.exceptions.PermissionsLackingException;
import com.JulianGonzalezLopez.Merlin.repository.PermissionRepositoryInterface;
import com.JulianGonzalezLopez.Merlin.model.CreatePermissionRequest;
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
    
    public ArrayList<CreatePermissionRequest> getAll(){
        return permissionRepository.getAll();
    }
    
    public CreatePermissionRequest checkPermission(String tableName, int userID){
        ArrayList<CreatePermissionRequest> permissions = permissionRepository.getAll();
        for(CreatePermissionRequest permission : permissions){
            if(permission.getUser_id() == userID && permission.getTable_name().equals(tableName)){
                return permission;
            }
        }
        throw new PermissionsLackingException("You don't have the rights to acces table: " + tableName);
    }
  
    public void create(CreatePermissionRequest createPermissionRequest){
        permissionRepository.create(createPermissionRequest);
    }
            
    public void delete(CreatePermissionRequest createPermissionRequest){
        permissionRepository.delete(createPermissionRequest);
    }
    
}
