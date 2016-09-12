package BridgePattern;

/**
 * Created by lwy on 2016/4/14.
 */
public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Draw Green Circle [radius:" + radius + " x:" + x + " y:" + y);
    }
}
