package com.JulianGonzalezLopez.Merlin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class MerlinApplication {

	public static void main(String[] args) {
		SpringApplication.run(MerlinApplication.class, args);
	}
        
        @EventListener(ApplicationReadyEvent.class)
        public void dbSetup(){
            System.out.println("Required setup for the program to work \n This will create the next tables in case they don't exist inside merlindb \n(Remember to create MerlinDB for the program to run) \n 1.MerlinUsers (Forbiden name) \n 2.MerlinPermissions \n 3.MerlinTablesRelationships");
            
            try{
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MerlinDB?" + "user=root&password=root");
                String queryMUsers = "CREATE TABLE IF NOT EXISTS MerlinUsers(id int AUTO_INCREMENT, username varchar(50), password varchar(50), PRIMARY KEY(id))";
                String queryMPermissions = "CREATE TABLE IF NOT EXISTS MerlinPermissions (id INT AUTO_INCREMENT PRIMARY KEY, user_id INT NOT NULL, table_name VARCHAR(255) NOT NULL, permission_type ENUM('READ', 'WRITE', 'ADMIN') NOT NULL, UNIQUE KEY (user_id, table_name), FOREIGN KEY (user_id) REFERENCES MerlinUsers(id) ON DELETE CASCADE)";
                //Aunque se crea, de momento no pienso aplicar las tablas hijas,se me complica mucho rai nau
                String queryMTableRelationships = "CREATE TABLE IF NOT EXISTS MerlinTablesRelationships(id INT AUTO_INCREMENT PRIMARY KEY, parent_name varchar(255), child_name varchar(255), UNIQUE KEY (parent_name, child_name))";
                Statement statement = conn.createStatement();
                statement.execute(queryMUsers);
                statement.execute(queryMPermissions);
                statement.execute(queryMTableRelationships);
            }
            catch (SQLException e){
                System.out.println("Something broke down in the setup system, check the existance of merlindb and that your credentials are OK. Besitos");
                System.out.println("Error: " + e.getMessage());
            }
        }

}
