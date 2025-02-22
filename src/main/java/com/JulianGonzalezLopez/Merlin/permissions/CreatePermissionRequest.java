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
    private int table_id;
    private Permission permission;

    public CreatePermissionRequest(int user_id, int table_id, Permission permission) {
        this.user_id = user_id;
        this.table_id = table_id;
        this.permission = permission;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
    
}
