package game;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music {

    private static boolean mute = false;
    private static Clip clip;

    /**
     * สร้าง static method ชื่อ backgroudLoop
     */
    public static void backgroundLoop() {

        try {
            // สร้าง object AudioSystem ขึ้นมาใหม่ และ Get path file music มาใช้งาน
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("sound/kidtung.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            // FloatControl เพื่อมากำหนดเสียง
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
//            volumeControl.setValue(-1.0f); // ตั้งค่า Value sound
            muteSetting(); // method muteSetting
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    // สร้าง Method muteSetting
    public static void muteSetting() {
        if(!isMute()) { // เรียก Method ismute มาใช้ ถ้าค่าเป็น true จะลงไปทำ loop else
            clip.start(); // start music
            clip.loop(Clip.LOOP_CONTINUOUSLY); // loop music
        } else {
            clip.stop();
        }
    }

    /**
     * method isMute check boolean mute
     * @return bolean mute
     */
    public static boolean isMute() {
        return mute;
    }


    public static void setMute(boolean mute) {
        Music.mute = mute;
    }
}
