package HuaWei;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lwy on 2016/9/16.
 */
public class PinyinToNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        init(map);
        while (sc.hasNext()) {
            String py = sc.next();
            Matcher matcher = Pattern.compile("([A-Z][a-z]+)").matcher(py);
            List<String> list = new ArrayList<>();
            while (matcher.find()) {
                list.add(matcher.group(1));
            }
            int result = 0;
            int num = 0;
            int mult = 0;
            for (int i = 0; i < list.size(); i++) {
                String tmp = list.get(i);
                if (isNumber(tmp)) {
                    num += map.get(tmp);
                    if (i == list.size() - 1) {
                        result += num;
                    }
                } else {
                    mult = map.get(tmp);
                    if (mult == 10 && num == 0) {
                        num = 1;
                    }
                    result += num * mult;
                    num = 0;
                    mult = 0;
                }
            }
            System.out.println(result);
        }
    }

    private static void init(Map<String, Integer> map) {
        map.put("Ling", 0);
        map.put("Yi", 1);
        map.put("Er", 2);
        map.put("San", 3);
        map.put("Si", 4);
        map.put("Wu", 5);
        map.put("Liu", 6);
        map.put("Qi", 7);
        map.put("Ba", 8);
        map.put("Jiu", 9);
        map.put("Shi", 10);
        map.put("Bai", 100);
        map.put("Qian", 1000);
        map.put("Wan", 10000);
    }

    private static boolean isNumber(String number) {
        if (number.equals("Yi") ||
                number.equals("Er") ||
                number.equals("San") ||
                number.equals("Si") ||
                number.equals("Wu") ||
                number.equals("Liu") ||
                number.equals("Qi") ||
                number.equals("Ba") ||
                number.equals("Jiu"))
            return true;
        else
            return false;
    }
}
