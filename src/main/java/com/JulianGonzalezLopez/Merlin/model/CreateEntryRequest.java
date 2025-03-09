/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.model;

import com.JulianGonzalezLopez.Merlin.model.Entry;

/**
 *
 * @author julian.gonzalez
 */
public class CreateEntryRequest {
    private Entry entry;
    private String tableName;

    public CreateEntryRequest(Entry entry, String tableName) {
        this.entry = entry;
        this.tableName = tableName;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public String toString() {
        return "CreateEntryRequest{" + "entry=" + entry + ", tableName=" + tableName + '}';
    }
    
    
    
}
