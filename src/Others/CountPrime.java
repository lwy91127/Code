package Others;

import org.junit.Test;

import static java.lang.Math.sqrt;

/**
 * Created by lwy on 2016/4/22.
 */
public class CountPrime {

    public int countPrime(int n) {
        if (n < 2)
            return 0;
        boolean[] isprime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (i % 2 == 0)
                isprime[i] = false;
            else {
                isprime[i] = true;
            }
        }
        for (int i = 3; i <= sqrt(n); i++) {
            if (isprime[i]) {
                for (int j = i + i; j < n; j += i) {
                    isprime[j] = false;
                }
            }
        }
        int count = 1;
        for (int i = 3; i < n; i++) {
            if (isprime[i])
                count++;
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(countPrime(10000));
    }
}
