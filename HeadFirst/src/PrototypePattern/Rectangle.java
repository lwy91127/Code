package PrototypePattern;

/**
 * Created by lwy on 2016/4/13.
 */
public class Rectangle extends Shape {

    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Draw a Rectangle");
    }
}
