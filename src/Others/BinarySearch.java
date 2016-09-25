package Others;

import java.util.Scanner;

/**
 * Created by lwy on 2016/9/17.
 */
public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int x = sc.nextInt();
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int res = binarySearch(a, x);
            if (res != -1)
                System.out.println(res);
            else {
                int i = 0;
                for (; i < n; i++) {
                    if (a[i] > x) {
                        break;
                    }
                }
                System.out.println(res - i);
            }
        }
    }

    public static int binarySearch(int[] arr, int target) {
        int l = 0;
        int h = arr.length - 1;
        while (l <= h) {
            int middle = l + ((h - l) >> 1);
            if (target == arr[middle]) {
                return middle;
            } else if (target < arr[middle]) {
                h = middle - 1;
            } else {
                l = middle + 1;
            }
        }
        return -1;
    }


}
