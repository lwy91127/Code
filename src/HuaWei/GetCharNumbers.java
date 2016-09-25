package HuaWei;

import java.util.Scanner;

/**
 * Created by lwy on 2016/8/13.
 */
public class GetCharNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String oriStr = scanner.nextLine();
        String oriChar = scanner.nextLine();
        int count = 0;
        for (char c : oriStr.toCharArray()) {
            if (oriChar.toLowerCase().charAt(0) == c || oriChar.toUpperCase().charAt(0) == c)
                count++;
        }
        System.out.println(count);
    }
}
