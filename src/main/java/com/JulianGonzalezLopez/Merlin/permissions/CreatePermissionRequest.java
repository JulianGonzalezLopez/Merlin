/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.permissions;

/**
 *
 * @author Julian
 */
public class CreatePermissionRequest {
    private int user_id;
    private String table_name;
    private Permission permission;

    public CreatePermissionRequest() {
    }

    public CreatePermissionRequest(int user_id, String table_name, Permission permission) {
        this.user_id = user_id;
        this.table_name = table_name;
        this.permission = permission;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
    
    
}
