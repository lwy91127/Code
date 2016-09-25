package Others;

import org.junit.Test;

/**
 * Created by lwy on 2016/4/7.
 */
public class FindMaxDivision {
    public int findMaxDivision(int[] A, int n) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < min)
                min = A[i];
            if (A[i] > max)
                max = A[i];
        }
        if (max == min)
            return 0;
        int[] Maxs = new int[n + 1];
        int[] Mins = new int[n + 1];
        boolean[] isHave = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            int bucketIndex = getBucketIndex(A[i], min, max, n);
            System.out.println(bucketIndex);
            if (isHave[bucketIndex]) {
                Maxs[bucketIndex] = Math.max(A[i], Maxs[bucketIndex]);
                Mins[bucketIndex] = Math.min(A[i], Mins[bucketIndex]);
            } else {
                Maxs[bucketIndex] = A[i];
                Mins[bucketIndex] = A[i];
                isHave[bucketIndex] = true;
            }
        }

        int i = 0;
        int lastMax = 0;
        int maxInterval = 0;
        for (; i <= n; i++) {
            if (isHave[i]) {
                lastMax = Maxs[i];
                break;
            }
        }

        for (; i <= n; i++) {
            if (isHave[i]) {
                maxInterval = Math.max(maxInterval, Mins[i] - lastMax);
                lastMax = Maxs[i];
            }
        }

        return maxInterval;
    }

    private int getBucketIndex(int num, int min, int max, int n) {
        return (num - min) * n / (max - min);
    }

    @Test
    public void test() {
//        int[] A = {9,3,1,10};
//        System.out.println(findMaxDivision(A,4));
        Person p = new child();
        System.out.println(p.name);

    }

    class Person {
        private String name = "aaa";
    }

    class child extends Person {
    }

}
