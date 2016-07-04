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
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, getResources().getInteger(R.integer.column_count)));

        adapter = new GifAdapter(this, new ArrayList<Gif>());
        recyclerView.setAdapter(adapter);

        new GiphyTask(getGiphyQueryUrl(), new GiphyTask.Callback() {
            @Override
            public void onResponse(List<Gif> gifs) {
                adapter.setGifs(gifs);
            }
        }).execute();

        recyclerView.setRecyclerListener(new RecyclerView.RecyclerListener() {
            @Override
            public void onViewRecycled(RecyclerView.ViewHolder holder) {
                GifAdapter.GifViewHolder gifHolder = (GifAdapter.GifViewHolder) holder;
                gifHolder.stopPlayback();
            }
        });
    }
}
