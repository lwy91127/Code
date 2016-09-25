package Others;

import java.util.Scanner;

/**
 * Created by lwy on 2016/9/12.
 */
public class GetStrs {
    public static long getDark(long n) {
        if (n == 1)
            return 3;
        if (n == 2)
            return 9;
        return 2 * getDark(n - 1) + getDark(n - 2);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(getDark(n));
        }
    }


}
