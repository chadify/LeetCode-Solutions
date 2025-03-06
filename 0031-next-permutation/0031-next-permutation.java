class Solution {
    public void nextPermutation(int[] nums) {

        int index = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
        // reverse
            reverse(-1, nums);
            return;
        }

        // find smallest
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                swap(index, i, nums);
                break;
            }
        }

        // reverse
        reverse(index, nums);
    }

    private static void reverse(int index, int[] array) {
        int i = index + 1;
        int j = array.length - 1;
        while (i < j) {
            swap(i, j, array);
            i++;
            j--;
        }
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}