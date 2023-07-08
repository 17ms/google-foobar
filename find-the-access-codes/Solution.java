import java.util.Arrays;

// https://foobar.withgoogle.com/ (3)

public class Solution {
    public static void main(String[] args) {
        System.out.println(String.format("[1, 1, 1]: %d", solution(new int[] { 1, 1, 1 })));
        System.out.println(String.format("[1, 2, 3, 4, 5, 6]: %d", solution(new int[] { 1, 2, 3, 4, 5, 6 })));
    }

    public static int solution(int[] l) {
        if (l.length < 2 || l.length > 2000) {
            return 0;
        }

        // O(n^2) is the minimum requirement for the solution to pass the checks (simple
        // bruteforce being O(n^3))

        // Arrays.sort(l);
        int total = 0;
        int[] c = new int[l.length];
        Arrays.fill(c, 0);

        for (int i = 0; i < l.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (l[i] % l[j] == 0) {
                    c[i]++;
                    total += c[j];
                }
            }
        }

        return total;
    }
}
