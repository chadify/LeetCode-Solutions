class Solution {
    public int[] findRightInterval(int[][] intervals) {

        // sort the intervals
        
        int n = intervals.length;
        
        // List to store pairs of (start, end) and their original index
        List<int[]> sorted = new ArrayList<>();

        // Populate the sorted list with {start, end, original_index}
        for (int i = 0; i < n; i++) {
            sorted.add(new int[]{intervals[i][0], intervals[i][1], i});
        }

        Collections.sort(sorted, Comparator.comparingInt(a -> a[0]));

                // Result array to store the index of the right interval for each interval
        int[] result = new int[n];

        // For each interval, perform binary search to find the right interval
        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            int idx = binarySearch(sorted, end);
            result[i] = idx;
        }

        return result;
    }

    // Helper method for binary search to find the smallest start >= target
    private static int binarySearch(List<int[]> sorted, int target) {
        int low = 0, high = sorted.size() - 1;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sorted.get(mid)[0] >= target) {
                res = sorted.get(mid)[2];  // Store original index of the interval
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

}