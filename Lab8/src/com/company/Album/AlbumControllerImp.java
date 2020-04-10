package com.company.Album;

import com.company.Database;

import java.util.Random;


/**
 * Part of the Album DAO pattern
 * Implements AlbmController
 */

public class AlbumControllerImp implements AlbumController{

    private Database database;

    public AlbumControllerImp(Database database){
        this.database = database;
    }


    /**
     * send to database a sql statement that insert a new album
     * @param name
     * @param artistId
     * @param releaseYear
     * @return
     */

    @Override
    public String create(String name, int artistId, int releaseYear) {
        Random rn = new Random();
        Integer i = rn.nextInt(1000) + 1;
        Integer ai = artistId;
        Integer ry = releaseYear;
        return database.add("INSERT INTO ALBUMS (ID, NAME, ARTIST_ID, RELEASE_YEAR) VALUES ( " + i.toString() + " , '" + name + "' , " + ai.toString() + " , " + ry.toString() + ")")
                ? "Succes"
                : "Fail";
    }

    /**
     * send to database a sql statement that finds an album based of an artist id
     * @param artistId
     * @return
     */

    @Override
    public String findByArtist(int artistId) {
        Integer ai = artistId;
        return database.find("SELECT * FROM ALBUMS WHERE ARTIST_ID = " + ai.toString() )
                ? "Found album"
                : "Not Found album";
    }
}
