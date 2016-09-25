package Others;

public class StringtoInteger {
    public static int atoi(String str) {

        int result = 0;
        boolean negative = false;
        int len = str.length();
        int i = 0;
        if (str == null)
            return 0;
        if (len > 0) {
            char firstChar = str.charAt(i);
            while (firstChar == ' ' && i < len) {
                i++;
                firstChar = str.charAt(i);
            }
            System.out.println(i);
            if (firstChar < '0') {
                if (firstChar == '-') {
                    negative = true;
                } else if (firstChar != '+')
                    return 0;
                if (len - 1 == i)
                    return 0;
                i++;
            }
            System.out.println(i + " " + negative);
            while (i < len) {
                int digit = Character.digit(str.charAt(i++), 10);
                System.out.println(result + "  " + Integer.MAX_VALUE);
                if (digit < 0)
                    break;
                System.out.println(digit);
                if (Integer.MAX_VALUE / 10 < result || (Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < digit))
                    return negative == false ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                result = result * 10 + digit;
            }
        } else {
            return 0;
        }
        return negative ? -result : result;
    }

    public static void main(String[] args) {
        String s = "2147483648";
        System.out.println(atoi(s));
    }
}
