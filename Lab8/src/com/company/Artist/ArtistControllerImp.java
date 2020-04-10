package com.company.Artist;

import com.company.Database;

import java.util.Random;

/**
 * class ArtistControllerImp implements the ArtistController
 * as part of Artist Dao pattern
 */

public class ArtistControllerImp implements AristController {

    private Database database;

    public ArtistControllerImp(Database database) {
        this.database = database;
    }

    /**
     * send to database a sql statement that insert a artist
     * @param name
     * @param country
     * @return
     */

    @Override
    public String create(String name, String country) {
        Random rn = new Random();
        Integer i = rn.nextInt(1000) + 1;
        return database.add("INSERT INTO ARTISTS (ID, NAME, COUNTRY) VALUES ( " + i.toString() + " , '" + name + "','" + country + "')")
                ? "Succes"
                : "Fail";
    }

    /**
     * send to database a sql statement that tries to find a special artist by name
     * @param name
     * @return
     */

    @Override
    public String findByName(String name) {
        return database.find("SELECT * FROM ARTISTS WHERE name = '" + name + "'")
                ? "Found: " + name
                : "Not Found: " + name;
    }
}