package HuaWei;

import java.util.Scanner;

/**
 * Created by lwy on 2016/9/2.
 */
public class Poker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String first = line.split("-")[0];
            String second = line.split("-")[1];
            if (first.split(" ").length != second.split(" ").length) {
                if (isZhadan(first) || isTwoJoker(first) || isTwoJoker(second) || isZhadan(second)) {
                    if (isTwoJoker(first))
                        System.out.println(first);
                    else if (isTwoJoker(second))
                        System.out.println(second);
                    else if (isZhadan(first))
                        System.out.println(first);
                    else
                        System.out.println(second);

                } else {
                    System.out.println("ERROR");
                }
            } else {
                if (count(first.split(" ")[0]) > count(second.split(" ")[0]))
                    System.out.println(first);
                else
                    System.out.println(second);
            }
        }
    }

    private static int count(String str) {
        return "345678910JQKA2jokerJOKER".indexOf(str);
    }

    private static boolean isZhadan(String str) {
        String[] strings = str.split(" ");
        if (strings.length != 4)
            return false;
        String c = strings[0];
        for (String x : strings) {
            if (!x.equals(c))
                return false;
        }
        return true;
    }

    private static boolean isTwoJoker(String str) {
        String[] strings = str.split(" ");
        if (strings.length != 2)
            return false;
        for (String s : strings) {
            if (!s.equalsIgnoreCase("joker"))
                return false;
        }
        return true;
    }
}
