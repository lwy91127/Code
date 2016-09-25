package Sort;

import Utils.MyUtils;

/**
 * Created by lwy on 2016/8/21.
 */
public class QuickSort {
    private static void quickSort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private static void quicksort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int p = partation(arr, left, right);
        quicksort(arr, left, p - 1);
        quicksort(arr, p + 1, right);
    }

    private static int partation(int[] arr, int left, int right) {
        int pivotKey = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivotKey)
                right--;
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivotKey) {
                left++;
            }
            arr[right] = arr[left];

        }
        arr[left] = pivotKey;
        return left;
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 5, 4, 2, 6};
        quickSort(a);
        MyUtils.printVector(a);
    }
}
