package Others;

import org.junit.Test;

/**
 * Created by lwy on 2016/4/1.
 */
public class GetLocalLess {
    public int getLocalLessIndex(int[] arr) {
        if (arr.length == 0)
            return -1;
        if (arr.length == 1 || arr[0] < arr[1])
            return 0;
        if (arr[arr.length - 1] < arr[arr.length - 2])
            return arr.length - 1;
        int left = 1;
        int right = arr.length - 2;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    @Test
    public void tesT() {
        int[] arr = {2, 1, 4, 5, 6};
        System.out.println(getLocalLessIndex(arr));
    }
}
