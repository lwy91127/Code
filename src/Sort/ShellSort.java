package Sort;

import Utils.MyUtils;

/**
 * Created by lwy on 2016/8/21.
 */
public class ShellSort {
    private static void shellSort(int[] arr){
        int j,step = arr.length / 2;
        while(step >= 1){
            for(int i = step;i< arr.length ; i ++){
                int head = arr[i];
                for(j = i; j>=step && head < arr[j-step] ; j-=step){
                    arr[j] = arr[j-step];
                }
                arr[j] = head;
            }
            step /= 2;
        }
    }

    public static void main(String[] args) {
        int[] a = {3,1,5,4,2,6};
        shellSort(a);
        MyUtils.printVector(a);
    }
}
