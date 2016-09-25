package Others;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lwy on 2016/4/6.
 */
public class FindArrayMex {
//    public int findArrayMex(int[] a ,int n){
//        int l = 0;
//        int r = n ;
//        while(l<r){
//            if(a[l] == l+1){
//                l++;
//            }
//            else if(a[l] <= l || a[l] > r || a[a[l] -1] == a[l]){
//                a[l] = a[--r];
//            }else{
//                int temp = a[l];
//                int j = a[l] - 1;
//                a[l] = a[j];
//                a[j] = a[l];
//            }
//        }
//        return l + 1;
//    }

    public int findArrayMex(int[] a, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(a[i], 1);
        }
        for (int j = 1; j <= n; j++) {
            if (!map.containsKey(j))
                return j;
        }
        return 0;
    }

    @Test
    public void test() {
        int[] a = {1, 5, 3, 0, 6, 6, 6};
        System.out.println(findArrayMex(a, 7));
    }
}
