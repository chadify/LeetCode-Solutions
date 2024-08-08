class Solution {
    public void sortColors(int[] nums) {

        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[j];
                nums[j++] = nums[i]; 
                nums[i] = temp;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int temp = nums[j];
                nums[j++] = nums[i]; 
                nums[i] = temp;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 2) {
                int temp = nums[j];
                nums[j++] = nums[i]; 
                nums[i] = temp;
            }
        }
    }
}