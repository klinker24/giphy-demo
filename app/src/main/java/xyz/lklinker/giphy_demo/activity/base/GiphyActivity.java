package xyz.lklinker.giphy_demo.activity.base;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import xyz.lklinker.giphy_api.Gif;
import xyz.lklinker.giphy_demo.task.GiphyTask;
import xyz.lklinker.giphy_demo.R;
import xyz.lklinker.giphy_demo.adapter.GifAdapter;

public abstract class GiphyActivity extends SearchActivity {

    protected abstract String getGiphyQueryUrl();

    private RecyclerView recyclerView;
    private GifAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set the content view to R.layout.activity_main


        // find the recycler view


        // where does this column count come from?
        int columnCount = getResources().getInteger(R.integer.column_count);

        // recycler view's need a layout manager. Common ones are LinearLayoutManager (for a simple list)
        // and GridLayoutManager for a list with multiple columns.
        // lets use a GridLayoutManager.


        // this query the Giphy API and put the GIFs into the adapter
        new GiphyTask(getGiphyQueryUrl(), new GiphyTask.Callback() {
            @Override
            public void onResponse(List<Gif> gifs) {
                // we should create the adapter before calling this, but that will be done in the next step
                // adapter.setGifs(gifs);
            }
        }).execute();


        // simply stops playing the GIFs when they are scrolled off the screen
        recyclerView.setRecyclerListener(new RecyclerView.RecyclerListener() {
            @Override
            public void onViewRecycled(RecyclerView.ViewHolder holder) {
                GifAdapter.GifViewHolder gifHolder = (GifAdapter.GifViewHolder) holder;
                gifHolder.stopPlayback();
            }
        });
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public GifAdapter getAdapter() {
        return adapter;
    }
}
