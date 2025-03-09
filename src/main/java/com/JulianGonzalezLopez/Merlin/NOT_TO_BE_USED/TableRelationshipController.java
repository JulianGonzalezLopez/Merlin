/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.NOT_TO_BE_USED;

import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Julian
 */
@RestController
@RequestMapping("/demomentocanceloestaparteporquesemecomplicomucholaverdad")
public class TableRelationshipController {
    
    private final TableRelationshipServiceInterface tableRelationshipService;
    
    public TableRelationshipController(TableRelationshipServiceInterface tableRelationshipService){
        this.tableRelationshipService = tableRelationshipService;
    }
    
    /**
    @GetMapping("/")
    public ResponseEntity<ArrayList<TableRelationship>> getAll() throws SQLException {
        ArrayList<TableRelationship> all = tableRelationshipService.getAll(); 
        return new ResponseEntity<>(all, null, HttpStatus.ACCEPTED);
    }
    
    @PostMapping("/")
    public ResponseEntity<String> create(TableRelationship tableRelationship) throws SQLException {   
        try{
            //CONTENT ERRORS
            if(tableRelationship.getParent_id() < 1 && tableRelationship.getChild_id() < 1){
                throw new Error("parent_id and child_id must be 1 or higher");
            }
            if(tableRelationship.getParent_id() < 1){
                throw new Error("parent_id must be 1 or higher");
            }
            if(tableRelationship.getChild_id() < 1){
                throw new Error("child_id must be 1 or higher");
            }  
        }
        catch(Error e){
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.BAD_REQUEST);
        }     
        //NORMAL WORLFLOW
        tableRelationshipService.create(tableRelationship);
        return new ResponseEntity<>("CREATED", null, HttpStatus.ACCEPTED);        
    }
    
    @DeleteMapping("/")
    public ResponseEntity<String> delete(TableRelationship tableRelationship) throws SQLException {
        try{
            //CONTENT ERRORS
            if(tableRelationship.getParent_id() < 1 && tableRelationship.getChild_id() < 1){
                throw new Error("parent_id and child_id must be 1 or higher");
            }
            if(tableRelationship.getParent_id() < 1){
                throw new Error("parent_id must be 1 or higher");
            }
            if(tableRelationship.getChild_id() < 1){
                throw new Error("child_id must be 1 or higher");
            }  
        }
        catch(Error e){
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.BAD_REQUEST);
        }
        //NORMAL WORLFLOW
        tableRelationshipService.delete(tableRelationship);
        return new ResponseEntity<>("DELETED", null, HttpStatus.ACCEPTED);
    }
    **/
}
