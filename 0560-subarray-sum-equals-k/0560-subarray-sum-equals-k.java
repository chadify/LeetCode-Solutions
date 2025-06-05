import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int curSum = 0;
        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);

        for (int n : nums) {
            curSum += n;
            int diff = curSum - k;
            res += prefixSums.getOrDefault(diff, 0);
            prefixSums.put(curSum, prefixSums.getOrDefault(curSum, 0) + 1);
        }

        return res;
    }
}