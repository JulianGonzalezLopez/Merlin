/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.table;

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
 * @author julian.gonzalez
 */

@RestController
@RequestMapping("/table")
public class TableController {
    
    private final TableService tableService;
    
    @Autowired
    public TableController(TableService tableService){
        this.tableService = tableService;
    }
    
    @GetMapping("/")
    public ResponseEntity<String> getasd(){
                return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("chi");
    }
    
    
    @PostMapping("/")
    public ResponseEntity<String> createTable(
    @RequestBody String name){
        
        tableService.createTable(name);
        
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("ok");
    }
    
    @DeleteMapping
        public ResponseEntity<String> deleteTable(){
        
        
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("ok");
    }
    
}
