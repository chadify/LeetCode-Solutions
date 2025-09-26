class Solution {
    public boolean canPartition(int[] nums) {
       int totalSum = 0;
       for (int i : nums) totalSum += i;
       if (totalSum % 2 != 0) return false;
       int target = totalSum/2;
       return isSubsetSum(nums, target);
    }

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        boolean[] prev = new boolean[sum+1];

        prev[0] = true;
        if (arr[0] <= sum) prev[arr[0]] = true;
        for (int i = 1; i < n; i++) {
            boolean[] cur = new boolean[sum+1];
            cur[0] = true;
            for (int j = 1; j <= sum; j++) {
                boolean notTake = prev[j]; // dp[n][sum]
                boolean take = false;
                if (arr[i] <= j) take = prev[j-arr[i]];
                cur[j] = (notTake || take);
            }
            prev = cur;
        }
        
        return prev[sum];
    }

}