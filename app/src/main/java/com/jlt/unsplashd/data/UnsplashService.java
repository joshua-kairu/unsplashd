package com.jlt.unsplashd.data;

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

import com.jlt.unsplashd.data.model.Photo;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Modeling the unsplash.it API
 * */

// begin interface UnsplashService
public interface UnsplashService {

    /* CONSTANTS */

    /* Strings */

    String ENDPOINT = "https://unsplash.it"; // the endpoint of the REST API

    /* VARIABLES */
       
    /* METHODS */
        
    /* Getters and Setters */
        
    /* Overrides */
        
    /* Other Methods */

    @GET( "/list" )
    // Make a GET request to a REST path relative to base URL.
    void getFeed( Callback< List< Photo > > callback );

} // end interface UnsplashService
