class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = search(0, nums.length - 1, target, nums);
        return res;
    }

    private static int[] search(int start, int end, int target, int[] nums) {
        if (start > end) {
            return new int[]{-1, -1}; // Target not found
        }

        int mid = start + (end - start) / 2;

        if (nums[mid] == target) {
            int start_pos = mid;
            int end_pos = mid;

            // Find the start position
            while (start_pos > start && nums[start_pos - 1] == target) {
                start_pos--;
            }

            // Find the end position
            while (end_pos < end && nums[end_pos + 1] == target) {
                end_pos++;
            }

            return new int[]{start_pos, end_pos};
        } else if (target < nums[mid]) {
            return search(start, mid - 1, target, nums);
        } else {
            return search(mid + 1, end, target, nums);
        }
    }
}
