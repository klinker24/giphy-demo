package xyz.lklinker.giphy_demo.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import xyz.lklinker.giphy_api.GiphyQueryBuilder;
import xyz.lklinker.giphy_demo.activity.base.GiphyActivity;

public class GiphySearchActivity extends GiphyActivity {

    private static final String ARG_SEARCH_QUERY = "arg_search_query";

    /**
     * Static factory method to create a search intent.
     */
    public static final Intent createIntent(Context context, String searchQuery) {
        Intent intent = new Intent(context, GiphySearchActivity.class);
        intent.putExtra(ARG_SEARCH_QUERY, searchQuery);

        return intent;
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getToolbar().setTitle(getIntent().getStringExtra(ARG_SEARCH_QUERY));
    }

    @Override
    protected String getGiphyQueryUrl() {
        GiphyQueryBuilder builder = new GiphyQueryBuilder(GiphyQueryBuilder.EndPoint.SEARCH)
                .setQuery(getIntent().getStringExtra(ARG_SEARCH_QUERY))
                .setLimit(100);

        return builder.build();
    }
}
