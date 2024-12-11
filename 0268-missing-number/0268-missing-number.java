class Solution {
    public int missingNumber(int[] nums) {
        // array size n, possible elements n + 1
        // sort the array using cycle sort
        // find the missing number
            // put the numbers into respective indices
            // 

        int i = 0;
        int n = nums.length;

        while (i < nums.length) {
            if (nums[i] != n && nums[i] != i) {
                //swap i with nums[i]
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
            else
                i++;
        }

        for (i = 0; i < nums.length; i++){
            if (nums[i] != i)
                return i;
        }

        return n;
    }
}