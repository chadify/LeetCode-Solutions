class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int i = 0;
        while (i < nums.length) {
            int correct_index = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correct_index]) {
                int temp = nums[correct_index];
                nums[correct_index] = nums[i];
                nums[i] = temp;
            }
            else
                i++;
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return i + 1;
    }
}