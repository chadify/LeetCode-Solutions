class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1, right = Arrays.stream(piles).max().getAsInt();
        int res = right;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (findHours(mid, piles) <= h) {
                res = Math.min(res, mid);
                right = mid - 1;
            }
            else 
                left = mid + 1;
        }

        return res;
    }

    private int findHours(int speed, int[] array) {
        int hours = 0;

        for (int i = 0; i < array.length; i++) {
            hours += Math.ceil((double)array[i]/speed);
        }

        return hours;
    }
}