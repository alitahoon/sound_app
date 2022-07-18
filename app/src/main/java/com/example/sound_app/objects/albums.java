package com.example.sound_app.objects;

public class albums {
    private String title;
    private int numOFSounds;

    public albums(String title, int numOFSounds) {
        this.title = title;
        this.numOFSounds = numOFSounds;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumOFSounds() {
        return numOFSounds;
    }

    public void setNumOFSounds(int numOFSounds) {
        this.numOFSounds = numOFSounds;
    }
}
