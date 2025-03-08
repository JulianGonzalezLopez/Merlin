/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.entry;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author julian.gonzalez
 */
public interface EntryServiceInterface {

    public void create(CreateEntryRequest createEntryRequest);
    public void delete(int id, String tableName);
    public ArrayList<Entry> getAll(String tableName);
}
