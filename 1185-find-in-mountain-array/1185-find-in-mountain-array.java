class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        // Find peak
        int l = 0, r = mountainArr.length() - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (mountainArr.get(m) < mountainArr.get(m + 1))
                l = m + 1;
            else
                r = m;
        }
        int peakIndex = l;
        
        // Search ascending side
        l = 0; 
        r = peakIndex;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int mid = mountainArr.get(m);
            if (mid == target)
                return m;
            else if (mid < target)
                l = m + 1;
            else
                r = m - 1;
        }
        
        // Search descending side
        l = peakIndex + 1; 
        r = mountainArr.length() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int mid = mountainArr.get(m);
            if (mid == target)
                return m;
            else if (mid > target)
                l = m + 1;
            else
                r = m - 1;
        }
        
        return -1;
    }
}