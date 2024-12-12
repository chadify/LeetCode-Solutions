class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            int correct_index = nums[i] - 1;
            if (nums[i] != nums[correct_index]) {
                int temp = nums[correct_index];
                nums[correct_index] = nums[i];
                nums[i] = temp;
            }
            else
                i++;
        }

        List<Integer> duplicates = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            int correct_value = i + 1;
            if (nums[i] != correct_value)
                duplicates.add(nums[i]);
        }

        return duplicates;
        
    }
}