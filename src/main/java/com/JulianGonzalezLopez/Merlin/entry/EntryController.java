/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.entry;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author julian.gonzalez
 */
@RestController
@RequestMapping("/entry")
public class EntryController {
    
    private final EntryServiceInterface entryService;
    
    @Autowired
    public EntryController(EntryServiceInterface entryService){
        this.entryService = entryService;
    }
    
    @PostMapping("/")
    public ResponseEntity<?> create (
    @RequestBody CreateEntryRequest createEntryRequest) throws SQLException{
        entryService.create(createEntryRequest);
        return new ResponseEntity<>(createEntryRequest, null, HttpStatus.CREATED);       
    }
    
    @DeleteMapping("/")
    public ResponseEntity<?> delete(
    @RequestParam int id,
    @RequestParam String tableName) throws SQLException {

        try{
        //TYPE RELATED ERRORS
            if(!(tableName instanceof String)){
                throw new Error("tableName must be an String");
            }

            //CONTENT RELATED ERRORS
            if(tableName.length() < 1 && id < 0){
                throw new Error("id must be a possitive number and tableName length must be at least 1");
            }

            if(tableName.length() > 64 && id < 0){
                throw new Error("id must be a possitive number and tableName length must be less than 64");
            }

            if(id < 0){
                throw new Error("id must be a possitive number");
            }

            if(tableName.length() < 1){
                throw new Error("tableName must be at least 1 character long");
            }
        
            if(tableName.length() > 64){
                throw new Error("tableName must be less than 64 character long");
            }
        }
        catch(Error e){
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.BAD_REQUEST);
        }

        
        //NORMAL WORKFLOW
        
        entryService.delete(id, tableName);
        return new ResponseEntity<>("Deleted entry: " + Integer.toString(id) , null, HttpStatus.ACCEPTED);
    }
}
