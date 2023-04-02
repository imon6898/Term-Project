package online.judge;
import java.io.*;
import sun.audio.*;

/**
�* A simple Java sound file example (i.e., Java code to play a sound file).
�*�AudioStream and AudioPlayer code comes from a javaworld.com example.
�* @author alvin alexander, devdaily.com.
�*/
public class JavaAudioPlaySoundExample
{
    public JavaAudioPlaySoundExample() throws FileNotFoundException, IOException{
    {
    // open the sound file as a Java input stream
    String gongFile = "Music 1.wav";
    InputStream in = new FileInputStream(gongFile);
    
    // create an audiostream from the inputstream
    AudioStream audioStream = new AudioStream(in);
    
    // play the audio clip with the audioplayer class
    AudioPlayer.player.start(audioStream);
    }
    }
}