package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static DBConnection instance;
    private Connection connection;
    private String url = "jdbc:postgresql://silly.db.elephantsql.com/gybbunxv";
    private String user = "gybbunxv";
    private String password = "BV6Yv-2zLXg1-wU7VrUP_vIY9TXOqhVS";

    private DBConnection() throws SQLException {
        try {
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            throw new SQLException("Erro ao conectar ao banco de dados: " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DBConnection getInstance() throws SQLException {
        if (instance == null) {
            synchronized (DBConnection.class) {
                if (instance == null) {
                    instance = new DBConnection();
                }
            }
        }
        return instance;
    }
}
