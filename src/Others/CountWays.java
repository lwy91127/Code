package Others;

import org.junit.Test;

/**
 * Created by lwy on 2016/4/26.
 */
public class CountWays {
    public int countWays(int x, int y) {
        // write code here
        return getJieCheng(x + y - 2) / (getJieCheng(x - 1) * getJieCheng(y - 1));
    }

    private int getJieCheng(int n) {
        if (n <= 1)
            return 1;
        return getJieCheng(n - 1) * n;
    }

    @Test
    public void test() {
        System.out.println(countWays(3, 3));
    }
}
