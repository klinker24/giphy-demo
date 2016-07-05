package xyz.lklinker.giphy_demo.adapter;

import android.content.Context;
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

    private final Context context;
    private final List<Gif> gifs;

    public GifAdapter(Context context, List<Gif> gifs) {
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
        return new GifViewHolder(v);
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

        private View clickZone;
        private ImageView previewImage;
        private ImageButton shareButton;
        private SimpleVideoView videoView;

        public GifViewHolder(View itemView) {
            super(itemView);
            clickZone = itemView.findViewById(R.id.touch_effect);
            previewImage = (ImageView) itemView.findViewById(R.id.preview_image);
            shareButton = (ImageButton) itemView.findViewById(R.id.share);
            videoView = (SimpleVideoView) itemView.findViewById(R.id.video_view);
        }

        public void bind(final Gif gif) {
            Glide.with(itemView.getContext()).load(gif.getPreviewImageUrl()).centerCrop().into(previewImage);

            shareButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new ShareGifTask(shareButton.getContext(), gif.getGifUrl()).execute();
                }
            });

            clickZone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (videoView.getVisibility() == View.VISIBLE) {
                        videoView.release();
                        videoView.setVisibility(View.GONE);
                    } else {
                        videoView.setVisibility(View.VISIBLE);
                        videoView.start(gif.getPreviewMp4Url());
                    }
                }
            });
        }

        public void stopPlayback() {
            if (videoView.getVisibility() == View.VISIBLE) {
                videoView.release();
                videoView.setVisibility(View.GONE);
            }
        }
    }
}