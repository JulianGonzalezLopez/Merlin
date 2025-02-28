/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.tableRelationship;

/**
 *
 * @author Julian
 */
public class TableRelationship {
    private int parent_id;
    private int child_id;

    public TableRelationship(int parent_id, int child_id) {
        this.parent_id = parent_id;
        this.child_id = child_id;
    }

    public TableRelationship(){
        
    }
    
    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public int getChild_id() {
        return child_id;
    }

    public void setChild_id(int child_id) {
        this.child_id = child_id;
    }
    
    
}
