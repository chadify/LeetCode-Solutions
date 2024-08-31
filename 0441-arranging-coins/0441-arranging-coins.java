class Solution {
static int arrangeCoins(int n) {

    int start = 0;
    int end = (int)Math.sqrt(2L * n);
    
    while (start <= end) {
        int mid = start + (end - start) / 2;
        long sum = (long)mid * (mid + 1) / 2;
        
        if (sum == n) {
            return mid;
        } else if (sum < n) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }
    
    return end;
}

}