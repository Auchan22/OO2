package oo2.ejercicio2;

public class MediaPlayer {
    private Media media;

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public String play() {
        return this.media.play();
    }
}
