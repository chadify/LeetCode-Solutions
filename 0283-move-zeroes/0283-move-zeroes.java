class Solution {
    public void moveZeroes(int[] nums) {
        for (int j = 0, i = 0; j < nums.length; j++, i++) {
            while (i < nums.length && nums[i] != 0)
                i++;
            j = i;
            while (j < nums.length && nums[j] == 0)
                j++;
            if (j < nums.length) {
                nums[i] = nums[j];
                nums[j] = 0;
            }
        }
    }
}