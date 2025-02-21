/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.entry;

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
   private String tableBelongedTo;

    public Entry(String title, String body, String tableBelongedTo) {
        this.title = title;
        this.body = body;
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
    
}
