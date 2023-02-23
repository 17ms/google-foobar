import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// https://foobar.withgoogle.com/

public class Solution {
    private static List<List<Integer>> kCombinations(int[] nums, int k) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums.length < k) {
            return res;
        }

        backtrack(nums, k, 0, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int[] nums, int k, int start, List<Integer> tmp, List<List<Integer>> res) {
        if (tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtrack(nums, k, i + 1, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static int solution(int[] l) {
        int len = l.length;
        int maxNum = -1, newNum = 0;

        if (len == 1 && l[0] != 3) {
            return 0;
        }

        for (int k = len; k > 0; --k) {
            List<List<Integer>> res = kCombinations(l, k);

            for (List<Integer> nums : res) {
                int sum = nums.stream().reduce(0, Integer::sum);

                if (sum % 3 != 0) {
                    continue;
                }

                Collections.sort(nums);
                Collections.reverse(nums);

                // 4 AM beautiful creation
                newNum = Integer.parseInt(nums.stream().map(String::valueOf).collect(Collectors.joining("")));
                maxNum = newNum > maxNum ? newNum : maxNum;
            }

            if (maxNum > 0) {
                return maxNum;
            }
        }

        return 0;
    }
}
