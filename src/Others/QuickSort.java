package Others;

import Utils.MyUtils;
import org.junit.Test;

/**
 * Created by lwy on 2016/4/5.
 */
public class QuickSort {

    public void quicksort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(int[] a, int start, int end) {
        if (end <= start)
            return;
        int p = partition(a, start, end);
        sort(a, start, p - 1);
        sort(a, p + 1, end);
    }

    private int partition(int[] a, int start, int end) {
        int value = a[start];
        int l = start;
        int r = end + 1;
        while (true) {
            while (a[++l] < value) {
                if (l == end)
                    break;
            }
            while (a[--r] > value) {
                if (r == start)
                    break;
            }
            if (l >= r)
                break;
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
        }
        int temp = a[start];
        a[start] = a[r];
        a[r] = temp;
        MyUtils.printVector(a);
        return r;
    }

    @Test
    public void test() {
        int[] a = {4, 5, 3, 1, 2, 0};
        quicksort(a);
    }
}
