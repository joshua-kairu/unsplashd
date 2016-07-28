package com.jlt.unsplashd.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jlt.unsplashd.R;

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
 * Handler for RecyclerView item clicks.
 * Source is from http://www.littlerobots.nl/blog/Handle-Android-RecyclerView-Clicks/
 * */

// begin class ItemClickSupport
public class ItemClickSupport {

    /* CONSTANTS */
    
    /* Integers */
    
    /* Strings */
        
    /* VARIABLES */

    // begin private RecyclerView.OnChildAttachStateChangeListener mAttachListener
    // OnChildAttachStateChangeListener - listener attached to a recycler to get know
    // whenever a ViewHolder is attached to or detached from the recycler
    private RecyclerView.OnChildAttachStateChangeListener mAttachListener
            = new RecyclerView.OnChildAttachStateChangeListener() {

        @Override
        // begin onChildViewAttachedToWindow
        // onChildViewAttachedToWindow - Called when a view is attached to the RecyclerView
        //  view - the View attached to the RecyclerView
        public void onChildViewAttachedToWindow( View attachedView ) {

            // 0. if the view click listener is present
            // 0a. use it as the on click listener for the attached view
            // 1. if our long click listener is present
            // 1a. use it as the on long click listener for the attached view

            // 0. if the view listener is present
            // 0a. use it as the on click listener for the attached view

            if ( mOnItemClickListener != null ) {

                attachedView.setOnClickListener( mOnClickListener );

            }

            // 1. if the view long click listener is present
            // 1a. use it as the on long click listener for the attached view

            if ( mOnItemLongClickListener != null ) {

                attachedView.setOnLongClickListener( mOnLongClickListener );

            }

        } // end onChildViewAttachedToWindow

        @Override
        // onChildViewDetachedFromWindow
        //  - called when a view is detached from the recycler.
        public void onChildViewDetachedFromWindow( View view ) {}

    }; // end private RecyclerView.OnChildAttachStateChangeListener mAttachListener

    /* On Click Listeners */

    // on click listener from the View class
    // begin private View.OnClickListener mOnClickListener = new View.OnClickListener
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {

        @Override
        // begin onClick
        public void onClick( View view ) {

            // 0. get the recycler's view holder
            // 1. call the item click listener defined in our own interface

            // begin if there is an on item click listener
            if ( mOnItemClickListener != null ) {

                // 0. get the recycler's view holder

                // getChildViewHolder - Retrieve the RecyclerView.ViewHolder for the given child view.
                RecyclerView.ViewHolder viewHolder = mRecyclerView.getChildViewHolder( view );

                // 1. call the item click listener defined in our own interface

                mOnItemClickListener.onItemClicked( mRecyclerView, viewHolder.getAdapterPosition(), view );


            } // end if there is an on item click listener

        } // end onClick

    }; // end private View.OnClickListener mOnClickListener = new View.OnClickListener

    /* On Item Click Listeners */

    private OnItemClickListener mOnItemClickListener; // a click listener for items

    /* On Item Long Click Listeners */

    private OnItemLongClickListener mOnItemLongClickListener; // a click listener for long clicked items

    /* On Long Click Listeners */

    // begin private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() {

        @Override
        // begin onLongClick
        public boolean onLongClick( View view ) {

            // 0. if there exists our defined long click listener
            // 0a. get the recycler's current item's view holder
            // 0b. call our defined long click listener
            // 0c. return true
            // 1. otherwise
            // 1a. return false

            // 0. if there exists our defined long click listener

            // begin if our long click listener is around
            if ( mOnItemLongClickListener != null ) {

                // 0a. get the recycler's current item's view holder

                RecyclerView.ViewHolder viewHolder = mRecyclerView.getChildViewHolder( view );

                // 0b. call our defined long click listener

                mOnItemLongClickListener.onItemLongClicked( mRecyclerView, viewHolder.getAdapterPosition(),
                                                            view );

                // 0c. return true

                return true;

            } // end if our long click listener is around

            // 1. otherwise

            // 1a. return false

            else { return false; }

        } // end onLongClick

    }; // end private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener

    /* Recycler Views */

    private final RecyclerView mRecyclerView; // the recycler in question
    
    /* CONSTRUCTOR */

    // begin constructor
    public ItemClickSupport( RecyclerView recyclerView ) {

        // 0. initialize the recycler
        // 1. tag this recycler
        // 2. use our own attach listener for the recycler

        // 0. initialize the recycler

        mRecyclerView = recyclerView;

        // 1. tag this recycler

        // setTag - Sets a tag associated with this view and a key.
        //  A tag can be used to mark a view in its hierarchy and does not have to be unique
        //      within the hierarchy.
        //  Tags can also be used to store data within a view without
        //      resorting to another data structure.
        //  The specified key should be an id declared in the app's resources to ensure it is unique
        //      Ours was declared in the item_click_support resource
        // key - The key identifying the tag
        // tag - An Object to tag the view with
        // Thus here we associate this instance of ItemClickSupport with its local recycler view
        mRecyclerView.setTag( R.id.item_click_support, this );

        // 2. use our own attach listener for the recycler

        mRecyclerView.addOnChildAttachStateChangeListener( mAttachListener );

    } // end constructor

    /* METHODS */
    
    /* Getters and Setters */
    
    /* Overrides */
    
    /* Other Methods */

    // begin setOnItemClickListener
    public ItemClickSupport setOnItemClickListener( OnItemClickListener listener ) {

        // 0. initialize the local click listener with the parameter one
        // 1. return this ItemClickSupport

        // 0. initialize the local click listener with the parameter one

        mOnItemClickListener = listener;

        // 1. return this ItemClickSupport

        return this;

    } // end setOnItemClickListener

    // begin setOnItemLongClickListener
    public ItemClickSupport setOnItemLongClickListener( OnItemLongClickListener listener ) {

        // 0. initialize the local long click listener with the parameter one
        // 1. return this ItemClickSupport

        // 0. initialize the local long click listener with the parameter one

        mOnItemLongClickListener = listener;

        // 1. return this ItemClickSupport

        return this;

    } // end setOnItemClickListener

    // begin method detach
    private void detach( RecyclerView recyclerView ) {

        // 0. remove the attach listener from the parameter recycler
        // 1. remove the tag associating this ItemClickSupport with the parameter recycler

        // 0. remove the attach listener from the parameter recycler

        recyclerView.removeOnChildAttachStateChangeListener( mAttachListener );

        // 1. remove the tag associating this ItemClickSupport with the parameter recycler

        recyclerView.setTag( R.id.item_click_support, null );

    } // end method detach

    /* statics */

    // begin method addTo
    public static ItemClickSupport addTo( RecyclerView recyclerView ) {

        // 0. get the ItemClickSupport associated with the recycler that's in the parameters
        // 0a. if there is none
        // 0a1. create one
        // 1. return the gotten ItemClickSupport

        // 0. get the ItemClickSupport associated with the recycler that's in the parameters

        ItemClickSupport itemClickSupport = ( ItemClickSupport ) recyclerView.getTag( R.id.item_click_support );

        // 0a. if there is none
        // 0a1. create one

        if ( itemClickSupport == null ) { itemClickSupport = new ItemClickSupport( recyclerView ); }

        // 1. return the gotten ItemClickSupport

        return itemClickSupport;

    } // end method addTo

    // begin method removeFrom
    public static ItemClickSupport removeFrom( RecyclerView recyclerView ) {

        // 0. get the recycler's associated ItemClickSupport
        // 0a. if there is one
        // 0a1. detach it from the recycler
        // 1. return the gotten ItemClickSupport

        // 0. get the recycler's associated ItemClickSupport

        ItemClickSupport itemClickSupport = ( ItemClickSupport ) recyclerView.getTag( R.id.item_click_support );

        // 0a. if there is one

        // 0a1. detach it from the recycler

        if ( itemClickSupport != null ) { itemClickSupport.detach( recyclerView ); }

        // 1. return the gotten ItemClickSupport

        return itemClickSupport;

    } // end method removeFrom

    /* INNER CLASSES */

} // end class ItemClickSupport