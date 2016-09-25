package Others;

/**
 * Created by lwy on 2016/9/1.
 */
public class CountBitDiff {
    public static int countBitDiff(int m, int n) {
        int diff = 0;
        while (m != 0 || n != 0) {
            int mm = m % 2;
            int nn = n % 2;
            if (mm != nn)
                diff++;
            m = m / 2;
            n = n / 2;
        }
        return diff;
    }

    public static void main(String[] args) {
        System.out.println(countBitDiff(1999, 2299));
    }
}
