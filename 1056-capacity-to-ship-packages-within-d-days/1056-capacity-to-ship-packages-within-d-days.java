class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int l = Arrays.stream(weights).max().orElse(0), r = Arrays.stream(weights).sum();
        int res = r;

        while (l < r) {
            int cap = l + (r - l)/2;

            if (canShip(cap, weights, days)) {
                res = Math.min(res, cap);
                r = cap;
            }
            else
                l = cap + 1;
        }

        return res;
        
    }

    private boolean canShip (int cap, int[] weights, int days) {

        int ships = 1, currCap = cap;

        for (int i = 0; i < weights.length; i++) {
            if (currCap - weights[i] < 0) {
                ships++;
                currCap = cap; 
            }

            currCap -= weights[i];
        }

        return ships <= days;
    }
}