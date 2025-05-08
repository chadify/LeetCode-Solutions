class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        
        while (l <= r) {
            int m = l + (r - l)/2;
            int index;
            
            // Handle edge cases and check adjacent elements
            if (m > 0 && nums[m] == nums[m-1]) {
                index = m - 1;  // Point to the first occurrence of the pair
            }
            else if (m < nums.length-1 && nums[m] == nums[m+1]) {
                index = m;  // Point to the first occurrence of the pair
            }
            else {
                return nums[m];  // Found the single element
            }
            
            // Adjust search based on position of the pair
            if (index % 2 == 0) {
                l = m + 1;  // The single element is on the right
            }
            else {
                r = m - 1;  // The single element is on the left
            }
        }
        
        return -1;  // Should not reach here if input is valid
    }
}