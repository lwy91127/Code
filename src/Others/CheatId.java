package Others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lwy on 2016/9/8.
 */
public class CheatId {
    static List<Integer> getResult(int n, int[][] map) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i <= n; i++) {
            int cnt = 0;
            for (int j = 0; j <= n; j++) {
                if (map[i][j] == 1 && map[j][i] == 1 && i != j) {
                    if (!list.contains(i)) {
                        list.add(i);
                    }
                }
                if (map[i][j] == 1 && i != j && list.contains(j))
                    cnt++;
                if (cnt >= 2) {
                    if (!list.contains(i)) {
                        list.add(i);
                    }
                }
            }
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            /*
             n:问题个数
             m[i]:提出问题i的人的编号
             p[i]:回答问题i的人数
             map[i][j]=1:j回答了i的问题
             */
            int n = in.nextInt();
            int m[] = new int[n];
            int p[] = new int[n];
            int map[][] = new int[n + 1][n + 1];
            for (int i = 0; i < n; i++) {
                m[i] = in.nextInt();
                p[i] = in.nextInt();
                for (int j = 0; j < p[i]; j++) {
                    int num = in.nextInt();
                    map[m[i]][num] = 1;
                }
            }
            List<Integer> list = getResult(n, map);
            System.out.println(list.size());
            for (int i = 0; i < list.size() - 1; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println(list.get(list.size() - 1));
        }
    }
}
