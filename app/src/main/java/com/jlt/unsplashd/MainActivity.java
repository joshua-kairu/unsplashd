package com.jlt.unsplashd;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.jlt.unsplashd.data.UnsplashService;
import com.jlt.unsplashd.data.model.Photo;
import com.jlt.unsplashd.ui.GridMarginDecoration;
import com.jlt.unsplashd.ui.ItemClickSupport;
import com.jlt.unsplashd.ui.OnItemClickListener;
import com.jlt.unsplashd.ui.PhotoAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.BindDimen;
import butterknife.BindInt;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
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

// begin activity MainActivity
public class MainActivity extends AppCompatActivity {

    /** CONSTANTS */

    /** Integers */

    public static final int PHOTO_COUNT = 12;

    /** Strings */

    /** VARIABLES */

    /* Photo Adapters */

    private PhotoAdapter mPhotoAdapter; // an adapter for the photos

    /* Primitives */

    @BindDimen( R.dimen.grid_item_spacing )
    int gridSpacing; // the spacing between items in the grid

    @BindInt( R.integer.photo_grid_columns )
    int photoGridColumns; // the columns in the photo grid

    /* Progress Bars */

    @Bind( android.R.id.empty )
    ProgressBar emptyProgressBar; // progress bar for when things are empty initially

    /* Recycler Views */

    @Bind( R.id.am_rv_image_grid )
    RecyclerView photoGridRecyclerView; // recycler for the photos

    /* Strings */

    private String photoUrlBase; // string to build the photo url

    /** METHODS */

    /** Getters and Setters */

    /**
     * Overrides
     */

    @Override
    // begin onCreate
    protected void onCreate( Bundle savedInstanceState ) {

        // 0. super things
        // 1. use the main activity layout
        // 2. bind items
        // 3. create a grid layout manager
        // 3a. should have the number of columns found in the resources
        // 3b. configure the space, or span, each item will occupy in the grid on a base of 6
        // 3b1. 1st, 2nd, 3rd, 5th items should cover 1 space
        // 3b2. 4th items should cover 2 spaces
        // 3b3. other, that is 6th, items should cover 3 spaces
        // 4. use this grid layout manager in the photo grid
        // 5. decorate the photo grid using the grid margin decoration
        // 6. the photo grid should have a fixed size for efficiency
        // 7. initialize the base url for the photos
        // 8. when a photo is tapped,
        // 8a. get the tapped photo
        // 8b. plan to start the details activity
        // 8b1. use the view action
        // 8b2. put the url of the photo as data
        // 8b3. send an extra with the author
        // 8b4. start details using the appropriate transition
        // 9. initialize a REST fetcher for the photos
        // 9a. use the unsplash endpoint
        // 9b. build the fetcher
        // 9c. use the unsplash service class to service this
        // 10. when the feed comes back
        // 10a. successfully
        // 10a1. initialize the photo adapter with the gotten photos
        // 10a2. use the photo adapter to populate the photo grid
        // 10a3. hide the progress bar
        // 10b. unsuccessfully
        // 10b2. log this

        // 0. super things

        super.onCreate( savedInstanceState );

        // 1. use the main activity layout

        setContentView( R.layout.activity_main );

        // 2. bind items

        ButterKnife.bind( this );

        // 3. create a grid layout manager

        // 3a. should have the number of columns found in the resources

        GridLayoutManager gridLayoutManager = new GridLayoutManager( this, photoGridColumns );

        // 3b. configure the space, or span, each item will occupy in the grid on a base of 6
        // 3b1. 1st, 2nd, 3rd, 5th items should cover 1 space
        // 3b2. 4th items should cover 2 spaces
        // 3b3. other, that is 6th, items should cover 3 spaces

        // begin gridLayoutManager.setSpanSizeLookup
        // setSpanSizeLookup - set source to get the number of spans occupied by each item
        //  in the adapter.
        gridLayoutManager.setSpanSizeLookup(

                // begin new GridLayoutManager.SpanSizeLookup
                new GridLayoutManager.SpanSizeLookup() {

                    @Override
                    // begin getSpanSize
                    // getSpanSize - returns the number of span occupied by the item at position.
                    public int getSpanSize( int position ) {

                        // 3b. configure the space, or span, each item will occupy
                        // in the grid on a base of 6

                        // begin switching the position
                        switch ( position % 6 ) {

                            // 3b1. 1st, 2nd, 3rd, 5th items should cover 1 space

                            case 0: case 1: case 2: case 4:

                                return 1;

                            // 3b2. 4th items should cover 2 spaces

                            case 5:

                                return 2;

                            // 3b3. other, that is 6th, items should cover 3 spaces

                            default:

                                return 3;

                        } // end switching the position

                    } // end getSpanSize

                } // end new GridLayoutManager.SpanSizeLookup

        ); // end gridLayoutManager.setSpanSizeLookup

        // 4. use this grid layout manager in the photo grid

        photoGridRecyclerView.setLayoutManager( gridLayoutManager );

        // 5. decorate the photo grid using the grid margin decoration

        photoGridRecyclerView.addItemDecoration( new GridMarginDecoration( gridSpacing ) );

        // 6. the photo grid should have a fixed size for efficiency

        photoGridRecyclerView.setHasFixedSize( true );

        // 7. initialize the base url for the photos

        photoUrlBase = "https://unsplash.it/" +
                getResources().getDisplayMetrics().widthPixels +
                "?image=";

        // 8. when a photo is tapped,

        // begin ItemClickSupport.addTo( photoGridRecyclerView ).setOnItemClickListener
        ItemClickSupport.addTo( photoGridRecyclerView ).setOnItemClickListener(

                // begin new ItemClickSupport.OnItemClickListener
                new OnItemClickListener() {

                    @Override
                    // begin onItemClicked
                    public void onItemClicked( RecyclerView recyclerView, int position, View view ){

                        // 8a. get the tapped photo

                        Photo photo = mPhotoAdapter.getItem( position );

                        // 8b. plan to start the details activity

                        Intent detailsActivityIntent = new Intent( MainActivity.this, DetailActivity.class );

                        // 8b1. use the view action

                        detailsActivityIntent.setAction( Intent.ACTION_VIEW );

                        // 8b2. put the url of the photo as data

                        detailsActivityIntent.setData( Uri.parse( photoUrlBase + photo.id ) );

                        // 8b3. send an extra with the author

                        detailsActivityIntent.putExtra( DetailActivity.EXTRA_AUTHOR_NAME, photo.author );

                        // 8b4. start details using the appropriate transition

                        Bundle transitionBundle = ActivityOptionsCompat.makeSceneTransitionAnimation
                                ( MainActivity.this, view, view.getTransitionName() ).toBundle();

                        MainActivity.this.startActivity( detailsActivityIntent, transitionBundle );

                    } // end onItemClicked

                } // end new ItemClickSupport.OnItemClickListener

        ); // end ItemClickSupport.addTo( photoGridRecyclerView ).setOnItemClickListener

        // 9. initialize a REST fetcher for the photos

        // RestAdapter - Adapts a Java interface to a REST API.
        UnsplashService unsplashApi = new RestAdapter.Builder()

        // 9a. use the unsplash endpoint

            // setEndpoint - set API endpoint
            .setEndpoint( UnsplashService.ENDPOINT )

        // 9b. build the fetcher

            // build - create the RestAdapter instances.
            .build()

        // 9c. use the unsplash service class to service this

            // create - Create an implementation of the API defined by the specified service interface.
            .create( UnsplashService.class );

        // 10. when the feed comes back

        // begin unsplashApi.getFeed
        unsplashApi.getFeed(

                // begin new Callback< List< Photo > >()
                // Callback - Communicates responses from a server or offline requests.
                new Callback< List< Photo > >() {

                    // 10a. successfully

                    @Override
                    // begin success
                    // success - Successful HTTP response.
                    public void success( List< Photo > photos, Response response ) {

                        // 10a1. initialize the photo adapter with the gotten photos

                        mPhotoAdapter = new PhotoAdapter( MainActivity.this, photos, photoUrlBase );

                        // 10a2. use the photo adapter to populate the photo grid

                        photoGridRecyclerView.setAdapter( mPhotoAdapter );

                        // 10a3. hide the progress bar

                        emptyProgressBar.setVisibility( View.GONE );

                    } // end success

                    // 10b. unsuccessfully

                    @Override
                    // begin failure
                    // failure -  due to network failure, non-2XX status code, or unexpected exception.
                    public void failure( RetrofitError error ) {

                        // 10b2. log this

                        Log.e( "failure: ", "RetrofitError " + error );

                    } // end failure

                } // end new Callback< List< Photo > >()

        ); // end unsplashApi.getFeed

    } // end onCreate

    /** Other Methods */

    /** INNER CLASSES */

} // end activity MainActivity