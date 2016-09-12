package Others;

import java.util.Scanner;

/**
 * Created by lwy on 2016/9/5.
 */
public class MoveTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int r = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            double l = Math.sqrt(Math.pow((x1 - x),2) + Math.pow((y1 - y) ,2));
            System.out.println((int)Math.ceil(l / (2 * r)));
        }
    }
}
