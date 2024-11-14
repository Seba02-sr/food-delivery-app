package com.mycompany.tp.dsw.dataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initializeDatabase() {
        try (Connection connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement()) {

            String createTableSQL = "CREATE TABLE IF NOT EXISTS tu_tabla (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "columna VARCHAR(255) NOT NULL" +
                    ");";


                    
            statement.execute(createTableSQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
