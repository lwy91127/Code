package Others;

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s.equals("") || s == null) return 0;
        if (s.length() == 1) return 1;
        int len = s.length() - 1;
        String tempStr = s.substring(0, 1);
        ;
        int index = 1;
        int length = 0;
        while (len > 0) {
            String c = s.substring(index, index + 1);
            System.out.println(c);
            if (tempStr.indexOf(c) == -1) {
                tempStr = tempStr.concat(c);
                //System.out.println(tempStr);
                if (tempStr.length() > length)
                    length = tempStr.length();
                //System.out.println(length);
            } else {
                System.out.println(tempStr.indexOf(c));
                tempStr = tempStr.substring(tempStr.indexOf(c) + 1) + s.substring(index, index + 1);
                System.out.println(tempStr);
                if (tempStr.length() > length)
                    length = tempStr.length();
            }

            len--;
            index++;
        }
        return length;
    }

    public static void main(String[] args) {
        String s = "aa";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
