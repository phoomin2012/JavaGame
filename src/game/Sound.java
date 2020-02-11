package game;

import java.applet.Applet;
import java.applet.AudioClip;
//import javafx.scene.medix.MediaPlayer;
public class Sound {


    public static final Sound sound = new Sound("sound/sound-bg.wav");





    private AudioClip music;
    //insert song
    public Sound(String filename){
        try{
            music = Applet.newAudioClip(Sound.class.getResource(filename));
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    //open sound no loop
    public void play(){
        try{
            new Thread(){
                public void run(){
                    music.play();
                }
            }.start();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    //stop sound
    public void stop(){
        try{
            new Thread(){
                public void run(){
                    music.stop();
                }
            }.start();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    //open sound loop
    public void loop(){
        try{
            new Thread(){
                public void run(){
                    music.loop();
                }
            }.start();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}