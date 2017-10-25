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
import com.bumptech.glide.request.RequestOptions;
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
        return gifs.size();
    }

    @Override
    public GifViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.adapter_item_gif, parent, false);
        return new GifViewHolder(v, context);
    }

    @Override
    public void onBindViewHolder(GifViewHolder holder, int position) {
        holder.bind(gifs.get(position));
    }

    public void setGifs(List<Gif> gifs) {
        this.gifs.clear();
        this.gifs.addAll(gifs);

        notifyDataSetChanged();
    }

    public static class GifViewHolder extends RecyclerView.ViewHolder {

        private Activity context;

        private ImageView previewImage;
        private ImageButton shareButton;

        private GifViewHolder(View itemView, Activity context) {
            super(itemView);

            this.context = context;

            previewImage = (ImageView) itemView.findViewById(R.id.preview_image);
            shareButton = (ImageButton) itemView.findViewById(R.id.share);
        }

        private void bind(final Gif gif) {
            Glide.with(itemView.getContext())
                    .asGif()
                    .load(gif.getGifUrl())
                    .apply(new RequestOptions().centerCrop())
                    .into(previewImage);

            shareButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // With android Marshmallow, the user grants permissions at runtime.
                    if (ContextCompat.checkSelfPermission(context,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE)
                            != PackageManager.PERMISSION_GRANTED) {

                        ActivityCompat.requestPermissions(context,
                                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                0);
                    } else {
                        new ShareGifTask(shareButton.getContext(), gif.getGifUrl()).execute();
                    }
                }
            });
        }
    }
}