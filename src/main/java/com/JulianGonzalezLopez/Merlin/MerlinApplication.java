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
                String queryMTables = "CREATE TABLE IF NOT EXISTS MerlinTables(id int AUTO_INCREMENT, name varchar(50), PRIMARY KEY(id))";
                String queryMPermissions = "CREATE TABLE IF NOT EXISTS MerlinPermissions(user_id int, table_id int , PRIMARY KEY(user_id, table_id), FOREIGN KEY (user_id) REFERENCES MerlinUsers(id) ON DELETE CASCADE, FOREIGN KEY(table_id) REFERENCES MerlinTables(id) ON DELETE CASCADE)";
                String queryMTableRelationships = "CREATE TABLE IF NOT EXISTS MerlinTablesRelationships(parent_id int, child_id int, PRIMARY KEY(parent_id,child_id), FOREIGN KEY(child_id) REFERENCES MerlinTables(id) ON DELETE CASCADE, FOREIGN KEY(parent_id) REFERENCES MerlinTables(id) ON DELETE CASCADE)";
                Statement statement = conn.createStatement();
                statement.execute(queryMUsers);
                statement.execute(queryMTables);
                statement.execute(queryMPermissions);
                statement.execute(queryMTableRelationships);
            }
            catch (SQLException e){
                System.out.println("Something broke down in the setup system, check the existance of merlindb and that your credentials are OK. Besitos");
                System.out.println("Error: " + e.getMessage());
            }
        }

}
