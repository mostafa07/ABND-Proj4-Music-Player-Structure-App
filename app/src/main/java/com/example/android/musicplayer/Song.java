package com.example.android.musicplayer;

public class Song {

    private String name;
    private String artist;
    private int duration;
    private final static int NO_IMAGE_PROVIDED = -1;
    private int imgResId = NO_IMAGE_PROVIDED;

    // Constructors
    public Song(String name, int duration) {
        this.name = name;
        this.artist = "Unknown Artist";
        this.duration = duration;
    }

    public Song(String name, String artist, int duration) {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
    }

    public Song(String name, String artist, int duration, int imgResId) {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
        this.imgResId = imgResId;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

    public int getImgResId() {
        return imgResId;
    }

    // Other methods
    public boolean hasImage() {
        return imgResId != NO_IMAGE_PROVIDED;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", duration=" + duration +
                ", imgResId=" + imgResId +
                '}';
    }
}
