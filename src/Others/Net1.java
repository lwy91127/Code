package Others;

import java.util.Scanner;

/**
 * Created by lwy on 2016/3/1.
 */
public class Net1 {
    private static int getGCD(int a, int b) {
        while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int initCap = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int monsterCap = sc.nextInt();
                if (initCap >= monsterCap)
                    initCap += monsterCap;
                else
                    initCap += getGCD(initCap, monsterCap);
            }
            System.out.println(initCap);
        }
    }
}



