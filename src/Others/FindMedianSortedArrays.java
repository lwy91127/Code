package Others;

import java.util.ArrayList;
import java.util.List;


public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int l1 = nums1.length;
        int l2 = nums2.length;
        int m = 0;
        double result = 0;
        List<Integer> s = new ArrayList<Integer>();
        if (l1 == 0 && l2 == 0) return 0;
        while (m < (l1 + l2) / 2 + 1) {
            if (i < l1 && j < l2) {
                if (nums1[i] <= nums2[j]) {
                    s.add(nums1[i]);
                    i++;
                    m++;
                } else if (j < l2 && nums1[i] > nums2[j]) {
                    s.add(nums2[j]);
                    j++;
                    m++;
                }
            } else if (i >= l1) {
                s.add(nums2[j]);
                j++;
                m++;
            } else if (j >= l2) {
                s.add(nums1[i]);
                i++;
                m++;
            }
            System.out.println(s);
        }
        System.out.println(m);

        if ((l1 + l2) % 2 == 0)
            result = (s.get(m - 1) + s.get(m - 2)) / 2.0;
        else
            result = s.get(m - 1);
        return result;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 5, 6, 7};
        int[] num2 = {1};
        double result = findMedianSortedArrays(num1, num2);
        System.out.println(result);
    }
}
