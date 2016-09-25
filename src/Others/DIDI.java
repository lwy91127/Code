package Others;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by lwy on 2016/9/23.
 */
public class DIDI {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String[] s = input.split(" ");
            long target = Long.parseLong(s[0]);
            long n = Long.parseLong(s[1]);
            if (n < 2 || n > 16)
                System.out.println("0");
            System.out.println(transfer(target, n));
        }

    }

    public static String transfer(long target, long n) {
        Stack<String> stack = new Stack<String>();
        if (target == 0 || n == 0 || n == 1)
            return "0";
        while (target != 0) {
            stack.push(transChar(target % n));
            target = target / n;
        }
        StringBuilder out = new StringBuilder();
        while (!stack.isEmpty()) {
            out.append(stack.pop());

        }
        return out.toString();
    }

    public static String transChar(long c) {
        if (c >= 10) {
            char temp = (char) ((c - 10) + 'A');
            return temp + "";
        } else {
            return c + "";
        }
    }


}
