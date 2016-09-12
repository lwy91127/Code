package HuaWei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lwy on 2016/9/1.
 */
public class MaxGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] grades = new int[n + 1];
            int i = 1;
            while (n > 0) {
                grades[i] = scanner.nextInt();
                n--;
                i++;
            }
            while (m > 0) {
                String c = scanner.next();
                if (c.equals("Q")) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    System.out.println(getMaxBetween(grades, start, end));
                } else if (c.equals("U")) {
                    int id = scanner.nextInt();
                    int change = scanner.nextInt();
                    grades[id] = change;
                }
                m--;
            }
        }
    }

    private static int getMaxBetween(int[] grades, int start, int end) {
        if(start > 0 && end < grades.length) {
            if(start > end){
                start = start ^ end;
                end = start ^ end;
                start = start ^ end;
            }
            int max = Integer.MIN_VALUE;
            for (int i = start; i <= end; i++) {
                if(grades[i] > max)
                    max = grades[i];
            }
            return max;
        }
        return 0;
    }
}
