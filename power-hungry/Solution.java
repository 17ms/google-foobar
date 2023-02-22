import java.math.BigInteger;

// https://foobar.withgoogle.com/

public class Solution {
    public static String solution(int[] xs) {
        if (xs.length == 1) {
            return Integer.toString(xs[0]);
        }

        int maxNeg = Integer.MIN_VALUE;
        int neg = 0, zero = 0;
        BigInteger prd = new BigInteger("1");

        for (int num : xs) {
            if (num == 0) {
                zero++;
                continue;
            } else if (num < 0) {
                neg++;
                maxNeg = num > maxNeg ? num : maxNeg;
            }

            prd = prd.multiply(new BigInteger(Integer.toString(num)));
        }

        if (zero == xs.length || (neg == 1 && zero == xs.length - 1)) {
            prd = new BigInteger("0");
        } else if (neg % 2 != 0) {
            prd = prd.divide(new BigInteger(Integer.toString(maxNeg)));
        }

        return String.valueOf(prd);
    }
}
