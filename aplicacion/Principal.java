package aplicacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Principal {

    public static void tiempo(Statement statement, String query) throws SQLException {
        long time_before = System.currentTimeMillis();
        ResultSet result = statement.executeQuery(query);
        long time_passed = System.currentTimeMillis() - time_before;
        float new_time = time_passed;
        System.out.println("Consulta: " + query + "\n" + "Tiempo de consulta: " + new_time / 1000 + " segundos.");
    }

    public static void main(String[] args) throws SQLException {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root",
                    "123");
            Statement statement = con.createStatement();
            tiempo(statement, "select avg(population) from world.city;");
            tiempo(statement, "select avg(population) from world.city;");
            tiempo(statement, "select count(*) from sakila.actor;");
            tiempo(statement, "select count(*) from sakila.actor;");
            System.out.println("Connected");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
