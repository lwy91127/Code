package Array;

import org.junit.Test;

/**
 *
 Given a sorted array and a target value, return the index if the target is found. If not,
 return the index where it would be if it were inserted in order.
 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0

 * Created by lwy on 2016/5/30.
 */
public class SearchInsert {
    public int searchInsert(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + ((right - left)>>1);
            if(target == nums[mid])
                return mid;
            else if(target < nums[mid]){
                right = mid - 1;
            }
            else if(target > nums[mid])
                left = mid + 1;
        }
        return left;
    }

    @Test
    public void test(){
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums,5));
        System.out.println(searchInsert(nums,2));
        System.out.println(searchInsert(nums,7));
        System.out.println(searchInsert(nums,0));

    }
}
