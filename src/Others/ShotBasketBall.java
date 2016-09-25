package Others;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lwy on 2016/9/5.
 */
public class ShotBasketBall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int p = sc.nextInt();
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            List<Integer> ball = new ArrayList<>();
            boolean found = false;
            for (int i = 0; i < n; i++) {
                if (ball.contains(a[i] % p)) {
                    System.out.println(i + 1);
                    found = true;
                    break;
                } else {
                    ball.add(a[i] % p);
                }
            }
            if (!found)
                System.out.println(-1);
        }
    }
}
