package Array;

import Utils.MyUtils;

/**
 * Created by lwy on 2016/9/23.
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class SortArray {
    public static void reOrderArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] % 2 == 1 && array[j - 1] % 2 == 0)
                    MyUtils.swap(array, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 3, 4, 6, 7, 9, 1};
        reOrderArray(a);
        MyUtils.printVector(a);
    }
}
