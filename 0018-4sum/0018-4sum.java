class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(4, nums, 0, (long) target);
    }
    
    private List<List<Integer>> kSum(int k, int[] nums, int start, long target) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        
        if (k != 2) {
            // k > 2 case
            for (int i = start; i < nums.length - k + 1; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;  // Skip duplicates
                }
                curr.add(nums[i]);
                List<List<Integer>> subsets = kSum(k - 1, nums, i + 1, target - nums[i]);
                for (List<Integer> subset : subsets) {
                    List<Integer> temp = new ArrayList<>(curr);
                    temp.addAll(subset);
                    res.add(temp);
                }
                curr.remove(curr.size() - 1);
            }
            return res;
        }
        
        // k == 2 case (two sum)
        int left = start, right = nums.length - 1;
        while (left < right) {
            long sum = (long) nums[left] + nums[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;  // Fixed: decrement right instead of increment
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[left]);
                temp.add(nums[right]);
                res.add(temp);
                
                left++;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;  // Skip duplicates
                }
            }
        }
        return res;
    }
}