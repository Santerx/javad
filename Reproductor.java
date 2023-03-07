import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Reproductor {
    private Clip clip;
    private Thread hilo;

    public Reproductor(String archivo) {
        try {
            File file = new File(archivo);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void reproducir() {
        if (clip == null) {
            return;
        }

        if (hilo == null) {
            hilo = new Thread(new Runnable() {
                @Override
                public void run() {
                    clip.start();
                    while (clip.getFramePosition() < clip.getFrameLength()) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    detener();
                }
            });
            hilo.start();
        }
    }

    public void detener() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
        if (hilo != null) {
            hilo.interrupt();
            hilo = null;
        }
    }
}
