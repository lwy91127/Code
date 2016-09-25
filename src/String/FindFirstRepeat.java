package String;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lwy on 2016/9/2.
 */
public class FindFirstRepeat {
    private static char findFirstRepeat(String str, int n) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (set.contains(c))
                return c;
            else {
                set.add(c);
            }
        }
        return '1';
    }
}
