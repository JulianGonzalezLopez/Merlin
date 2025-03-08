/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.permissions;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julian
 */
public interface PermissionServiceInterface {
    public void create(CreatePermissionRequest createPermissionRequest);
    public void delete(CreatePermissionRequest createPermissionRequest);
    public ArrayList<CreatePermissionRequest> getAll();

}
