/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quickmathv2.Interface;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class MusicPlayer {
    private static MusicPlayer instance;
    private Clip clip;
    private Clip clip1;
    private boolean shouldPlay = true; // Flag to track if music should play automatically

    private MusicPlayer() {
        try {

            InputStream audioFile = getClass().getResourceAsStream("/quickmathv2/MusicAndIcon/puzzle-game-bright-casual-video-game-music-249202 (1).wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY); // Set looping, but start only when needed
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
    
    public void playbuttonMusic() {
        try {
            InputStream audioFile = getClass().getResourceAsStream("/quickmathv2/MusicAndIcon/click-233950.wav"); 
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip1 = AudioSystem.getClip();
            clip1.open(audioStream);
            clip1.start(); 
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
    private void stopButtonMusic() 
    {
        if (clip1 != null && clip1.isRunning()) 
        {
            clip1.stop(); 
            clip1.close(); 
        }
    }

    // Singleton instance getter
    public static MusicPlayer getInstance() {
        if (instance == null) {
            instance = new MusicPlayer();
        }
        return instance;
    }

    // Start music only if not already running and shouldPlay is true
    public void playMusic() {
        if (shouldPlay && clip != null && !clip.isRunning()) {
            clip.start();
        }
        shouldPlay = true; // Allow music to play next time if this method is called
    }

    // Stop music and set shouldPlay to false to prevent auto-playing
    public void stopMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
        shouldPlay = false; // Prevent music from playing automatically
    }

    // Check if music is playing
    public boolean isPlaying() {
        return clip != null && clip.isRunning();
    }
    
    // Check if music should play (used by main page)
    public boolean shouldPlay() {
        return shouldPlay;
    }
}
