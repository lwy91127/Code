package ProxyPattern;

/**
 * Created by lwy on 2016/4/18.
 */
public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image = new RealImage("test.jpg");
        image.display();
        System.out.println();
        image.display();
    }
}
