package Alg;

import Utils.MyUtils;

import java.util.Scanner;

/**
 * Created by lwy on 2016/9/14.
 * <p>
 * 原来是要到醋溜站台乘坐醋溜快车到醋溜港”，亮亮解出了地图隐藏的秘密，赶紧奔向醋溜站台，但到了之后，亮亮忧桑地发现，
 * 从醋溜站台到醋溜港沿途的每个车站都有很多美女被他飒爽的英姿所吸引，只要经过车站就会被这些漂亮的女孩搭讪，
 * 但是现在亮亮一心想要寻找楚楚街而没空去搭理她们，所以亮亮希望在抵达醋溜港的时候被搭讪的次数最少。问亮亮抵达醋溜港最少会被搭讪多少次？
 * 输入例子:
 * 5 5
 * 0 1 1 3 6
 * 1 2
 * 1 4
 * 2 3
 * 3 5
 * 4 5
 * <p>
 * 输出例子:
 * 8
 */
public class Dijkstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt(); //公路数
            int[][] road = new int[n + 1][n + 1];
            initRoad(road);
            int[] girls = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                girls[i] = sc.nextInt();
            }
            MyUtils.printVector(girls);
            for (int i = 0; i < m; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                road[s][e] = girls[e];
                road[e][s] = girls[s];
            }
            MyUtils.print2DVector(road);
            System.out.println(getShortestPath(road, girls));
        }
    }

    private static int getShortestPath(int[][] road, int[] girls) {
        int l = girls.length;
        int[] path = new int[l];
        boolean[] isVisited = new boolean[l];
        for (int i = 2; i < l; i++) {
            path[i] = road[1][i];
        }
        path[1] = girls[1];
        isVisited[1] = true;
        for (int i = 2; i < l; i++) {
            int minDis = Integer.MAX_VALUE;
            int u = 1;
            //找出距离当前节点的最小的节点
            for (int j = 1; j < l; j++) {
                if (!isVisited[j] && path[j] < minDis) {
                    minDis = path[j];
                    u = j;
                }
            }
            isVisited[u] = true;
            //更新未遍历节点的距离值
            for (int j = 1; j < l; j++) {
                if (!isVisited[j] && road[u][j] < Integer.MAX_VALUE) {
                    int temp = path[u] + road[u][j];
                    path[j] = path[j] < temp ? path[j] : temp;
                }
            }
        }
        MyUtils.printVector(path);
        return path[l - 1] + girls[1];
    }

    private static void initRoad(int[][] road) {
        for (int i = 1; i < road.length; i++) {
            for (int j = 1; j < road.length; j++) {
                road[i][j] = Integer.MAX_VALUE;
            }
        }
    }
}
