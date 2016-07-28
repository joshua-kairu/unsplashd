package com.jlt.unsplashd;

import android.os.Build;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.BindInt;
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

/**
 * Displays the details of each picture
 * */
// begin activity DetailActivity
public class DetailActivity extends AppCompatActivity {

    /* CONSTANTS */
    
    /* Integers */
    
    /* Strings */

    public static final String EXTRA_AUTHOR_NAME = "EXTRA_AUTHOR_NAME"; // the author name extra

    
    /* VARIABLES */

    /* Image Views */

    @Bind( R.id.ad_ttiv_photo )
    ImageView threeTwoImageView; // the 3:2 image view

    /* Primitives */

    @BindInt( R.integer.detail_description_slide_duration )
    int slideDuration; // ditto

    /* Text Views */

    @Bind( R.id.ad_tv_author )
    TextView authorTextView; // ditto

    /* Toolbars */

    @Bind( R.id.ad_tb_toolbar )
    Toolbar toolbar; // the toolbar

    /* METHODS */

    /* Getters and Setters */

    /* Overrides */

    @Override
    // begin onCreate
    protected void onCreate( Bundle savedInstanceState ) {

        // 0. super things
        // 1. use the detail layout
        // 2. bind things
        // 3. show the image
        // 3a. using the uri from the intent
        // 3b. using the place holder color
        // 3c. into the correct view
        // 4. set author text from intent
        // 5. when the back toolbar button is tapped
        // 5a. close activity after transition is done
        // 6. for lollipop devices
        // 6a. slide description from bottom

        // 0. super things

        super.onCreate( savedInstanceState );

        // 1. use the detail layout

        setContentView( R.layout.activity_detail );

        // 2. bind things

        ButterKnife.bind( this );

        // 3. show the image

        Picasso.with( this )

        // 3a. using the uri from the intent

            .load( getIntent().getData() )

        // 3b. using the place holder color

            .placeholder( R.color.colorPlaceholder )

        // 3c. into the correct view

            .into( threeTwoImageView );

        // 4. set author text from intent

        authorTextView.setText( getString( R.string.author_name,
                getIntent().getStringArrayExtra( EXTRA_AUTHOR_NAME ) ) );

        // 5. when the back toolbar button is tapped

        // begin toolbar.setNavigationOnClickListener
        toolbar.setNavigationOnClickListener(

                // begin new View.OnClickListener
                new View.OnClickListener() {

                    @Override
                    // begin onClick
                    public void onClick( View view ) {

                        // 5a. close activity after transition is done

                        finishAfterTransition();

                    } // end onClick

                } // end new View.OnClickListener

        ); // end toolbar.setNavigationOnClickListener

        // 6. for lollipop devices

        // begin if lollipop and above
        if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ) {

            // 6a. slide description from bottom

            Slide slide = new Slide( Gravity.BOTTOM );

            slide.addTarget( R.id.ad_ll_description );

            slide.setInterpolator( new FastOutSlowInInterpolator() );

            slide.setDuration( slideDuration );

            getWindow().setEnterTransition( slide );

        } // end if lollipop and above

    } // end onCreate
    
    /* Other Methods */
    
    /* INNER CLASSES */

} // end activity DetailActivity