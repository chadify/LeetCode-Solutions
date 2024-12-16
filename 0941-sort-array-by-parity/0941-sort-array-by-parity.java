class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0, j = 0; // i tracks the current position, j tracks the position of next even number
        
        while (i < nums.length) {
            // Find the next odd number
            while (i < nums.length && nums[i] % 2 == 0) 
                i++;
            
            // Find the next even number after j
            j = Math.max(j, i);
            while (j < nums.length && nums[j] % 2 != 0) 
                j++;
            
            // Swap if both pointers are in bounds
            if (j < nums.length && i < nums.length) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            
            i++; // Move to the next position
        }
        
        return nums;
    }
}