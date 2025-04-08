package oo2.ejercicio2;

public class VideoStreamAdapter extends Media {
    private VideoStream adaptee;

    public void setAdaptee(VideoStream adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public String play() {
        return adaptee.reproduce();
    }
}
