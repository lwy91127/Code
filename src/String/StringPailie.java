package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lwy on 2016/9/12.
 * 每组数据输入只有一行，是一个由不同的大写字母组成的字符串，已知字符串的长度在1到9之间，
 * 我们假设对于大写字母有'A' < 'B' < ... < 'Y' < 'Z'。
 * 输出这个字符串的所有排列方式，每行一个排列，要求字母序比较小的排列在前面。
 * 输入例子:
 * WHL
 * <p>
 * 输出例子:
 * HLW
 * <p>
 * HWL
 * <p>
 * LHW
 * <p>
 * LWH
 * <p>
 * WHL
 * <p>
 * WLH
 */
public class StringPailie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            char[] chars = str.toCharArray();
            List<String> l = new ArrayList<>();
            getStrs(0, chars, l);
            Collections.sort(l);
            for (String s : l) {
                System.out.println(s);
            }
        }
    }

    private static void getStrs(int start, char[] chars, List<String> l) {
        if (start == chars.length - 1) {
            StringBuilder sb = new StringBuilder();
            for (char c : chars) {
                sb.append(c);
            }
            l.add(sb.toString());
        } else {
            for (int i = start; i < chars.length; i++) {
                swap(chars, start, i);
                getStrs(start + 1, chars, l);
                swap(chars, start, i);
            }
        }

    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
