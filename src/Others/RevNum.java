package Others;

import java.util.Scanner;

/**
 * Created by lwy on 2016/9/12.
 */
public class RevNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(revNums(revNums(x) + revNums(y)));
        }
    }

    public static int revNums(int n) {
        int res = 0;
        int l = String.valueOf(n).length();
        while (n > 0) {
            res += n % 10 * Math.pow(10, l - 1);
            n = n / 10;
            l--;
        }
        return res;
    }
}
