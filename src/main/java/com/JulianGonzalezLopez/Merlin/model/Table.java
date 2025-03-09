/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.model;

/**
 *
 * @author julian.gonzalez
 * Every table must have the same structure to be inserted or exported to another instance of Merlin
 * -------------------
 * | title | content |
 * -------------------
 * 
 */
public class Table {
    private String name;
    
    public Table(String name){
        this.name = name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
}
