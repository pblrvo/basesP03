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
            // Apartado a ------------------------------------------------------
            tiempo(statement, "select avg(population) from world.city;");
            tiempo(statement, "select avg(population) from world.city;");
            tiempo(statement, "select count(*) from sakila.actor;");
            tiempo(statement, "select count(*) from sakila.actor;");
            // Apartado b ------------------------------------------------------
            tiempo(statement, "select * from world.country;");
            tiempo(statement, "select * from world.country;");
            tiempo(statement, "select * from world.country where continent = 'Europe';");
            tiempo(statement, "select * from world.country where continent = 'Europe';");
            // Apartado c ------------------------------------------------------
            tiempo(statement,
                    "select actor.actor_id, actor.first_name, actor.last_name, film_actor.film_id, film.title from sakila.actor inner join film_actor on sakila.actor.actor_id = sakila.film_actor.actor_id inner join film on sakila.film.film_id = sakila.film_actor.film_id;");
            tiempo(statement,
                    "select actor.actor_id, actor.first_name, actor.last_name, film_actor.film_id, film.title from sakila.actor inner join film_actor on sakila.actor.actor_id = sakila.film_actor.actor_id inner join film on sakila.film.film_id = sakila.film_actor.film_id;");
            tiempo(statement,
                    "select city.ID, city.Name, city.District, city.Population, country.Name, country.Continent from world.city inner join world.country on city.CountryCode = country.Code;");
            tiempo(statement,
                    "select city.ID, city.Name, city.District, city.Population, country.Name, country.Continent from world.city inner join world.country on city.CountryCode = country.Code;");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
