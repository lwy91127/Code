package PrototypePattern;

/**
 * Created by lwy on 2016/4/13.
 */
public class Square extends Shape {

    public Square(){
        type = "Square";
    }

    @Override
    void draw() {
        System.out.println("Draw a Square");
    }
}
