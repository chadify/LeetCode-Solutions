class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        
        // Sort intervals based on start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        
        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);
        
        for (int[] interval : intervals) {
            // Get the end of last interval in merged list
            int currentEnd = currentInterval[1];
            
            // If current interval overlaps with the last merged interval
            if (interval[0] <= currentEnd) {
                // Update the end time if needed
                currentInterval[1] = Math.max(currentEnd, interval[1]);
            } else {
                // No overlap, add new interval to merged list
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
    }
}