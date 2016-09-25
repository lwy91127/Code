package Others;

import org.junit.Test;

/**
 * Created by lwy on 2016/3/1.
 */
public class ReverseString {
    public String reverse(String initString) {

        char[] chars = initString.toCharArray();
        int left = 0;
        int right = initString.length() - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return chars.toString().toString();
    }

    @Test
    public void testMain() {
        System.out.println(reverse("This is nowcoder"));
    }
}
