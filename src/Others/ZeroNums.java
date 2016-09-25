package Others;

import java.util.Scanner;

/**
 * Created by lwy on 2016/9/18.
 */
public class ZeroNums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(getZeroNums(n));
        }
    }

    private static int getZeroNums(int n) {
        if (n < 5)
            return 0;
        else {
            n /= 5;
            return n + getZeroNums(n);
        }
    }
}
