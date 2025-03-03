class Solution {
    public int maxProfit(int[] prices) {
        int profit = Integer.MIN_VALUE;
        int i = 0, j = i + 1;

        while (j < prices.length) {
            int curprofit = prices[j] - prices[i];
            if (curprofit < 0)
                i = j;
            if (curprofit > profit)
                profit = curprofit;
            j++;
        }

        if (profit < 0)
            return 0;
        return profit;
    }
}