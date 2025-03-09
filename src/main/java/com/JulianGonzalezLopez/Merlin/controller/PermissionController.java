/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.controller;

import com.JulianGonzalezLopez.Merlin.exceptions.InvalidInputValueException;
import com.JulianGonzalezLopez.Merlin.model.CreatePermissionRequest;
import com.JulianGonzalezLopez.Merlin.model.Permission;
import com.JulianGonzalezLopez.Merlin.service.PermissionServiceInterface;
import java.util.ArrayList;
import static org.slf4j.helpers.Reporter.error;
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
    public ResponseEntity<ArrayList<CreatePermissionRequest>> getAll(){
        ArrayList<CreatePermissionRequest> all = permissionService.getAll();
        return new ResponseEntity<>(all, null, HttpStatus.ACCEPTED);
    }

    @PostMapping("/")
    public ResponseEntity<?> create(
        @RequestBody CreatePermissionRequest createPermissionRequest){

        if(!(createPermissionRequest.getPermission() instanceof Permission)){
            throw new InvalidInputValueException("Permission must be of type permission or capable of transforming into it");
        }
        if(createPermissionRequest.getUser_id() < 1){
            throw new InvalidInputValueException("user_id must be 1 or higher");
        }
        if(createPermissionRequest.getTable_name().length() > 64){
            throw new InvalidInputValueException("Invalid tableName");
        }
        if(createPermissionRequest.getTable_name().length() < 1){
            throw new InvalidInputValueException("Invalid tableName");
        }        

        permissionService.create(createPermissionRequest);        
        return new ResponseEntity<>("CREATED", null, HttpStatus.ACCEPTED);
    }
          
    @DeleteMapping("/")
    public ResponseEntity<String> delete(
    @RequestBody CreatePermissionRequest createPermissionRequest){
        
        if(!(createPermissionRequest.getPermission() instanceof Permission)){
            throw new InvalidInputValueException("Permission must be of type permission or capable of transforming into it");
        }
        if(createPermissionRequest.getUser_id() < 1){
            throw new InvalidInputValueException("user_id must be 1 or higher");
        }
        if(createPermissionRequest.getTable_name().length() > 64){
            throw new InvalidInputValueException("Invalid tableName");
        }
        if(createPermissionRequest.getTable_name().length() < 1){
            throw new InvalidInputValueException("Invalid tableName");
        }  
        
        permissionService.delete(createPermissionRequest);  
        return new ResponseEntity<>("DELETED", null, HttpStatus.ACCEPTED);
    }
}