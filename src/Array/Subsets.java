package Array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Created by lwy on 2016/6/20.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int l = nums.length ;
        for(int i = 0;i<(1<<l);i++){
            result.add(getSubset(nums,i));
        }
        return result;
    }

    private List<Integer> getSubset(int[] nums,int i){
        List<Integer> subset = new ArrayList<>();
        int index = nums.length - 1;
        int mask = 1 << index;
        while(mask > 0){
            if((i&mask) == mask){
                subset.add(nums[index]);
            }
            index --;
            mask = mask >> 1;
        }
        return subset;
    }

    @Test
    public void test(){
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
}
