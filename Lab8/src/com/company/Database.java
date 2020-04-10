package com.company;

import java.sql.*;

/**
 * class that manages the connection and operations with the database
 * Singleton pattern
 */

public class Database {

    private Connection con;

    private static Database instance;

    static {
        try {
            instance = new Database();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * create connection to an oracle database
     * @throws SQLException
     */

    private Database() throws SQLException {
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:MusicAlbums", "c##dba", "sql");
    }

    public static Database getInstance() {
        return instance;
    }

    /**
     * search in database with the sql statement send in param
     * @param searchThis
     * @return
     */

    public Boolean find(String searchThis)  {
        try{
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(searchThis);
            int i = 0;
            while (resultSet.next()) {
                i++;
                if (i >= 1) {
                    break;
                }
            }
            return i == 0 ? false : true;
        }
        catch (SQLException e) {
            //e.printStackTrace();
        }
        return false;
    }

    /**
     * insert into the data base with the sql statement send as param
     * @param addThis
     * @return
     */

    public Boolean add(String addThis) {
        try {
            Statement statement = con.createStatement();
            return statement.executeUpdate(addThis) == 0 ? false : true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
