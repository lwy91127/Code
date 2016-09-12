package String;

import java.util.Stack;

/**
 * Created by lwy on 2016/9/7.
 * 写一段代码，判断一个包括'{','[','(',')',']','}'的表达式是否合法(注意看样例的合法规则。)
 * 给定一个表达式A,请返回一个bool值，代表它是否合法。
 * 测试样例：
 * "[a+b*(5-4)]*{x+b+b*(({1+2)}}"
 * 返回：true
 */
public class CheckStrLegal {
    public static boolean checkLegal(String A) {
        Stack<Character> s = new Stack<>();
        for (char c : A.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                s.push(c);
            }
            if (c == '}' || c == ']' || c == ')') {
                System.out.println(s.pop());
            }
        }
        System.out.println(s);
        return s.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(checkLegal("[a+b*(5-4)]*{x+b+b*(({1+2)}}"));
    }
}
