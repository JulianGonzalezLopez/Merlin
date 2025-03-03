/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.permissions;

import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Julian
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {
    
    private final PermissionServiceInterface permissionService;
    
    @Autowired
    public PermissionController(PermissionServiceInterface permissionService){
        this.permissionService = permissionService;
    }
    
    @GetMapping("/all")
    public ResponseEntity<ArrayList<CreatePermissionRequest>> getAll() throws SQLException {
        ArrayList<CreatePermissionRequest> all = permissionService.getAll();
        return new ResponseEntity<>(all, null, HttpStatus.ACCEPTED);
    }

    
    @PostMapping("/")
    public ResponseEntity<?> create(
        @RequestBody CreatePermissionRequest createPermissionRequest) throws SQLException {

        try{
            //TYPE ERRORS
            if(!(createPermissionRequest.getPermission() instanceof Permission)){
                throw new Error("Permission must be of type permission or capable of transforming into it");
            }

            if(createPermissionRequest.getUser_id() < 1){
                throw new Error("user_id must be 1 or higher");
            }
            
            //tengo que agr3gar de vuelta lo de las tabklas
        }
        catch(Error e){
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.BAD_REQUEST);
        }
        
        //NORMAL WORLFLOW
        permissionService.create(createPermissionRequest);
        
        return new ResponseEntity<>("CREATED", null, HttpStatus.ACCEPTED);
    }
          
    @DeleteMapping("/")
    public ResponseEntity<String> delete(
        @RequestBody CreatePermissionRequest createPermissionRequest) throws SQLException {
        
        String error = null;

        //TYPE ERRORS
        //Checkeo de primitivos realizado por Java
        if(!(createPermissionRequest.getPermission() instanceof Permission)){
            error = "Permission must be of type permission or capable of transforming into it";
        }

     
        
        if(createPermissionRequest.getUser_id() < 1){
            error = "user_id must be 1 or higher";
        }
        
            //tengo que agr3gar de vuelta lo de las tabklas

        
        //ERROR HANDLER
        if(error != null){
            return new ResponseEntity<>(error, null, HttpStatus.BAD_REQUEST);
        }
              
        //NORMAL WORLFLOW
        permissionService.delete(createPermissionRequest);  
        return new ResponseEntity<>("DELETED", null, HttpStatus.ACCEPTED);
    }
}
