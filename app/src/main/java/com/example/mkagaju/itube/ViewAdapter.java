package com.example.mkagaju.itube;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import org.w3c.dom.Text;

import java.util.List;

public class ViewAdapter extends BaseAdapter {
    private final Context context;
    private final List<String>  videos;

    public ViewAdapter (Context context, List<String> videos)
    {
        this.context = context;
        this.videos = videos;
    }


    @Override
    public int getCount() {
        return videos.size();
    }

    @Override
    public Object getItem(int position) {
        return videos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final String videoID = videos.get(position);
        LayoutInflater layoutInflater;
        YouTubeThumbnailView thumbnailView;

        if(convertView == null)
        {
            layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.video_view_item, parent, false);
        }

        thumbnailView = convertView.findViewById(R.id.youtube_thumbnail);
        thumbnailView.initialize(YoutubeConfig.getApiKey(), new YouTubeThumbnailView.OnInitializedListener()
        {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, final YouTubeThumbnailLoader youTubeThumbnailLoader) {
                youTubeThumbnailLoader.setVideo(videoID);

                youTubeThumbnailLoader.setOnThumbnailLoadedListener(new YouTubeThumbnailLoader.OnThumbnailLoadedListener()
                {
                    @Override
                    public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
                        youTubeThumbnailLoader.release();
                    }

                    @Override
                    public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {
                        Log.e("Shit", "Thumbnail Error");
                    }
                });


            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
                Log.e("Shit", "Initialization Error");
            }
        });
        return thumbnailView;
    }
}
