package HuaWei;

import java.util.Scanner;

/**
 * Created by lwy on 2016/8/22.
 */
public class GetBottles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        n = scanner.nextInt();
        while (n != 0) {
            int result = 0;
            while (n / 3 != 0) {
                int empty = n / 3;
                int leave = n % 3;
                result += empty;
                n = leave + empty;
            }
            if ((n + 1) / 3 == 1)
                result++;
            System.out.println(result);
            n = scanner.nextInt();
        }
    }
}
