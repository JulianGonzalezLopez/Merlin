/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.tableRelationship;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Julian
 */
@RestController
@RequestMapping("/tableRelationship")
public class TableRelationshipController {
    
    private final TableRelationshipServiceInterface tableRelationshipService;
    
    public TableRelationshipController(TableRelationshipServiceInterface tableRelationshipService){
        this.tableRelationshipService = tableRelationshipService;
    }
    
    @PostMapping("/")
    public ResponseEntity<String> create(TableRelationship tableRelationship){
        tableRelationshipService.create(tableRelationship);
        return ResponseEntity
            .status(201)
            .build();
    }
    
    @DeleteMapping("/")
    public ResponseEntity<String> delete(TableRelationship tableRelationship){
        tableRelationshipService.delete(tableRelationship);
        return ResponseEntity
            .status(200)
            .build();
    }
    
}
