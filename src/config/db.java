package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.ResultSet;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tmsdzil
 */
public class db {

    private static Connection connection;
    public static Connection getConnection() {

        if (connection == null) {
            try {
                connection= DriverManager.getConnection("jdbc:sqlite:./db/app.db");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());;
            }
        }
        return connection;
    }

    public static void main(String[] args) {

//        try {
//
//            // create a database connection
////            Statement statement = getConnection().createStatement();
////            statement.setQueryTimeout(30);  // set timeout to 30 sec.
////            statement.executeUpdate("insert into antrian values(2, '2021-01-29')");
////            ResultSet rs = statement.executeQuery("select * from antrian");
//            ResultSet rs = getConnection().getMetaData().getTables(null, null, null, null);
//            while (rs.next()) {
//                System.out.println(rs.getString("TABLE_NAME"));
//            }
//
////            while (rs.next()) {
////                // read the result set
////                System.out.println("id = " + rs.getInt("id"));
////            }
//        } catch (SQLException e) {
//            // if the error message is "out of memory",
//            // it probably means no database file is found
//            System.err.println("Cek SQLException " + e.getMessage());
//        } finally {
//            try {
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                // connection close failed.
//                System.err.println(e.getMessage());
//            }
//        }
    }
}
