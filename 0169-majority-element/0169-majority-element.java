class Solution {
    public int majorityElement(int[] nums) {
        //sort the array, the element at the mid pos will be the majority
        Arrays.sort(nums);

        int s = 0, e = nums.length - 1;
        int m = s + (e - s)/2;

        return nums[m];
        
    }
}