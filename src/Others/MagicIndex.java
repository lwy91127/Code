package Others;

import org.junit.Test;

/**
 * Created by lwy on 2016/4/28.
 */
public class MagicIndex {
    public boolean findMagicIndex(int[] A,int n){
        if(n == 0)
            return false;
        return find(A,0,n-1);
    }

    private boolean find(int[] arr,int start,int end){
        if(start<0 || end < start || end >= arr.length){
            return false;
        }

        int mid = start + ((end - start) >> 1);
        System.out.println(start + "   " + end + "   " + mid);
        if(mid == arr[mid])
            return true;

        int left = Math.min(arr[mid],mid - 1);
        if(find(arr,start,left))
            return true;

        int right = Math.max(arr[mid],mid+1);
        return find(arr,right,end);
    }

    @Test
    public void test(){
        int[] a = {1,1,3,4,5};
        System.out.println(findMagicIndex(a,5));
    }
}
