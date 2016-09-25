package Others;

import java.util.Scanner;

/**
 * Created by lwy on 2016/9/18.
 */
public class NetGame1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            while (n-- > 0) {
                int k = sc.nextInt();
                String str = sc.next();
                char[] chars = str.toCharArray();
                int max = 0;
                for (int i = 0; i <= str.length() - k; i++) {
                    char[] temp = chars.clone();
                    for (int j = 0; j < k; j++) {
                        if (temp[j + i] == '0')
                            temp[j + i] = '1';
                        else
                            temp[j + i] = '0';
                    }
                    max = Math.max(max, getMax(temp));
                }
                System.out.println(max);
            }
        }
    }

    private static int getMax(char[] chars) {
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            int p = i;
            while (p + 1 < chars.length && chars[p] == chars[p + 1])
                p++;
            if (chars[p] == '0')
                max = Math.max(max, p - i + 1);
            i = p;
        }
        return max;
    }
}
