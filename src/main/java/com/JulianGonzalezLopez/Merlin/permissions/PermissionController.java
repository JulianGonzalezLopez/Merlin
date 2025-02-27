/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.permissions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
     
    public ResponseEntity<?> create(
        @RequestBody CreatePermissionRequest createPermissionRequest){
        

        try{
            //TYPE ERRORS
            if(!(createPermissionRequest.getPermission() instanceof Permission)){
                throw new Error("Permission must be of type permission or capable of transforming into it");
            }

            //CONTENT RELATED ERRORS
            if(createPermissionRequest.getUser_id() < 1 && createPermissionRequest.getTable_id() < 1){
                throw new Error("user_id and table_id must be 1 or higher");
            }        

            if(createPermissionRequest.getUser_id() < 1){
                throw new Error("user_id must be 1 or higher");
            }

            if(createPermissionRequest.getTable_id() < 1){
                throw new Error("table_id must be 1 or higher");
            }   
        }
        catch(Error e){
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.BAD_REQUEST);
        }
        
        //NORMAL WORLFLOW
        permissionService.create(createPermissionRequest);
        
        return new ResponseEntity<>("CREATED", null, HttpStatus.ACCEPTED);

    }
            
    public ResponseEntity<String> delete(
        @RequestBody CreatePermissionRequest createPermissionRequest){
        
        String error = null;

        //TYPE ERRORS
        //Checkeo de primitivos realizado por Java
        if(!(createPermissionRequest.getPermission() instanceof Permission)){
            error = "Permission must be of type permission or capable of transforming into it";
        }

        //CONTENT RELATED ERRORS
        if(createPermissionRequest.getUser_id() < 1 && createPermissionRequest.getTable_id() < 1){
            error = "user_id and table_id must be 1 or higher";
        }        
        
        if(createPermissionRequest.getUser_id() < 1){
            error = "user_id must be 1 or higher";
        }
        
        if(createPermissionRequest.getTable_id() < 1){
            error = "table_id must be 1 or higher";
        }
        
        
        //ERROR HANDLER
        if(error != null){
            return new ResponseEntity<>(error, null, HttpStatus.BAD_REQUEST);
        }
              
        //NORMAL WORLFLOW
        permissionService.delete(createPermissionRequest);  
        return new ResponseEntity<>("DELETED", null, HttpStatus.ACCEPTED);
    }
}
