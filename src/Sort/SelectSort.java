package Sort;

import Utils.MyUtils;

/**
 * Created by lwy on 2016/8/21.
 */
public class SelectSort {
    private static void selectSort(int[] arr){
        for(int i = 0;i<arr.length;i++){
            int minIndex = i;
            for(int j = i + 1;j<arr.length;j++){
                if(arr[j] < arr[minIndex])
                    minIndex = j;
            }
            if(minIndex != i)
                MyUtils.swap(arr,minIndex,i);
        }
    }

    public static void main(String[] args) {
        int[] a = {3,1,5,4,2,6};
        selectSort(a);
        MyUtils.printVector(a);
    }
}
