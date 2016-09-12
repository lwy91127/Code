package Utils;

/**
 * Created by lwy on 2016/4/5.
 */
public class MyUtils {
    public static void printVector(char[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }
    public static void printVector(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }
    public static void printVector(boolean[] arr){
        for(boolean b:arr){
            System.out.print(b);
        }
        System.out.println();
    }

    public static void printVector(String[] arr){
        for(String b:arr){
            System.out.print(b + " ");
        }
        System.out.println();
    }

    public static void print2DVector(int[][] arr){
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print2DVector(double[][] arr){
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void swap(int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
