package com.jlt.unsplashd.ui;

/*
 * 
 * com.jlt.unsplashd.ui
 * 
 * <one line to give the program's name and a brief idea of what it does.>
 * 
 * Copyright (C) 2016 Kairu Joshua Wambugu
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;

import com.jlt.unsplashd.R;

/**
 * Custom image view to display the photos in the grid
 * */

// begin class ForegroundImageView
public class ForegroundImageView extends ImageView {

    /* CONSTANTS */
    
    /* Integers */
    
    /* Strings */
        
    /* VARIABLES */

    /* Drawables */

    private Drawable foregroundDrawable; // ditto

    /* CONSTRUCTOR */

    // begin constructor
    // AttributeSet - A collection of attributes, as found associated with a tag in an XML document
    public ForegroundImageView( Context context, AttributeSet attrs ) {

        // 0. super things
        // 1. get an array holding the values defined by the foreground style
        // 2. get the foreground drawable from the array
        // 2a. if the drawable is there
        // 2a1. use it as the foreground
        // 3. recycle the array
        // 4. use an opaque outline for the foreground

        // 0. super things

        super( context, attrs );

        // 1. get an array holding the values defined by the foreground style

        // TypedArray - Container for an array of values that were retrieved with obtainStyledAttributes
        // obtainStyledAttributes - Retrieve styled attribute information in this Context's theme
        //  resid - The desired style resource.
        //  attrs - The desired attributes in the style.
        TypedArray typedArray = context.obtainStyledAttributes( attrs, R.styleable.ForegroundView );

        // 2. get the foreground drawable from the array

        // getDrawable - Retrieve the Drawable for the attribute at the specified index.
        final Drawable drawable = typedArray.getDrawable( R.styleable.ForegroundView_android_foreground );

        // 2a. if the drawable is there

        // 2a1. use it as the foreground

        // setForeground - Supply a Drawable to be rendered on top of all of the content in the view.
        if ( drawable != null ) { setForeground( drawable ); }

        // 3. recycle the array

        // Recycles the TypedArray, to be re-used by a later caller.
        //  After calling this, you must not ever touch the typed array again.
        typedArray.recycle();

        // 4. use an opaque outline for the foreground

        // setOutlineProvider - Sets the ViewOutlineProvider of the view,
        //  which generates the Outline that defines the shape of the shadow it casts,
        //  and enables outline clipping.
        // ViewOutlineProvider - interface used by a View to build its Outline,
        //  also used for shadow casting and clipping.
        // BOUNDS - Maintains the outline of the View to match its rectangular bounds,
        //  at 1.0f alpha. Enable Views that are opaque but lacking a background cast a shadow.
        setOutlineProvider( ViewOutlineProvider.BOUNDS );

    } // end constructor

    /* METHODS */
    
    /* Getters and Setters */
    
    /* Overrides */

    @Override
    // begin drawableStateChanged
    // called whenever the state of the view changes in such a way
    //  that it impacts the state of drawables being shown.
    protected void drawableStateChanged() {

        // 0. super things
        // 1. if there is a foreground and it needs to change state
        // 1a. change the drawable to the current state

        // 0. super things

        super.drawableStateChanged();

        // 1. if there is a foreground and it needs to change state

        // begin if there is a foreground that needs state change
        // isStateful -  whether this drawable will change its appearance based on state
        if ( foregroundDrawable != null && foregroundDrawable.isStateful() == true ) {

            // 1a. change the drawable to the current state

            // getDrawableState - Returns an array of resource IDs of the drawable states
            //  representing the current state of the view.
            foregroundDrawable.setState( getDrawableState() );

        } // end if there is a foreground that needs state change

    } // end drawableStateChanged

    @Override
    // hasOverlappingRendering
    // if this View has content which overlaps.
    public boolean hasOverlappingRendering() { return false; }

    @Override
    // begin jumpDrawablesToCurrentState
    // calls jumpToCurrentState on all Drawables and any state list animators
    // jumpToCurrentState - If this Drawable does transition animations between states,
    //  ask that it immediately jump to the current state
    //  and skip any active animations.
    public void jumpDrawablesToCurrentState() {

        // 0. super things
        // 1. if there is a foreground
        // 1a. move it immediately to its current state

        // 0. super things

        super.jumpDrawablesToCurrentState();

        // 1. if there is a foreground
        // 1a. move it immediately to its current state

        if ( foregroundDrawable != null ) { foregroundDrawable.jumpToCurrentState(); }

    } // end jumpDrawablesToCurrentState

    @Override
    // begin onSizeChanged
    // onSizeChanged - called during layout when the size of this view has changed
    // w    Current width of this view.
    // h    Current height of this view.
    // oldw Old width of this view.
    // oldh Old height of this view.
    protected void onSizeChanged( int w, int h, int oldw, int oldh ) {

        // 0. super things
        // 1. if there is a foreground drawable
        // 1a. draw it from its origin using the current width and height

        // 0. super things

        super.onSizeChanged( w, h, oldw, oldh );

        // 1. if there is a foreground drawable

        // 1a. draw it from its origin using the current width and height

        // setBounds - Specify a bounding rectangle for the Drawable
        //  where the drawable will draw when its draw() method is called.
        if ( foregroundDrawable != null ) { foregroundDrawable.setBounds( 0, 0, w, h ); }

    } // end onSizeChanged

    @Override
    // verifyDrawable
    // If your view subclass is displaying its own Drawable objects,
    //  it should override this function and return true
    //  for any Drawable it is displaying.
    //  This allows animations for those drawables to be scheduled.
    // dr - The Drawable to verify. Return true if it is one you are displaying,
    //  else return the result of calling through to the super class
    // return - If true then the Drawable is being displayed in the view;
    //  else false and it is not allowed to animate.
    protected boolean verifyDrawable( Drawable dr ) {
        return super.verifyDrawable( dr ) || ( dr == foregroundDrawable );
    }

    @Override
    // getForeground
    // Returns the drawable used as the foreground of this View.
    public Drawable getForeground() { return foregroundDrawable; }

    @Override
    // begin setForeground
    public void setForeground( Drawable foreground ) {

        // 0. if parameter drawable is not the foreground drawable
        // 0a. if the foreground drawable is there
        // 0a1. remove any animation callbacks on the foreground drawable
        // 0a2. remove any events associated with the foreground drawable
        // 0b. initialize the foreground drawable with the parameter drawable
        // 0c. if the foreground drawable exists
        // 0c1. draw it from the origin across its current width and height
        // 0c2. no drawing will be done inside this view
        // 0c3. if there is any pending state change
        // 0c3a. change to that state
        // 0d. else the foreground drawable is not existent
        // 0d1. drawing can be done inside this view
        // 0e. invalidate!

        // 0. if parameter drawable is not the foreground drawable

        // begin if foreground is not the same as foregroundDrawable
        if ( foreground != foregroundDrawable ) {

            // 0a. if the foreground drawable is there

            // begin if there is foregroundDrawable
            if ( foregroundDrawable != null ) {

                // 0a1. remove any animation callbacks on the foreground drawable

                // setCallback - Bind a Drawable.Callback object to this Drawable.
                //  Required for clients that want to support animated drawables.
                foregroundDrawable.setCallback( null );

                // 0a2. remove any events associated with the foreground drawable

                // unscheduleDrawable - Unschedule any events associated with the given Drawable.
                //  can be used when selecting a new Drawable into a view,
                //  so that the previous one is completely unscheduled.
                unscheduleDrawable( foregroundDrawable );

            } // end if there is foregroundDrawable

            // 0b. initialize the foreground drawable with the parameter drawable

            foregroundDrawable = foreground;

            // 0c. if the foreground drawable exists

            // begin if there is foregroundDrawable
            if ( foregroundDrawable != null ) {

                // 0c1. draw it from the origin across its current width and height

                foregroundDrawable.setBounds( 0, 0, getWidth(), getHeight() );

                // 0c2. no drawing will be done inside this view

                // setWillNotDraw - If this view doesn't do any drawing on its own,
                //  set this flag to allow further optimizations.
                //  Typically, if you override onDraw you should clear this flag.
                setWillNotDraw( false );

                // 0c3. if there is any pending state change

                // begin if there is state change coming
                if ( foregroundDrawable.isStateful() == true ) {

                    // 0c3a. change to that state

                    foregroundDrawable.setState( getDrawableState() );

                } // end if there is state change coming

            } // end if there is foregroundDrawable

            // 0d. else the foreground drawable is not existent
            // 0d1. drawing can be done inside this view

            else { setWillNotDraw( true ); }

            // 0e. invalidate!

            // invalidate - Invalidates the whole view. If the view is visible,
            //  onDraw will be called some time in the future.
            invalidate();

        } // end if foreground is not the same as foregroundDrawable

    } // end setForeground

    @Override
    // begin draw
    // draw - Manually render this view (and all of its children) to the given Canvas
    // Canvas - The Canvas class holds the "draw" calls.
    public void draw( Canvas canvas ) {

        // 0. super things
        // 1. if there is a foreground
        // 1a. draw on it

        // 0. super things

        super.draw( canvas );

        // 1. if there is a foreground

        // 1a. draw on it

        if ( foregroundDrawable != null ) { foregroundDrawable.draw( canvas ); }

    } // end draw

    @Override
    // begin drawableHotspotChanged
    // called whenever the view hotspot changes
    // and needs to be propagated to drawables or child views managed by the view
    public void drawableHotspotChanged( float x, float y ) {

        // 0. super things
        // 1a. if there is a foreground
        // 1a1. put the parameters as the hotspot coordinates

        // 0. super things

        super.drawableHotspotChanged( x, y );

        // 1a. if there is a foreground

        // 1a1. put the parameters as the hotspot coordinates

        if ( foregroundDrawable != null ) { foregroundDrawable.setHotspot( x, y ); }

    } // end drawableHotspotChanged

    /* Other Methods */
    
    /* INNER CLASSES */

} // end class ForegroundImageView