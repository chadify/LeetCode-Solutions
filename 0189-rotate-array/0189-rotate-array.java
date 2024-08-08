class Solution {
    public void rotate(int[] nums, int k) {
            
        k %= nums.length;

        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k-1);
        reverseArray(nums, k, nums.length -1);

    }

    private void reverseArray(int[] array, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            // Swap the elements
            int temp = array[startIndex];
            array[startIndex] = array[endIndex];
            array[endIndex] = temp;

            // Move the pointers
            startIndex++;
            endIndex--;
        }
    }
}