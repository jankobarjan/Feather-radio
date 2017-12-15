package pl.kobarjan.featherradio;

import net.droidlabs.audio.ogg.OggStreamPlayer;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by kobarjan on 13.12.2017.
 */

public class RadioController {
    static OggStreamPlayer radio;
    public static void radioRun(){
        radio = new OggStreamPlayer();
        try {
            radio.playAsync(new URL("http://wnuq.pl:8000/radio.44100"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    public static void radioStop(){
        if(radio != null) {
            radio.stop();
            radio.shutdown = true;
        }
    }
}
