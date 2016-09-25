package Others;

import org.junit.Test;

/**
 * Created by lwy on 2016/4/20.
 */
public class WithoutOperator {
    private int add(int a, int b) {
        if (b == 0) return a;
        int c = a ^ b;
        //System.out.println(c);
        int d = (a & b) << 1;
        // System.out.println(d);
        return add(c, d);
    }

    private int subtract(int a, int b) {
        b = add(~b, 1);
        return add(a, b);
    }

    @Test
    public void test() {
        System.out.println(subtract(-1, 1));
    }
}
