package Others;

import Utils.MyUtils;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by lwy on 2016/9/12.
 */
public class PaliNums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int count = 0;
            while (!isPali(arr)) {
                int l = 0;
                int r = arr.length - 1;
                if (arr[l] < arr[r]) {
                    arr[l + 1] += arr[l];
                    arr = Arrays.copyOfRange(arr, l + 1, r + 1);
                    count++;
                } else if (arr[l] > arr[r]) {
                    arr[r - 1] += arr[r];
                    arr = Arrays.copyOfRange(arr, l, r);
                    count++;
                } else {
                    arr = Arrays.copyOfRange(arr, l + 1, r);
                }
                MyUtils.printVector(arr);
            }
            System.out.println(count);
        }
    }


    private static boolean isPali(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] != arr[right])
                return false;
            left++;
            right--;
        }
        return true;
    }
}
