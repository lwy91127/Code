package HuaWei;

import java.util.Scanner;

/**
 * Created by lwy on 2016/9/16.
 */
public class HexToDec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            if (str.length() > 2) {
                String hex = str.substring(2);
                int n = hex.length() - 1;
                long result = 0;
                for (char c : hex.toCharArray()) {
                    int x;
                    if (c >= 'A' && c <= 'F') {
                        x = c - 'A' + 10;
                    } else if (c >= 'a' && c <= 'f') {
                        x = c - 'a' + 10;
                    } else {
                        x = c - '0';
                    }
                    result += (long) (Math.pow(16, n) * x);
                    n--;
                }
                System.out.println(result);
            }
        }
    }
}
