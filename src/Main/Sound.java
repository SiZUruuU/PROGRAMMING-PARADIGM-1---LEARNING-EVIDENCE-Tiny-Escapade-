package Main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {

    Clip clip;
    URL soundURL[] = new URL[30];

    public Sound(){

        soundURL[0] = getClass().getResource("/sound/Through Dark Gardens.wav");
        soundURL[1] = getClass().getResource("/sound/We Are Charlie Kirk Full Song Lyrics.wav");
        soundURL[2] = getClass().getResource("/sound/Dungeon Ambience.wav");
        soundURL[3] = getClass().getResource("/sound/Mouse Squeaking.wav");
        soundURL[4] = getClass().getResource("/sound/Grumpy Old Man.wav");
        soundURL[5] = getClass().getResource("/sound/Orb Sound Effect.wav");
        soundURL[6] = getClass().getResource("/sound/punch sfx.wav");
        soundURL[7] = getClass().getResource("/sound/miss punch sfx.wav");
        soundURL[8] = getClass().getResource("/sound/damage 1.wav");
        soundURL[9] = getClass().getResource("/sound/damage 2.wav");
        soundURL[10] = getClass().getResource("/sound/damage 3.wav");
        soundURL[11] = getClass().getResource("/sound/ghost death sfx.wav");
        soundURL[12] = getClass().getResource("/sound/2nd punch sfx.wav");
        soundURL[13] = getClass().getResource("/sound/3rd punch.wav");
        soundURL[14] = getClass().getResource("/sound/damage 3.wav");
        soundURL[15] = getClass().getResource("/sound/BUBBLE POP SOUND EFFECT.wav");
        soundURL[16] = getClass().getResource("/sound/jingling keys.wav");
        soundURL[17] = getClass().getResource("/sound/door opening.wav");
        soundURL[18] = getClass().getResource("/sound/Victory.wav");

    }

    public void setFile(int i){
        try{

            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);

        }catch(Exception e){
        }
    }

    public void play() {
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }
}
