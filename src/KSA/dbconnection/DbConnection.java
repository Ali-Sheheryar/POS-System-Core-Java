package KSA.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/java_springboot?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";
    private static Connection connection;

    private DbConnection() {
        // Private constructor to prevent external instantiation.
    }

    public static Connection getConnection() {        
        try {
        	if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
//				JOptionPane.showMessageDialog(null, "Connection is created Successfully");
        } catch (SQLException e) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, "Database Connection Failed", e);
        }
        return connection;
    }

    public static void closeConnection() {
        try {
        	if (connection != null && !connection.isClosed()) {
        		connection.close();
        	}
        } catch (SQLException e) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, "Error closing database connection", e);
        }
    }
}
