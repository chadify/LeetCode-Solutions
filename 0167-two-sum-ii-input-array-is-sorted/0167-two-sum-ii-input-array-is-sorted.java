class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int[] res = {-1, -1};
        int start = 0;
        int end = numbers.length - 1;

        while(start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum < target)
                start++;
            else if (sum == target) {
                res[0] = start + 1;
                res[1] = end + 1;
                return res;
            }
            else
                end--;
        }

        return res;
    }
}