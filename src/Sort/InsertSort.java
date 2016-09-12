package Sort;

import Utils.MyUtils;

/**
 * Created by lwy on 2016/8/21.
 */
public class InsertSort {
    private static void insertSort(int[] arr){
        int j;
        for(int i = 1;i<arr.length;i++){
            int head = arr[i];
            for(j = i;j > 0 && arr[j - 1] > head;j--){
                arr[j] = arr[j-1];
            }
            arr[j] = head;
        }
    }

    public static void main(String[] args) {
        int[] a = {3,1,5,4,2,6};
        insertSort(a);
        MyUtils.printVector(a);
    }
}

