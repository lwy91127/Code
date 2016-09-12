package PrototypePattern;

/**
 * Created by lwy on 2016/4/13.
 */
public class Circle extends Shape {

    public Circle(){
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("Draw a Circle");
    }
}
