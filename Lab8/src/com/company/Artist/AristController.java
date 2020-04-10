package com.company.Artist;

/**
 * Artist Dao Interface
 *
 */

public interface AristController {
    String create(String name, String country);
    String findByName(String name);
}
