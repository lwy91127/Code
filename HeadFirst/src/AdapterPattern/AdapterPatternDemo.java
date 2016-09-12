package AdapterPattern;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by lwy on 2016/4/13.
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3","xxx.mp3");
        audioPlayer.play("mp4","xxx.mp4");
        audioPlayer.play("vlc","xxx.vlc");

        //System.out.println(reverse("asdfghjk"));
    }

    public static String reverse(String originStr){
        if(originStr == null || originStr.length() <= 1)
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }
}
