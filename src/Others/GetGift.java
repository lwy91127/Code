package Others;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lwy on 2016/9/8.
 */
public class GetGift {
    public static int getValue(int[] gifts,int n){
        Map<Integer,Integer> map = new HashMap();
        for(int i :gifts){
            if(map.containsKey(i)){
                int count = map.get(i) + 1;
                if(count > n/2)
                    return i;
                map.put(i,count);
            }
            else {
                map.put(i, 1);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,2,2};
        System.out.println(getValue(a,5));
    }
}
