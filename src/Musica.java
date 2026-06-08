import javax.sound.sampled.*;
import java.io.File;

class Musica {

    Clip clip;

    void reproducir() {

        try {

            File archivo = new File("Safe_Room.wav");

            AudioInputStream audio =
                    AudioSystem.getAudioInputStream(archivo);

            clip = AudioSystem.getClip();
            clip.open(audio);

            clip.start(); // Inicia la reproducción
            clip.loop(Clip.LOOP_CONTINUOUSLY); // Repetir indefinidamente

        } catch (Exception e) {

            System.out.println("Error al reproducir la música.");
            e.printStackTrace();

        }
    }
}