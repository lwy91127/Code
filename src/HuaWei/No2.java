package HuaWei;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by lwy on 2016/9/16.
 */
public class No2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String str1 = input.split(" ")[0];
            String str2 = input.split(" ")[1];
            try {
                BigDecimal bigInteger1 = new BigDecimal(str1);
                BigDecimal bigInteger2 = new BigDecimal(str2);
                System.out.println(bigInteger1.remainder(bigInteger2));
            } catch (Exception e) {
                System.out.println("null");
            }
        }
    }
}
