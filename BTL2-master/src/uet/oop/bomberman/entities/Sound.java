package uet.oop.bomberman.entities;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Sound {
    static Media media1 = new Media(new File("res/sound/Bomberman SFX1.wav").toURI().toString());
    static Media media2 = new Media(new File("res/sound/Bomberman SFX2.wav").toURI().toString());
    static Media media3 = new Media(new File("res/sound/Bomberman SFX3.wav").toURI().toString());
    static Media media4 = new Media(new File("res/sound/Bomberman SFX4.wav").toURI().toString());
    static Media media5 = new Media(new File("res/sound/Bomberman SFX5.wav").toURI().toString());
    static Media media6 = new Media(new File("res/sound/Bomberman SFX6.wav").toURI().toString());
    public static MediaPlayer di_chuyen1 = new MediaPlayer(media1);
    public static MediaPlayer di_chuyen2 = new MediaPlayer(media2);
    public static MediaPlayer dat_bom = new MediaPlayer(media3);
    public static MediaPlayer mediaPlayer4 = new MediaPlayer(media4);
    public static MediaPlayer chet = new MediaPlayer(media5);
    public static MediaPlayer chuyen_man = new MediaPlayer(media6);

}
