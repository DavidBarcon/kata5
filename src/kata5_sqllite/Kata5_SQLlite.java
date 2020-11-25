/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5_sqllite;

import java.sql.*;

/**
 *
 * @author david
 */
public class Kata5_SQLlite {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        
        Class.forName("org.sqlite.JDBC");
        
        Connection connection = DriverManager.getConnection("jdbc:sqlite:data/Prueba.db");
        
        try(Statement statement= connection.createStatement()){
            ResultSet set = statement.executeQuery("SELECT * FROM PEOPLE");
            while (set.next()) {
                String id = set.getString("id");
                String name = set.getString("Name");
                String surname = set.getString("Apellidos");
                String dep = set.getString("Departamento");
                System.out.println(id+ " " + name +" " + surname+ " " + dep);
            }
        }
      
        
    }
    
}
