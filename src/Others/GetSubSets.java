package Others;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by lwy on 2016/4/28.
 */
public class GetSubSets {
    public ArrayList<ArrayList<Integer>> getSubSets(int[] A,int n){
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        int k = 1 << n;
        for(int i = k-1;i>0;i--){
            ArrayList<Integer> subset = getSubSetByInt(i,A);
            results.add(subset);
        }
        return results;
    }

    private ArrayList<Integer> getSubSetByInt(int i, int[] a) {
        ArrayList<Integer> subset = new ArrayList<>();
        int index = a.length -1 ;
        int mask = 1 << index;
        while(mask > 0){
            if((i&mask) == mask)
                subset.add(a[index]);
            index--;
            mask >>= 1;
        }
        return subset;
    }

    @Test
    public void test(){
        int[] a = {123,456,789};
        System.out.println(getSubSets(a,3));
    }
}
