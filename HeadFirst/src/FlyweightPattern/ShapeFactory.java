package FlyweightPattern;

import java.util.HashMap;

/**
 * Created by lwy on 2016/4/18.
 */
public class ShapeFactory {
    public static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);

        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Create circle of color:" + color);
        }
        return circle;
    }
}
