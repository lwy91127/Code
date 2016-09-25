package Others;

import java.util.Scanner;

/**
 * Created by lwy on 2016/9/14.
 */
public class Attack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int d = sc.nextInt();
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int x3 = sc.nextInt();
            int y3 = sc.nextInt();
            int x0 = sc.nextInt();
            int y0 = sc.nextInt();
            int i = 0;
            if (Math.sqrt(Math.pow((x1 - x0), 2) + Math.pow((y1 - y0), 2)) <= d) {
                i++;
            }
            if (Math.sqrt(Math.pow((x2 - x0), 2) + Math.pow((y2 - y0), 2)) <= d) {
                i++;
            }
            if (Math.sqrt(Math.pow((x3 - x0), 2) + Math.pow((y3 - y0), 2)) <= d) {
                i++;
            }
            System.out.println(i);
        }
    }
}
