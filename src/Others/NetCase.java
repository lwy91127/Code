package Others;

import org.junit.Test;

import java.util.*;

/**
 * Created by lwy on 2016/8/2.
 */
public class NetCase {

    static int fileds[][];

    private static int sum(int left, int top, int right, int bottom) {
        int s = 0;
        for (int i = top; i < bottom; ++i) {
            for (int j = left; j < right; ++j) {
                s += fileds[i][j];
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String first = in.nextLine();
        int n = Integer.valueOf(first.split(" ")[0]);
        int m = Integer.valueOf(first.split(" ")[1]);
        fileds = new int[n][m];
        for (int i = 0; i < n; ++i) {
            int j = 0;
            for (char c : in.nextLine().toCharArray()) {
                fileds[i][j] = (int) c - 48;
                j++;
            }
        }
        int max_value = Integer.MAX_VALUE;
        for (int l0 = 1; l0 <= m - 3; ++l0) {
            for (int l1 = l0 + 1; l1 <= m - 2; ++l1) {
                for (int l2 = l1 + 1; l2 <= m - 1; ++l2) {
                    for (int t0 = 1; t0 <= n - 3; ++t0) {
                        for (int t1 = t0 + 1; t1 <= n - 2; ++t1) {
                            for (int t2 = t1 + 1; t2 <= n - 1; ++t2) {
                                List<Integer> sums = new ArrayList<>();
                                sums.add(sum(0, 0, l0, t0));
                                sums.add(sum(l0, 0, l1, t0));
                                sums.add(sum(l1, 0, l2, t0));
                                sums.add(sum(l2, 0, m, t0));

                                sums.add(sum(0, t0, l0, t1));
                                sums.add(sum(l0, t0, l1, t1));
                                sums.add(sum(l1, t0, l2, t1));
                                sums.add(sum(l2, t0, m, t1));

                                sums.add(sum(0, t1, l0, t2));
                                sums.add(sum(l0, t1, l1, t2));
                                sums.add(sum(l1, t1, l2, t2));
                                sums.add(sum(l2, t1, m, t2));

                                sums.add(sum(0, t2, l0, n));
                                sums.add(sum(l0, t2, l1, n));
                                sums.add(sum(l1, t2, l2, n));
                                sums.add(sum(l2, t2, m, n));
                                int min_value = getMinValue(sums);
                                if (min_value < max_value)
                                    max_value = min_value;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(max_value);
    }

    private static int getMinValue(List<Integer> sums) {
        int min = Integer.MAX_VALUE;
        for(int n :sums){
            if(n < min)
                min = n;
        }
        return min;
    }
}