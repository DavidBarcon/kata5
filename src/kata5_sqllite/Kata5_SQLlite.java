package kata5_sqllite;

import java.sql.*;

public class Kata5_SQLlite {

    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        
        String createSql= "CREATE TABLE IF NOT EXISTS direcc_email(id integer PRIMARY KEY AUTOINCREMENT,direccion text NOT NULL);";
        
        Class.forName("org.sqlite.JDBC");
        
        Connection connection = DriverManager.getConnection("jdbc:sqlite:data/Prueba.db");
        
        try(Statement statement= connection.createStatement()){
            
            statement.execute(createSql);
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
