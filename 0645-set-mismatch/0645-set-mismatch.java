class Solution {
    public int[] findErrorNums(int[] nums) {

       //cycle sort the array
       //duplicate element is not at the correct index
       //index + 1 is the missing number 

       int i = 0;
       while (i < nums.length) {
        int correct_index = nums[i] - 1;
        if (nums[i] != nums[correct_index]) {
            int temp = nums[correct_index];
            nums[correct_index] = nums[i];
            nums[i] = temp; 
        }
        else
            i++;
       }

       for (i = 0; i < nums.length; i++) {
        int correct_value = i + 1;
        if (nums[i] != correct_value)
            return new int[]{nums[i], correct_value};
       }

        return new int[]{-1, -1};
    }
}