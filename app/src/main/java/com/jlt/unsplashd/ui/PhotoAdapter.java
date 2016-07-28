package com.jlt.unsplashd.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jlt.unsplashd.R;
import com.jlt.unsplashd.data.model.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

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
 * Adapter for the photos in the grid
 * */

// begin class PhotoAdapter
public class PhotoAdapter extends RecyclerView.Adapter< PhotoViewHolder > {

    /** CONSTANTS */

    /** Integers */

    /** Strings */

    /** VARIABLES */

    /* Contexts */

    private Context mHostContext; // the host context

    /* Lists */

    private final List< Photo > photos; // the photos for the grid

    /* Strings */

    private String photoUrlBase; // string to build photo url

    /** CONSTRUCTOR */

    // begin constructor
    public PhotoAdapter( Context mHostContext, List< Photo > photos, String photoUrlBase ) {

        // 0. field initialization

        // 0. field initialization

        this.mHostContext = mHostContext;
        this.photos = photos;
        this.photoUrlBase = photoUrlBase;

    } // end constructor

    /** METHODS */

    /** Getters and Setters */

    /** Overrides */

    @Override
    // begin onCreateViewHolder
    public PhotoViewHolder onCreateViewHolder( ViewGroup parent, int viewType ) {

        // 0. use the photo item view for the photo grid

        // 0. use the photo item view for the photo grid

        return new PhotoViewHolder( LayoutInflater.from( mHostContext )
                .inflate( R.layout.photo_item , parent, false ) );

    } // end onCreateViewHolder

    @Override
    // begin onBindViewHolder
    public void onBindViewHolder( PhotoViewHolder holder, int position ) {

        // 0. get the photo in this position
        // 1. display it

        // 0. get the photo in this position

        Photo currentPhoto = photos.get( holder.getAdapterPosition() );

        // 1. display it

        Picasso.with( mHostContext )
                .load( photoUrlBase + currentPhoto.id )
                .placeholder( R.color.colorPlaceholder )
                .into( holder.imageView );

    } // end onBindViewHolder

    @Override
    // getItemCount
    // items should be the same as the photo list size
    public int getItemCount() { return photos.size(); }

    @Override
    // getItemId
    // use the id of the photo at the current position
    public long getItemId( int position ) { return photos.get( position ).id; }

    /** Other Methods */

    // method getItem
    /** Get the photo at the position */
    public Photo getItem( int position ) { return photos.get( position ); }

    /** INNER CLASSES */

} // end class PhotoAdapter