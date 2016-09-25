package Array;

import org.junit.Test;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once
 * and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p>
 * For example,
 * Given input array nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 * <p>
 * Created by lwy on 2016/6/15.
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int l = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[l]) {
                l++;
                nums[l] = nums[i];
            }
        }
        return l + 1;
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 2, 3, 3};
        System.out.println(removeDuplicates(nums));
        for (int n : nums) {
            System.out.print(n);
        }
    }
}
