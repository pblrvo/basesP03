package aplicacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Principal {
    public static void main(String[] args) throws SQLException {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root",
                    "123");
            Statement statement = con.createStatement();
            long time_before = System.currentTimeMillis();
            ResultSet result = statement.executeQuery("show databases;");
            long time_passed = System.currentTimeMillis() - time_before;
            System.out.println("Tiempo de consulta: " + time_passed / 100);
            System.out.println("Connected");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
