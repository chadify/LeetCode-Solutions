class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        // Initialize sum with the first possible three numbers instead of MAX_VALUE
        int sum = nums[0] + nums[1] + nums[2];
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for i
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int temp_sum = nums[i] + nums[left] + nums[right];
                
                if (temp_sum == target) {
                    return temp_sum;  // Found exact match, return immediately
                } 
                
                if (Math.abs(temp_sum - target) < Math.abs(sum - target)) {
                    sum = temp_sum;  // Update sum if we found a closer value
                }
                
                if (temp_sum < target) {
                    left++;
                    // Skip duplicates for left
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else {
                    right--;
                    // Skip duplicates for right
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        
        return sum;
    }
}