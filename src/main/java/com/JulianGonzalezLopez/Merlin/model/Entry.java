/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.model;

/**
 *
 * @author julian.gonzalez
 * Entry refers to diferent registers in the DBs inside Merlin
 * Users may have access to different
 * 
 */
public class Entry {
   
   private String title;
   private String body;
   private int creator_id;
   private int last_editor_id;

    public int getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(int creator_id) {
        this.creator_id = creator_id;
    }

    public int getLast_editor_id() {
        return last_editor_id;
    }

    public void setLast_editor_id(int last_editor_id) {
        this.last_editor_id = last_editor_id;
    }

    public Entry(String title, String body, int creator_id, int last_editor_id) {
        this.title = title;
        this.body = body;
        this.creator_id = creator_id;
        this.last_editor_id = last_editor_id;
    }
   
    public Entry(){
        
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Entry{" + "title=" + title + ", body=" + body + ", creator_id=" + creator_id + ", last_editor_id=" + last_editor_id + '}';
    }
    
    
    
}
