package oo2.ejercicio2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MediaPlayerTest {
    private MediaPlayer mediaPlayer;

    @BeforeEach
    public void setUp() throws Exception {
        this.mediaPlayer = new MediaPlayer();
    }

    @Test
    public void testAudio() {
        this.mediaPlayer.setMedia(new Audio());
        assertEquals("Audio", this.mediaPlayer.play());
    }

    @Test
    public void testVideoFile() {
        this.mediaPlayer.setMedia(new VideoFile());
        assertEquals("Video", this.mediaPlayer.play());
    }

    @Test
    public void testVideoStream() {
        VideoStreamAdapter adapter = new VideoStreamAdapter();
        adapter.setAdaptee(new VideoStream());
        this.mediaPlayer.setMedia(adapter);
        assertEquals("VideoStream", this.mediaPlayer.play());
    }
}
