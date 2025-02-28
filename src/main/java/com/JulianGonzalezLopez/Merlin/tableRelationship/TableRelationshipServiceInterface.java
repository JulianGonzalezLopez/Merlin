/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.tableRelationship;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julian
 */
public interface TableRelationshipServiceInterface {
    public void create(TableRelationship tableRelationship) throws SQLException;
    public void delete(TableRelationship tableRelationship) throws SQLException;
    public ArrayList<TableRelationship> getAll() throws SQLException;
}
