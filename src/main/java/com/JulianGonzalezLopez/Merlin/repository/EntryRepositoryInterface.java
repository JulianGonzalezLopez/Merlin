/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.repository;

import com.JulianGonzalezLopez.Merlin.model.CreateEntryRequest;
import com.JulianGonzalezLopez.Merlin.model.Entry;
import java.util.ArrayList;

/**
 *
 * @author julian.gonzalez
 */
public interface EntryRepositoryInterface {
    public void create(CreateEntryRequest createEntryRequest);
    public void delete(int id, String tableName); 
    public ArrayList<Entry> getAll(String tableName);

}
