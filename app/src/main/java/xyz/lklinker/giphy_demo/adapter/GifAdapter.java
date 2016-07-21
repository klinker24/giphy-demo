package xyz.lklinker.giphy_demo.adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.klinker.android.simple_videoview.SimpleVideoView;

import java.util.List;

import xyz.lklinker.giphy_api.Gif;
import xyz.lklinker.giphy_demo.R;
import xyz.lklinker.giphy_demo.task.ShareGifTask;

public class GifAdapter extends RecyclerView.Adapter<GifAdapter.GifViewHolder> {

    private final Activity context;
    private final List<Gif> gifs;

    public GifAdapter(Activity context, List<Gif> gifs) {
        this.context = context;
        this.gifs = gifs;
    }

    @Override
    public int getItemCount() {
        // what should this return?
        return 0;
    }

    @Override
    public GifViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Use the LayoutInflater to create a GifViewHolder for the adapter_item_gif layout
        return null;
    }

    @Override
    public void onBindViewHolder(GifViewHolder holder, int position) {
        // bind the view holder to the gif in this position
    }

    public void setGifs(List<Gif> gifs) {
        this.gifs.clear();
        this.gifs.addAll(gifs);

        // what does this do?
        notifyDataSetChanged();
    }

    public static class GifViewHolder extends RecyclerView.ViewHolder {

        private Activity context;

        private View clickZone;
        private ImageView previewImage;
        private SimpleVideoView videoView;

        private GifViewHolder(View itemView, Activity context) {
            super(itemView);
            this.context = context;

            // find the views here
        }

        private void bind(final Gif gif) {
            // use Glide to load the gif.previewImage into the previewImage ImageView


            // add a click listener to the clickZone
            // if the video view is shown, then release it and set its visibility to gone
            // otherwise, show the video view and start playing the gif.previewMp4Url

        }

        public void stopPlayback() {
            if (videoView.getVisibility() == View.VISIBLE) {
                clickZone.performClick();
            }
        }
    }
}