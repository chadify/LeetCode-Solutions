class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[left]) { // right portion
                if (nums[mid] < target || nums[left] > target) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }

            else { // left portion
                if (nums[mid] > target || nums[right] < target) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }
}