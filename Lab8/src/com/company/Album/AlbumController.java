package com.company.Album;

/**
 * Part of Album Dao
 * the AlbumController interface
 */

public interface AlbumController {
    String create(String name, int artistId, int releaseYear);
    String findByArtist(int artistId);
}
