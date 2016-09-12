package Math;

import org.junit.Test;

/**
 * 168. Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p>
 * For example:
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * Created by lwy on 2016/7/26.
 */
public class ConvertToTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            n--;
            sb.append((char)('A' + n%26));
            n /= 26;
        }
        return sb.reverse().toString();
    }

    @Test
    public void test() {
        System.out.println(convertToTitle(28));
    }
}
