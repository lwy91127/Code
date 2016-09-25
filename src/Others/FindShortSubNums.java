package Others;

import org.junit.Test;

/**
 * Created by lwy on 2016/4/1.
 */
public class FindShortSubNums {
    public int findShortest(int[] A, int n) {
        // write code here
        int max = A[0];
        int l = 0;
        for (int i = 1; i < n; i++) {
            if (max > A[i]) {
                l = i;
                System.out.println(l);
            } else {
                max = A[i];
            }
        }
        int min = A[n - 1];
        int r = 0;
        for (int j = n - 2; j >= 0; j--) {
            if (min < A[j])
                r = j;
            else
                min = A[j];
        }
        if (l == 0 && r == 0)
            return 0;
        System.out.println(l + " " + r);
        return l - r + 1;
    }

    @Test
    public void test() {
        int[] a = {1, 5, 3, 4, 2, 6, 7};
        System.out.println(findShortest(a, 6));
    }
}
