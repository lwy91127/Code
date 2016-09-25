package Others;

import org.junit.Test;

/**
 * Created by lwy on 2016/4/6.
 */
public class CalcMonoSum {
    int res = 0;

    public void calcMonoSum(int[] A, int n) {
        merge(A, 0, n - 1);
        System.out.println(res);

    }

    private void merge(int[] a, int left, int right) {
        if (left < right) {
            int mid = (right + left) / 2;
            merge(a, left, mid);
            merge(a, mid + 1, right);
            getMerge(a, left, mid, right);
            System.out.println(left + " " + right + " " + res);
        }
    }

    private void getMerge(int[] a, int left, int mid, int right) {
        int[] temp = new int[a.length];
        int i = left;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                res += a[i] * (right - j + 1);
                temp[index++] = a[i++];
            } else {
                temp[index++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = a[i++];
        }
        while (j <= right) {
            temp[index++] = a[j++];
        }
        for (int n = 0; n < index; n++) {
            a[n + left] = temp[n];
        }
    }


    @Test
    public void test() {
        int[] a = {483, 331, 69, 270, 195, 474, 582, 245, 535};
        calcMonoSum(a, 9);
    }
}
