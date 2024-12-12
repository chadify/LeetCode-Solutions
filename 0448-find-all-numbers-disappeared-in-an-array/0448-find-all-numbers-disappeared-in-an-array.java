class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            int correct_index = nums[i] - 1;
            if (nums[correct_index] != nums[i]) {
                //swap nums[i] to correct_index
                int temp = nums[correct_index];
                nums[correct_index] = nums[i];
                nums[i] = temp;
            }
            else
                i++;
        }
        
        List<Integer> missing_integers = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            int correct_index = nums[i] - 1;
            if (i != correct_index)
                missing_integers.add(i+1);//add i + 1 to the list
        }

        return missing_integers;
    }
}