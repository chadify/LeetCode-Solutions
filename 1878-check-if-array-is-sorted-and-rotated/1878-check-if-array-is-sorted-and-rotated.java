class Solution {
    public boolean check(int[] nums) {
        int len = nums.length;
        int minIndex = 0;
        int minElement = nums[0];

        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[minIndex]) {
                minElement = nums[i];
                minIndex = i;
             }
            else if (nums[i] == minElement && nums[(i-1)%n] > nums[i])
                minIndex = i;
        }

        for (int i = 0; i < len - 1; i++) {
            int index = (i + minIndex) % len;
            int nextIndex = (i + minIndex + 1) % len;
            if (nums[index] > nums[nextIndex])
                return false;
        }
        return true;
    }
}