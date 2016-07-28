package com.jlt.unsplashd.data.model;

/*
 Unsplashd

 Simple Unsplash picture viewer
 * <p/>
 * Copyright (C) 2016 Kairu Joshua Wambugu
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 */

/**
 * An Unsplash photo
 * */

// begin class Photo
public class Photo {

    // Unsplash photo JSON

    /*{
        "format": "jpeg",
        "width": 5616,
        "height": 3744,
        "filename": "0000_yC-Yzbqy7PY.jpeg",
        "id": 0,
        "author": "Alejandro Escamilla",
        "author_url": "https://unsplash.com/alejandroescamilla",
        "post_url": "https://unsplash.com/photos/yC-Yzbqy7PY"
    }*/

    /* CONSTANTS */
    
    /* Integers */
    
    /* Strings */
        
    /* VARIABLES */

    /* Primitives */

    public final int width; // "width": 5616,
    public final int height; // "height": 3744,
    
    public final long id; // "id": 0,

    /* Strings */

    public final String format; // "format": "jpeg",
    public final String filename; // "filename": "0000_yC-Yzbqy7PY.jpeg",
    public final String author; // "author": "Alejandro Escamilla",
    public final String author_url; // "author_url": "https://unsplash.com/alejandroescamilla",
    public final String post_url; // "post_url": "https://unsplash.com/photos/yC-Yzbqy7PY"

    /* CONSTRUCTOR */

    // begin constructor
    public Photo( String format, 
                  int width, 
                  int height, 
                  String filename, 
                  long id, 
                  String author, 
                  String author_url, 
                  String post_url ) {
        
        // 0. initialize fields

        // 0. initialize fields
        
        this.width = width;
        this.height = height;
        this.id = id;
        this.format = format;
        this.filename = filename;
        this.author = author;
        this.author_url = author_url;
        this.post_url = post_url;
        
    } // end constructor
    
    /* METHODS */
    
    /* Getters and Setters */
    
    /* Overrides */
    
    /* Other Methods */
    
    /* INNER CLASSES */

} // end class Photo