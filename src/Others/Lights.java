package Others;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by lwy on 2016/9/8.
 * 一条长l的笔直的街道上有n个路灯，若这条街的起点为0，终点为l，第i个路灯坐标为ai，每盏灯可以覆盖到的最远距离为d，
 * 为了照明需求，所有灯的灯光必须覆盖整条街，但是为了省电，要是这个d最小，请找到这个最小的d。
 * 输入例子:
 * 7 15
 * 15 5 3 7 9 14 0
 * <p>
 * 输出例子:
 * 2.50
 */
public class Lights {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int l = sc.nextInt();
            int[] lights = new int[n];
            for (int i = 0; i < n; i++) {
                lights[i] = sc.nextInt();
            }
            Arrays.sort(lights);
            double max = Math.max(lights[0], l - lights[n - 1]);
            for (int i = 0; i < n - 1; i++) {
                double dis = (lights[i + 1] - lights[i]) / 2.0;
                max = Math.max(max, dis);
            }
            System.out.printf("%.2f\n", max);
        }
    }
}
