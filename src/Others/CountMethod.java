package Others;

import java.util.Scanner;

/**
 * Created by lwy on 2016/9/4.
 */
public class CountMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int t = scanner.nextInt();
            int c = scanner.nextInt();
            int[] values = new int[n];
            for (int i = 0; i < n; i++) {
                values[i] = scanner.nextInt();
            }
            int count = 0;
            int sum = 0;
            for (int i = 0; i < c; i++) {
                sum += values[i];
            }
            if (sum <= t)
                count++;
            for (int i = c; i < n; i++) {
                sum += values[i] - values[i - c];
                if (sum <= t)
                    count++;

            }
            System.out.println(count);
        }
    }
}
