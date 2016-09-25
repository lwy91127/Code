package Sort;

import Utils.MyUtils;

/**
 * Created by lwy on 2016/8/21.
 */
public class MergeSort {
    private static void mergeSort(int[] a) {
        mergesort(a, 0, a.length - 1);
    }

    private static void mergesort(int[] a, int left, int right) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            mergesort(a, left, mid);
            mergesort(a, mid + 1, right);
            merge(a, left, mid, right);
        }
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int[] temp = new int[a.length];
        int i = left, j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (a[i] <= a[j])
                temp[index++] = a[i++];
            else
                temp[index++] = a[j++];
        }

        while (i <= mid) {
            temp[index++] = a[i++];
        }
        while (j <= right) {
            temp[index++] = a[j++];
        }

        System.arraycopy(temp, 0, a, left, index);
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 5, 4, 2, 6};
        mergeSort(a);
        MyUtils.printVector(a);
    }
}
