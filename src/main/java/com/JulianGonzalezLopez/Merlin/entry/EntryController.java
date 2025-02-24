/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.entry;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<String> create (
    @RequestBody CreateEntryRequest createEntryRequest) throws SQLException{
        
        entryService.create(createEntryRequest);
        
        return ResponseEntity
                .status(201)
                .build();
           
    }
    
    @DeleteMapping("/")
    public ResponseEntity<String> delete(
    @RequestParam int id,
    @RequestParam String tableName
    ) throws SQLException {
        
        entryService.delete(id, tableName);
        return ResponseEntity
                .status(200)
                .build();
        
    }
}
