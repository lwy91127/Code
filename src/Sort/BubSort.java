package Sort;

import Utils.MyUtils;

/**
 * Created by lwy on 2016/8/21.
 */
public class BubSort {
    private static void bubSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1])
                    MyUtils.swap(arr, j, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 5, 4, 2, 6};
        bubSort(a);
        MyUtils.printVector(a);
    }
}
