package Array;

/**
 * Created by lwy on 2016/9/2.
 */
public class BinarySearch {
    private static int getPos(int[] A, int n, int val){
        int left = 0;
        int right = n - 1;
        int result = -1;
        while(left <= right){
            int mid = left + ((right - left)>>1);
            if(A[mid] == val) {
                result = mid;
                break;
            }
            else if(A[mid] > val){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        for(int i = result;i>=0;i--){
            if(A[i] == val)
                result = i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {4,4,10,21};
        System.out.println(getPos(a,4,4));
    }


}
