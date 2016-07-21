package xyz.lklinker.giphy_demo.activity;

import android.os.Bundle;

import xyz.lklinker.giphy_api.GiphyQueryBuilder;
import xyz.lklinker.giphy_demo.R;
import xyz.lklinker.giphy_demo.activity.base.GiphyActivity;

public class TrendsActivity extends GiphyActivity {

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // set the toolbar text to the string corresponding to R.string.trends

    }

    @Override
    protected String getGiphyQueryUrl() {
        // used in the GiphyActivity superclass
        GiphyQueryBuilder builder = new GiphyQueryBuilder(GiphyQueryBuilder.EndPoint.TRENDS);
        return builder.build();
    }
}
