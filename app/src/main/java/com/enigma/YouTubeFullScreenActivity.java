package com.enigma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YouTubeFullScreenActivity extends YouTubeFailureRecoveryActivity{

    private YouTubePlayerView playerView;
    private String videoId;

    private YouTubePlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube_full_screen);
        playerView = (YouTubePlayerView) findViewById(R.id.player);
        playerView.initialize("AIzaSyARMtQefE2P-MysuHbiAyZhosdtCdz-f5U", this);


        if (getIntent() != null) {
            videoId = getIntent().getStringExtra("videoId");
        }
    }

    @Override
    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return playerView;
    }



    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        this.player = player;

        player.setShowFullscreenButton(false);
        player.addFullscreenControlFlag(YouTubePlayer.FULLSCREEN_FLAG_ALWAYS_FULLSCREEN_IN_LANDSCAPE);
        if (!wasRestored && videoId != null && videoId.trim().length() > 0) {
            player.loadVideo(videoId);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        try {
            if (player != null && player.isPlaying())
                player.release();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
