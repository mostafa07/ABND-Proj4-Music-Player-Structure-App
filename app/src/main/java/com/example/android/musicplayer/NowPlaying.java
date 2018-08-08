package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;


public class NowPlaying extends AppCompatActivity {

    private boolean pFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        ImageView image = (ImageView) findViewById(R.id.now_playing_song_image);
        TextView songNameTV = (TextView) findViewById(R.id.now_playing_song_name);
        TextView artistNameTV = (TextView) findViewById(R.id.now_playing_artist_name);
        TextView totalDurationTV = (TextView) findViewById(R.id.now_playing_total_duration);

        ImageButton shuffleButton = (ImageButton) findViewById(R.id.now_playing_shuffle_button);
        ImageButton prevButton = (ImageButton) findViewById(R.id.now_playing_prev_button);
        final ImageButton playButton = (ImageButton) findViewById(R.id.now_playing_play_button);
        ImageButton nextButton = (ImageButton) findViewById(R.id.now_playing_next_button);
        ImageButton shareButton = (ImageButton) findViewById(R.id.now_playing_share_button);

        Intent intent = getIntent();
        songNameTV.setText(intent.getStringExtra("song_name"));
        artistNameTV.setText(intent.getStringExtra("artist_name"));
        image.setImageResource(intent.getIntExtra("image", R.drawable.music));
        int totalDuration = intent.getIntExtra("duration", 5*60);
        String remainSeconds = totalDuration % 60 > 10?
                String.valueOf(totalDuration % 60) : String.format("0" + totalDuration % 60);
        String duration = (totalDuration / 60) + ":" + remainSeconds;
        totalDurationTV.setText(duration);

        shuffleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pFlag) {
                    playButton.setImageResource(R.drawable.ic_pause_black_84dp);
                    pFlag = false;
                } else {
                    playButton.setImageResource(R.drawable.ic_play_arrow_black_84dp);
                    pFlag = true;
                }
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

}
