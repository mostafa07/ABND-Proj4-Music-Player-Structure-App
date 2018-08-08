package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static ArrayList<Song> songsList;
    private boolean pFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songsList = new ArrayList<Song>();
        songsList.add(new Song("Allah Kebeer", "Fayrouz", 4*60 + 16, R.drawable.fayrouz));
        songsList.add(new Song("Habibty", "Amr Diab", 3*60 + 47, R.drawable.amr_diab));
        songsList.add(new Song("Sotek", "Mohammed Mounir", 6*60 + 9, R.drawable.mounir));
        songsList.add(new Song("Ma'ak Alby", "Amr Diab", 3*60 + 58, R.drawable.amr_diab));
        songsList.add(new Song("Kefak Enta", "Fayrouz", 3*60 + 34, R.drawable.fayrouz));
        songsList.add(new Song("Shamandoora", "Mohammed Mounir", 3*60 + 16, R.drawable.mounir));
        songsList.add(new Song("Sarah", "Reem Banna", 5*60 + 11, R.drawable.reem_banna));
        songsList.add(new Song("Allah Ala Hobak Enta", "Amr Diab", 3*60 + 43, R.drawable.amr_diab));
        songsList.add(new Song("Lamoony Eli Gharo Meny", "Lotfy Boshnaq", 7*60 + 36, R.drawable.lotfy));
        songsList.add(new Song("Ala Mawj El Bahr", "Lena Chamamyan", 5*60 + 16, R.drawable.lena));
        songsList.add(new Song("Zedny Be Fart El Hob", "Reem Banna", 4*60 + 31, R.drawable.reem_banna));
        songsList.add(new Song("Kady El Gharam", "Lotfy Boshnaq", 4*60 + 30, R.drawable.lotfy));
        songsList.add(new Song("Lama Bada Yatathana", "Lena Chamamyan", 4*60 + 7, R.drawable.lena));

        ListView songsLV = (ListView) findViewById(R.id.main_songs_list);
        RelativeLayout lowerNowPlayingBar = (RelativeLayout) findViewById(R.id.main_lower_bar);
        final ImageButton playButton = (ImageButton) findViewById(R.id.main_play_button);
        final ImageButton nextButton = (ImageButton) findViewById(R.id.main_next_button);

        SongAdapter adapter = new SongAdapter(this, songsList);
        songsLV.setAdapter(adapter);

        songsLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song clickedSong = (Song) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, NowPlaying.class);
                intent.putExtra("song_name", clickedSong.getName());
                intent.putExtra("artist_name", clickedSong.getArtist());
                intent.putExtra("duration", clickedSong.getDuration());
                intent.putExtra("image", clickedSong.getImgResId());
                startActivity(intent);
            }
        });
        lowerNowPlayingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pFlag) {
                    playButton.setImageResource(R.drawable.ic_pause_circle_outline_white_64dp);
                    pFlag = false;
                } else {
                    playButton.setImageResource(R.drawable.ic_play_circle_outline_white_64dp);
                    pFlag = true;
                }
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

}
