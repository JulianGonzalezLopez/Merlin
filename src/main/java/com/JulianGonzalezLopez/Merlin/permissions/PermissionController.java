/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.permissions;

import org.springframework.beans.factory.annotation.Autowired;
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
    
    public ResponseEntity<String> create(
        @RequestBody CreatePermissionRequest createPermissionRequest){
        permissionService.create(createPermissionRequest);
        return ResponseEntity
                .status(201)
                .build();
    }
            
    public ResponseEntity<String> delete(
        @RequestBody CreatePermissionRequest createPermissionRequest){
        permissionService.delete(createPermissionRequest);
        return ResponseEntity
                .status(200)
                .build();
    }
}
