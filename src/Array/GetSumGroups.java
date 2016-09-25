package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lwy on 2016/9/23.
 */
public class GetSumGroups {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int sum = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(sc.nextInt());
            }
            int count = 0;
            ArrayList<ArrayList<Integer>> allsubsets = subSets(list, 0);
            for (ArrayList<Integer> subset : allsubsets) {
                int subsum = 0;
                for (int x : subset) {
                    subsum += x;
                }
                if (subsum == sum)
                    count++;
            }
            System.out.println(count);
        }
    }

    private static int getSubsetSum(int[] nums, int i) {
        int index = nums.length - 1;
        int mask = 1 << index;
        int sum = 0;
        while (mask > 0) {
            if ((i & mask) == mask) {
                sum += nums[index];
            }
            index--;
            mask = mask >> 1;
        }
        return sum;
    }

    private static ArrayList<ArrayList<Integer>> subSets(List<Integer> arr, int index) {
        ArrayList<ArrayList<Integer>> allsubsets;
        if (arr.size() == index) {
            allsubsets = new ArrayList<>();
            allsubsets.add(new ArrayList<>());
        } else {
            allsubsets = subSets(arr, index + 1);
            int item = arr.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<>();
            for (ArrayList<Integer> subset : allsubsets) {
                ArrayList<Integer> newsubset = new ArrayList<>();
                newsubset.addAll(subset);
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            allsubsets.addAll(moresubsets);
        }
        return allsubsets;
    }
}
