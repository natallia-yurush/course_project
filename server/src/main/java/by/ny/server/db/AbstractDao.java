package by.ny.server.db;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDao {
    protected Connection connection;

    public AbstractDao() {
        try {
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/credits","root","кщще");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
