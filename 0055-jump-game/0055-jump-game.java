class Solution {
    public boolean canJump(int[] nums) {

        int fuel = 0;

        for (int i = 0; i < nums.length; i++, fuel--) {
            if (fuel < 0)
                return false;
            
            if (nums[i] > fuel)
                fuel = nums[i];
        }

        return true;
    }
}