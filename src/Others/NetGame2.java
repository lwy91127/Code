package Others;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by lwy on 2016/9/18.
 */
public class NetGame2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int N = sc.nextInt();
            int L = sc.nextInt();
            int[] gifts = new int[L];
            for (int i = 0; i < L; i++) {
                gifts[i] = sc.nextInt();
            }
            boolean isA = false;
            for (int i = 0; i < N; i++) {
                int s = i;
                int e = s + N;
                isA = true;
                while (isA && e < L) {
                    isA = isUnqune(gifts, s, e);
                    s += 4;
                    e = s + N;
                }
                if (s < L)
                    isA &= isUnqune(gifts, s, L);
            }
            if (isA)
                System.out.println("CAN'T DECIDE");
            else
                System.out.println("B");
        }
    }

    private static boolean isUnqune(int[] arr, int start, int end) {
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            if (set.contains(arr[i]))
                return false;
            set.add(arr[i]);
        }
        return true;
    }
}
