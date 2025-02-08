class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            while (i < nums.length && nums[i] == 1) {
                temp++;
                i++;
            }
            if (temp > count)
                count = temp;
        }

        return count;
        
    }
}