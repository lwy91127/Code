package Math;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * <p>
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * <p>
 * For example,
 * <p>
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 * Created by lwy on 2016/6/14.
 */
public class FractionToDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        Map<Long, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        long numer = (long) numerator;
        long den = (long) denominator;
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
            numer = Math.abs(numer);
            den = Math.abs(den);
        }
        long n = numer / den;
        long reminder = numer % den;
        result.append(n);
        if (reminder == 0)
            return result.toString();
        result.append(".");
        while (reminder != 0) {
            map.put(reminder, result.length());
            reminder *= 10;
            result.append(reminder / den);
            reminder = reminder % den;
            if (map.containsKey(reminder)) {
                result.insert(map.get(reminder), "(");
                result.append(")");
                break;
            }

        }
        return result.toString();

    }

    @Test
    public void test() {
        System.out.println(fractionToDecimal(7, -12));
    }
}
