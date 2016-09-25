package BridgePattern;

/**
 * Created by lwy on 2016/4/14.
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Draw Red Circle [radius:" + radius + " x:" + x + " y:" + y + "]");
    }
}
