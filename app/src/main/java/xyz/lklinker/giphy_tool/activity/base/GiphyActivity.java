package xyz.lklinker.giphy_tool.activity.base;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import xyz.lklinker.giphy_api.Gif;
import xyz.lklinker.giphy_tool.GiphyTask;
import xyz.lklinker.giphy_tool.R;
import xyz.lklinker.giphy_tool.adapter.DividerItemDecoration;
import xyz.lklinker.giphy_tool.adapter.GifAdapter;

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
