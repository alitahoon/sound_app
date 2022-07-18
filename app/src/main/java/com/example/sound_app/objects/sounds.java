package com.example.sound_app.objects;

public class sounds {
    private String title;
    private String path;
    private String artist;
    private String album;


    public sounds(String title, String path, String artist, String album) {
        this.title = title;
        this.path = path;
        this.artist = artist;
        this.album = album;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
