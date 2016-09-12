package DecoratorPattern;

/**
 * Created by lwy on 2016/4/15.
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();

        Shape redCircle = new RedShapeDecorator(new Circle());

        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border color");
        circle.draw();

        System.out.println("Circle of red");
        redCircle.draw();

        System.out.println("Rectangle of red");
        redRectangle.draw();
    }
}
