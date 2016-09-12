package DecoratorPattern;

/**
 * Created by lwy on 2016/4/15.
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
