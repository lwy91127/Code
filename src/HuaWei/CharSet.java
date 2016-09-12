package HuaWei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by lwy on 2016/9/6.
 * 输入一个字符串，求出该字符串包含的字符集合
 输入例子:
 abcqweracb

 输出例子:
 abcqwer
 */
public class CharSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.next();
            Set<Character> charSet = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for(char c:str.toCharArray()){
                if(!charSet.contains(c)){
                    sb.append(c);
                    charSet.add(c);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
