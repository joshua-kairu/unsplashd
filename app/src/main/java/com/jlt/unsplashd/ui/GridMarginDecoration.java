package com.jlt.unsplashd.ui;

import android.graphics.Rect;
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
  * Decorator for the grid
  */

// begin class GridMarginDecoration
public class GridMarginDecoration extends RecyclerView.ItemDecoration {

    /** CONSTANTS */

    /** Integers */

    /** Strings */

    /** VARIABLES */

    /* Primitives */

    private int space; // the space ;-)

    /** CONSTRUCTOR */

    public GridMarginDecoration( int space ) { this.space = space; }

    /** METHODS */

    /** Getters and Setters */

    /** Overrides */

    @Override
    // begin getItemOffsets
    // getItemOffsets - Retrieve any offsets for the given item.
    //  outRect - Rect to receive the output.
    //  view - The child view to decorate
    //  parent - The RecyclerView that this ItemDecoration is decorating
    //  state - The current state of RecyclerView.
    public void getItemOffsets( Rect outRect, View view,
                                RecyclerView parent, RecyclerView.State state ) {

        // 0. the rectangle to decorate the photo should be offset by the space
        // offset is like a padding or a margin

        // 0. the rectangle to decorate the photo should be offset by the space

        outRect.left = space;
        outRect.top = space;
        outRect.right = space;
        outRect.bottom = space;

    } // end getItemOffsets

    /** Other Methods */

    /** INNER CLASSES */

} // end class GridMarginDecoration