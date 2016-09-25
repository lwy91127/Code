package Others;

import Utils.MyUtils;
import org.junit.Test;

/**
 * Created by lwy on 2016/4/5.
 */
public class MergeSort {
    public void mergeSort(int[] a) {
        sort(a, 0, a.length - 1);
        MyUtils.printVector(a);
    }

    private void sort(int[] a, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(a, left, mid);
            sort(a, mid + 1, right);
            merge(a, left, mid, right);
        }

    }

    private void merge(int[] a, int left, int mid, int right) {
        int[] temp = new int[a.length];
        int i = left;
        int j = mid + 1;
        int tmp = 0;
        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                temp[tmp++] = a[i++];
            }
            if (a[j] <= a[i]) {
                temp[tmp++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[tmp++] = a[i++];
        }
        while (j <= right) {
            temp[tmp++] = a[j++];
        }
        System.arraycopy(temp, 0, a, 0 + left, tmp);
    }

    @Test
    public void test() {
        int[] a = {5, 1, 3, 4, 7, 6};
        mergeSort(a);
    }
}
