package com.jlt.unsplashd.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;

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
 * Custom item click listener to be used in {@link ItemClickSupport}
 * */

// begin interface OnItemClickListener
public interface OnItemClickListener {

    /* CONSTANTS */
       
    /* VARIABLES */
       
    /* METHODS */
        
    /* Getters and Setters */
        
    /* Overrides */
        
    /* Other Methods */

    // onItemClicked
    // callback for when an item is clicked
    void onItemClicked( RecyclerView recyclerView, int position, View view );

} // end interface OnItemClickListener
