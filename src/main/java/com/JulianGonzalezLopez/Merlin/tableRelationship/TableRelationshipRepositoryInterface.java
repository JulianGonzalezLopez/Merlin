/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.tableRelationship;

import java.sql.SQLException;

/**
 *
 * @author Julian
 */
public interface TableRelationshipRepositoryInterface {
    public void create(TableRelationship tableRelationship) throws SQLException;
    public void delete(TableRelationship tableRelationship) throws SQLException;
}

