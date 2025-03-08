/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.user;

/**
 *
 * @author julian.gonzalez
 */
public class User {
    //PASAR EL INT A LONG
    private int id;
    private String username;
    //CIFRAR SI O SI - CRYPTO
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        /**
         * import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
            public void setPassword(String password) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            this.password = encoder.encode(password);
         */
        this.password = password;
    }
    
    
}
