package sample;

import javax.sound.sampled.FloatControl;

public class RadioController {
    static Radio radio;
    public static void radioRun(){
        radio = new Radio();
        radio.start();
    }
    public static void radioStop(){
        if(radio != null) {
            radio.shutdown = true;
        }
    }
    public static void setGain(float gain){
        FloatControl gainControl = (FloatControl) radio.line.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(gain);
    }
    public static float getGain(){
        return Controller.gain;
    }
}
