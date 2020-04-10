package com.company;

import com.company.Album.AlbumController;
import com.company.Album.AlbumControllerImp;
import com.company.Artist.AristController;
import com.company.Artist.ArtistControllerImp;

public class Main {

    public static void main(String[] args) {
        Database database = Database.getInstance();
        AristController aristController = new ArtistControllerImp(database);
        AlbumController albumController = new AlbumControllerImp(database);
        System.out.println(aristController.create("Vasile", "Romania"));
        System.out.println(aristController.findByName("Vasile"));
        System.out.println(albumController.create("Nebunie", 0, 2001));
        System.out.println(albumController.findByArtist(991));
    }
}
