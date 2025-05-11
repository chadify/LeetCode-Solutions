class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1, r = Arrays.stream(nums).max().orElseThrow();
        int res = r;

        while (l <= r) {
            int m = l + (r - l)/2;

            if (rem_sum(nums, m) <= threshold) {
                res = Math.min(m, res);
                r = m - 1;          
            }
            else {
                l = m + 1;
            }
        }

        return res;
    }

    public static int rem_sum(int[] array, int divisor) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += Math.ceil((float)array[i]/divisor);
        }

        return sum;
    }
}