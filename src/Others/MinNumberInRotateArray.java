package Others;

import org.junit.Test;

/**
 * Created by lwy on 2016/3/12.
 */
public class MinNumberInRotateArray {
    public int solution(int[] array){
        if(array.length == 0)
            return 0;
        int left = 0;
        int right = array.length -1;
        if(array[left] < array[right])
            return array[left];
        while(left <= right){
            if(array[left] <= array[right]){
                return array[right+1];
            }
            left++;
            right--;
        }
        return array[0];
    }

    @Test
    public void test(){
        int[] array = {3,1,2};
        System.out.println(solution(array));
    }
}
