class Solution {
    public int findPeakElement(int[] nums) {

        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (mid > 0 && nums[mid] < nums[mid - 1])
                end = mid - 1;
            else if (mid < nums.length - 1 && nums[mid] < nums[mid + 1])
                start = mid + 1;
            else 
                return mid;
        }
        return -1;

    }
}