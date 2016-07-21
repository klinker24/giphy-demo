package xyz.lklinker.giphy_demo.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import xyz.lklinker.giphy_api.GiphyQueryBuilder;
import xyz.lklinker.giphy_demo.activity.base.GiphyActivity;

public class GiphySearchActivity extends GiphyActivity {

    /**
     * Static factory method to create a search intent.
     */
    public static Intent createIntent(Context context, String searchQuery) {
        // create a new intent for this activity here.
        // you can add an extra to an intent to pass parameters between two activities.
        // use that to send the searchQuery

        return null;
    }

    private String searchQuery;

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // first fill the searchQuery field


        // then, lets set the toolbar's title to the query we just loaded
    }

    @Override
    protected String getGiphyQueryUrl() {
        // use the GiphyQueryBuilder to return a query for the search endpoint with a limit of 100

        return null;
    }
}
