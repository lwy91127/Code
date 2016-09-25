package AdapterPattern;

/**
 * Created by lwy on 2016/4/13.
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "xxx.mp3");
        audioPlayer.play("mp4", "xxx.mp4");
        audioPlayer.play("vlc", "xxx.vlc");
    }
}
