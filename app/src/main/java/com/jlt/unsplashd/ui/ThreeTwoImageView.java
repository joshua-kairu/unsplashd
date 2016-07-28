package com.jlt.unsplashd.ui;

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

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * ImageView that fits images in a 3:2 aspect ratio
 * */
// begin class ThreeTwoImageView
public class ThreeTwoImageView extends ForegroundImageView {

    /* CONSTANTS */
    
    /* Integers */
    
    /* Strings */
        
    /* VARIABLES */
    
    /* CONSTRUCTOR */

    // begin constructor
    public ThreeTwoImageView( Context context, AttributeSet attributeSet ) {

        // 0. super things

        // 0. super things

        super( context, attributeSet );

    } // end constructor

    /* METHODS */
    
    /* Getters and Setters */
    
    /* Overrides */

    @Override
    // begin onMeasure
    // onMeasure - Measure the view and its content
    //  to determine the measured width and the measured height
    protected void onMeasure( int widthMeasureSpecification, int heightMeasureSpecification ) {

        // 0. get the size of the width
        // 1. height should be 2 / 3 of width to meet a 3:2 aspect ratio
        // 2. pass width and height to super

        // 0. get the size of the width

        // MeasureSpec - encapsulates the layout requirements passed from parent to child
        // getSize - gets the size in pixels from the supplied measure specification.
        int width = View.MeasureSpec.getSize( widthMeasureSpecification );

        // 1. height should be 2 / 3 of width to meet a 3:2 aspect ratio

        // integer division because we are using pixels
        int desiredHeight = width * 2 / 3;

        // 2. pass width and height to super

        // makeMeasureSpec - create a measure specification based on the supplied size and mode
        // EXACTLY - the parent has determined an exact size for the child. The child is going
        //  to be given those bounds regardless of how big it wants to be.
        super.onMeasure( widthMeasureSpecification,
                         View.MeasureSpec.makeMeasureSpec( desiredHeight, View.MeasureSpec.EXACTLY ) );

    } // end onMeasure

    /* Other Methods */
    
    /* INNER CLASSES */

} // end class ThreeTwoImageView