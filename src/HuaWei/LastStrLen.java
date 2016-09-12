package HuaWei;

import java.util.Scanner;

/**
 * Created by lwy on 2016/8/13.
 */
public class LastStrLen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(" ");
        String lastStr = strs[strs.length - 1];
        System.out.println(lastStr.length());
    }
}
