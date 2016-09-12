package Array;

import Utils.MyUtils;

/**
 * Created by lwy on 2016/9/11.
 *
 * 有一个二维数组(n*n),写程序实现从右上角到左下角沿主对角线方向打印。
 给定一个二位数组arr及题目中的参数n，请返回结果数组。
 测试样例：
 [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]],4
 返回：[4,3,8,2,7,12,1,6,11,16,5,10,15,9,14,13]
 */
public class ArrayPrint {
    public static int[] arrayPrint(int[][] arr,int n){
        int[] res = new int[n*n];
        int startX = 0; //每次遍历行开始位置
        int startY = n-1; //每次列开始位置
        int index = 0;
        while(startX < n){
            int x = startX;
            int y = startY;
            while(x < n && y < n)
                res[index++] = arr[x++][y++];
            if(startY > 0)
                startY--;
            else
                startX++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        MyUtils.printVector(arrayPrint(arr,4));
    }
}
