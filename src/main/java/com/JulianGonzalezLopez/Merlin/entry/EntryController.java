/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.entry;

import com.JulianGonzalezLopez.Merlin.exceptions.InvalidInputValueException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    @GetMapping("/all")
    public ResponseEntity<?> getAll(
    @RequestParam String tableName){
        
        if(!(tableName instanceof String)){
            throw new InvalidInputValueException("tableName must be an String");
        } 
        if(tableName.length() < 1){
            throw new InvalidInputValueException("tableName must be at least 1 character long");
        }
        if(tableName.length() > 64){
            throw new InvalidInputValueException("tableName must be less than 64 character long");
        }
        
        ArrayList<Entry> entries = entryService.getAll(tableName);
        return new ResponseEntity<>(entries, null, HttpStatus.ACCEPTED);
    }
    
    
    @PostMapping("/")
    public ResponseEntity<?> create (
    @RequestBody CreateEntryRequest createEntryRequest){
        
        if(!(createEntryRequest.getEntry() instanceof Entry) && !(createEntryRequest.getTableName() instanceof String)){
            throw new InvalidInputValueException("entry must be of Entry type and tableName must be of type String");
        }   
        if(!(createEntryRequest.getEntry() instanceof Entry)){
            throw new InvalidInputValueException("tableName must be of String type");
        }  
        if(!(createEntryRequest.getTableName() instanceof String)){
            throw new InvalidInputValueException("tableName must be of String type");
        }  
        if(createEntryRequest.getEntry().getTitle().length() < 1){
            throw new InvalidInputValueException("entry.title must be at least 1 character long");
        }   
        if(createEntryRequest.getEntry().getBody().length() < 1){
            throw new InvalidInputValueException("entry.body must be at least 1 character long");
        }  
        if(createEntryRequest.getEntry().getCreator_id() < 1){
            throw new InvalidInputValueException("entry.creator_id must be 1 or higher");
        }
         
        entryService.create(createEntryRequest);
        return new ResponseEntity<>(createEntryRequest, null, HttpStatus.CREATED);       
    }
    
    @DeleteMapping("/")
    public ResponseEntity<?> delete(
    @RequestParam int id,
    @RequestParam String tableName){
        
        if(!(tableName instanceof String)){
            throw new InvalidInputValueException("tableName must be an String");
        }
        if(tableName.length() < 1 && id < 0){
            throw new InvalidInputValueException("id must be a possitive number and tableName length must be at least 1");
        }
        if(tableName.length() > 64 && id < 0){
            throw new InvalidInputValueException("id must be a possitive number and tableName length must be less than 64");
        }
        if(id < 0){
            throw new InvalidInputValueException("id must be a possitive number");
        }
        if(tableName.length() < 1){
            throw new InvalidInputValueException("tableName must be at least 1 character long");
        }        
        if(tableName.length() > 64){
            throw new InvalidInputValueException("tableName must be less than 64 character long");
        }
            
        entryService.delete(id, tableName);
        return new ResponseEntity<>("Deleted entry: " + Integer.toString(id) , null, HttpStatus.ACCEPTED);
    }
}
