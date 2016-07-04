package xyz.lklinker.giphy_tool.activity;

import android.os.Bundle;

import xyz.lklinker.giphy_api.GiphyQueryBuilder;
import xyz.lklinker.giphy_tool.R;
import xyz.lklinker.giphy_tool.activity.base.GiphyActivity;

public class TrendsActivity extends GiphyActivity {

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toolbar.setTitle(getString(R.string.trends));
    }
    @Override
    protected String getGiphyQueryUrl() {
        GiphyQueryBuilder builder = new GiphyQueryBuilder(GiphyQueryBuilder.EndPoint.TRENDS);
        return builder.build();
    }
}
