package Others;

import java.util.Scanner;

/**
 * Created by lwy on 2016/9/7.
 */
public class FindTheRabbit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int x = sc.nextInt();
            int n = sc.nextInt();
            boolean[] caves = new boolean[20];
            int i = x - 1;
            int step = 2;
            while (n > 0) {
                caves[i] = true;
                i = (i + step) % 20;
                step++;
                n--;
            }
            boolean flag = false;
            for (int j = 0; j < 20; j++) {
                if (!caves[j]) {
                    System.out.print(j + 1 + " ");
                    flag = true;
                }
            }
            if (!flag)
                System.out.print("-1");
            System.out.println();
        }
    }
}
