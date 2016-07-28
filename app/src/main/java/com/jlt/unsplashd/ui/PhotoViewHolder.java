package com.jlt.unsplashd.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jlt.unsplashd.R;

import butterknife.Bind;
import butterknife.ButterKnife;

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

/** View holder for the photos */

// begin class PhotoViewHolder
public class PhotoViewHolder extends RecyclerView.ViewHolder {

    /** CONSTANTS */

    /** Integers */

    /** Strings */

    /** VARIABLES */

    /* Foreground Image Views */

    @Bind( R.id.pi_fiv_photo )
    ForegroundImageView imageView;

    /** CONSTRUCTOR */

    // begin constructor
    public PhotoViewHolder( View itemView ) {

        // 0. super things
        // 1. bind to the super item view

        // 0. super things

        super( itemView );

        // 1. bind to the super item view

        // bind - binds the views annotated in this class
        //  using the parameter view as the root view
        ButterKnife.bind( this, itemView );

    } // end constructor

    /** METHODS */

    /** Getters and Setters */

    /** Overrides */

    /** Other Methods */

    /** INNER CLASSES */

} // end class PhotoViewHolder