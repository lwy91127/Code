package String;

import java.util.Scanner;

/**
 * Created by lwy on 2016/9/6.
 * 给定一个字符串，问是否能通过添加一个字母将其变为回文串
 * <p>
 * 输入例子:
 * coco
 * <p>
 * 输出例子:
 * YES
 */
@SuppressWarnings("Duplicates")
public class AddCharPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            boolean flag = false;
            String str = sc.next();
            if (isPalindrome(str))
                System.out.println("YES");
            else {
                for (int i = 0; i < str.length(); i++) {
                    String subStr = str.substring(0, i) + str.substring(i + 1);
                    System.out.println(subStr);
                    if (isPalindrome(subStr)) {
                        System.out.println("YES");
                        flag = true;
                        break;
                    }
                }
                if (!flag)
                    System.out.println("NO");

            }
        }
    }

    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
