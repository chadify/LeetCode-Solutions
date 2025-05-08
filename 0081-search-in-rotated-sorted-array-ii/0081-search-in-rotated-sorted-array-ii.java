class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l)/2;

            if (nums[m] == target) {
                return true;
            }

            if (nums[l] < nums[m]) { // left portion
                if (nums[m] < target || nums[l] > target) {
                    l = m + 1;
                }
                else {
                    r = m - 1;
                }
            }
            else if (nums[l] > nums[m]) { // right portion
                if (nums[m] > target || nums[r] < target /*  && nums[m] < target */) {
                    r = m - 1;
                }
                else {
                    l = m + 1;
                }
            }
            else { // nums[l] == nums[m]
                l++;
            }
        }

        return false;
    }
}