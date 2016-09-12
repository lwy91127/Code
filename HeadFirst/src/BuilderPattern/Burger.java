package BuilderPattern;

/**
 * Created by lwy on 2016/4/13.
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
