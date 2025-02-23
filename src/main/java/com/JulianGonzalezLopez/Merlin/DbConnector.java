/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Julian
 */
@Component
public class DbConnector {
    private Connection conn;
    
    public DbConnector(){
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost/MerlinDB?" + "user=root&password=root");
        }
        catch(SQLException e){
            throw new Error(e);
        }
    }

    public Connection getConn() {
        return conn;
    }

}