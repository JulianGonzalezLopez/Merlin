/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.NOT_TO_BE_USED;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julian
 */
public interface TableRelationshipRepositoryInterface {
    public void create(TableRelationship tableRelationship);
    public void delete(TableRelationship tableRelationship);
    public ArrayList<TableRelationship> getAll();
}

