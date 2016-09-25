package Others;

import org.junit.Test;

/**
 * Created by lwy on 2016/5/7.
 */
public class InsertSort {
    public void sort(int[] a) {
        int j;
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            for (j = i; j > 0 && temp < a[j - 1]; j--)
                a[j] = a[j - 1];
            a[j] = temp;
        }
        for (int i : a) {
            System.out.print(i);
        }
    }

    public void shellSort(int[] a) {
        int j;
        int step = a.length / 2;
        while (step >= 1) {
            for (int i = step; i < a.length; i++) {
                int temp = a[i];
                System.out.println();
                for (j = i; j >= step && temp < a[j - step]; j -= step) {
                    a[j] = a[j - step];
                }
                a[j] = temp;
            }
            step /= 2;
        }
        for (int i : a) {
            System.out.print(i);

        }
    }

    @Test
    public void test() {
        int[] a = {4, 3, 5, 1, 2, 3, 9, 8, 7};
        shellSort(a);
    }
}
