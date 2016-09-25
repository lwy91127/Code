package Others;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lwy on 2016/3/11.
 */
public class SameString {
    public boolean check(String stringA, String stringB) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : stringA.toCharArray()) {
            if (!map.containsKey(c))
                map.put(c, 1);
            else
                map.put(c, map.get(c) + 1);
        }
        for (char c : stringB.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }
        }
        for (Map.Entry e : map.entrySet()) {
            if ((int) e.getValue() > 0)
                return false;
        }
        return true;

    }

    @Test
    public void test() {
        System.out.println(check("This is nowcoder", "Are you here"));
    }
}
