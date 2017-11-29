package sample;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

import static sample.RadioController.radioRun;

public class Radio implements Runnable{
    private Thread t;
    private String name = "radio";
    public boolean shutdown = false;
    SourceDataLine line;
    public void play(){
        try {
            AudioInputStream in = AudioSystem.getAudioInputStream(new URL("http://wnuq.pl:8000/radio.44100"));
            AudioFormat baseFormat = in.getFormat();
            System.out.println(baseFormat.getEncoding());
            AudioFormat targetFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,baseFormat.getSampleRate(),16,baseFormat.getChannels(),baseFormat.getChannels()*2,baseFormat.getSampleRate(),false);
            AudioInputStream dataIn = AudioSystem.getAudioInputStream(targetFormat, in);
            byte[] buffer = new byte[4096];
            DataLine.Info info = new DataLine.Info(SourceDataLine.class,targetFormat);
            line = (SourceDataLine) AudioSystem.getLine(info);

            if(line != null){
                line.open();
                line.start();
                int nBytesRead = 0;
                while (nBytesRead != -1 && shutdown != true) {
                    nBytesRead = dataIn.read(buffer, 0, buffer.length);
                    if (nBytesRead != -1) {
                        line.write(buffer, 0, nBytesRead);
                    }
                }
                System.out.println("shutting down radio");

                line.drain();
                line.stop();
                line.close();

                dataIn.close();
            }

            in.close();
            if(shutdown != true){
                radioRun();
            }

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    public void start(){
        if (t == null) {
            t = new Thread (this, name);
            t.start ();
        }
    }
    @Override
    public void run() {
        play();
    }
}
