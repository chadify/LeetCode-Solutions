class Solution {
    public int findPeakElement(int[] nums) {
        // Handle single element case
        if (nums.length == 1) {
            return 0;
        }
        
        int l = 0, r = nums.length - 1;
        
        while (l <= r) {
            int m = l + (r - l)/2;
            
            // Check if m is a peak
            if ((m == 0 || nums[m] > nums[m-1]) && 
                (m == nums.length-1 || nums[m] > nums[m+1])) {
                return m;
            }
            
            // Decide which direction to search
            if (m < nums.length-1 && nums[m] < nums[m+1]) {
                l = m + 1;
            }
            else {
                r = m - 1;
            }
        }
        
        return -1; // Shouldn't reach here if valid input
    }
}