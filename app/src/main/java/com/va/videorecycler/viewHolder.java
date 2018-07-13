package com.va.videorecycler;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.android.exoplayer2.ui.PlayerView;

import java.util.List;

import im.ene.toro.ToroPlayer;
import im.ene.toro.ToroUtil;
import im.ene.toro.exoplayer.ExoPlayerViewHelper;
import im.ene.toro.media.PlaybackInfo;
import im.ene.toro.widget.Container;

public class viewHolder extends RecyclerView.ViewHolder implements ToroPlayer {
    public PlayerView playerView;
    public ExoPlayerViewHelper helper;
    private Uri mediaUri;

    public viewHolder(View itemView) {
        super(itemView);
        playerView = itemView.findViewById(R.id.playerView);

    }


    public void onBind(RecyclerView.Adapter adapter, Uri uri, List<Object> payload) {
        if (uri != null) {
            mediaUri = uri;
        }
    }


    @NonNull
    @Override
    public View getPlayerView() {
        return playerView;

    }

    @NonNull
    @Override
    public PlaybackInfo getCurrentPlaybackInfo() {
        return helper != null ? helper.getLatestPlaybackInfo() : new PlaybackInfo();
    }

    @Override
    public void initialize(@NonNull Container container, @NonNull PlaybackInfo playbackInfo) {
        if (helper == null) {
            helper = new ExoPlayerViewHelper(this, mediaUri);
        }
        helper.initialize(container, playbackInfo);
    }

    @Override
    public void play() {
        if (helper != null) {
            helper.play();
        }
    }

    @Override
    public void pause() {
        if (helper != null) {
            helper.pause();
        }
    }

    @Override
    public boolean isPlaying() {
        return helper != null && helper.isPlaying();
    }

    @Override
    public void release() {
        if (helper != null) {
            helper.release();
        }
        helper = null;
    }

    @Override
    public boolean wantsToPlay() {
        return ToroUtil.visibleAreaOffset(this, itemView.getParent()) >= 0.85;
    }

    @Override
    public int getPlayerOrder() {
        return getAdapterPosition();
    }
}