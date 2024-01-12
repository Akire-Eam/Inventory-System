package Inventory.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.prefs.Preferences;



public class DBConnection {


    public static Connection getConnection() {

        System.out.println("\nAttempting connection...");

        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:invtable.db");
            return connection;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static void disconnect(Connection conn) throws SQLException {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}