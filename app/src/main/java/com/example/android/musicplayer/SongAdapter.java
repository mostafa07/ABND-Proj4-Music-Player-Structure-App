package com.example.android.musicplayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class SongAdapter extends ArrayAdapter<Song> {

    // Constructor
    public SongAdapter(@NonNull Context context, @NonNull ArrayList<Song> songsList) {
        super(context, 0, songsList);
    }

    // Overridden methods
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.song_list_item, parent, false);
        }

        Song currentSong = getItem(position);

        ImageView image = (ImageView) convertView.findViewById(R.id.list_item_song_image);
        TextView songName = (TextView) convertView.findViewById(R.id.list_item_song_name);
        TextView artistName = (TextView) convertView.findViewById(R.id.list_item_artist_name);

        songName.setText(currentSong.getName());
        artistName.setText(currentSong.getArtist());

        if (currentSong.hasImage()) {
            image.setImageResource(currentSong.getImgResId());
            image.setVisibility(View.VISIBLE);
        } else {
            image.setImageResource(R.drawable.music);
            image.setVisibility(View.VISIBLE);
        }

        return convertView;
    }
}
