package Others;

import org.junit.Test;

/**
 * Created by lwy on 2016/3/13.
 */
public class ZipString {
    public String solution(String iniString) {
        if (iniString == null || iniString.length() == 0) {
            return iniString;
        }
        StringBuilder result = new StringBuilder();
        char last = iniString.charAt(0);
        int count = 0;
        for (char c : iniString.toCharArray()) {
            if (c == last) {
                count++;
            } else {
                result.append(last);
                result.append(count);
                last = c;
                count = 1;
            }
        }
        result.append(last);
        result.append(count);
        if (result.length() < iniString.length())
            return result.toString();
        return iniString;
    }

    @Test
    public void test() {
        System.out.println(solution("welcometonowcoderrrrrrrrrrrrrrrrrrrrrrr"));
    }
}
