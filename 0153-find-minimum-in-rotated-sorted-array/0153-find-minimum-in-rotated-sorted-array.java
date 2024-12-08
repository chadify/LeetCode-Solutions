class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        
        // If the array is not rotated, return first element
        if (nums[l] < nums[r]) 
            return nums[l];
        
        while (l < r) {
            int m = l + (r - l) / 2;
            
            // If mid element is greater than the last element, 
            // minimum is in the right half
            if (nums[m] > nums[r]) {
                l = m + 1;
            } 
            // If mid element is less than or equal to the last element, 
            // minimum is in the left half or mid itself
            else {
                r = m;
            }
        }
        
        // When l == r, we've found the minimum element
        return nums[l];
    }
}