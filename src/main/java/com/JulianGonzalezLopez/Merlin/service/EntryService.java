/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.service;

import com.JulianGonzalezLopez.Merlin.repository.EntryRepositoryInterface;
import com.JulianGonzalezLopez.Merlin.model.CreateEntryRequest;
import com.JulianGonzalezLopez.Merlin.model.Entry;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author julian.gonzalez
 */
@Service
public class EntryService implements EntryServiceInterface {

    private final EntryRepositoryInterface entryRepository;
    
    @Autowired
    public EntryService(EntryRepositoryInterface entryRepository){
        this.entryRepository = entryRepository;
    }
    
    @Override
    public ArrayList<Entry> getAll(String tableName){
        return entryRepository.getAll(tableName);
    }
    
    @Override
    public void create(CreateEntryRequest createEntryRequest){
        entryRepository.create(createEntryRequest);
    }
    @Override
    public void delete(int id, String tableName){
        entryRepository.delete(id, tableName);
    }
    
}
